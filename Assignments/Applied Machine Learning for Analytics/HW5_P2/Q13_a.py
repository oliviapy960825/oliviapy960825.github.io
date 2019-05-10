#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Apr 27 21:33:51 2019

@author: wangpeiyu
"""

import csv
import re
import time
import json
from time import gmtime, strftime, localtime
import datetime
import calendar
from datetime import date, timedelta
import uuid
from nltk.tokenize import RegexpTokenizer
from nltk.stem.porter import PorterStemmer
import codecs
import re
import nltk
from operator import itemgetter
from sklearn.feature_extraction.text import CountVectorizer
import os
import io
import numpy as np
import lda
from pandas import DataFrame
import pickle
from sklearn.model_selection import KFold

tokenizer = RegexpTokenizer(r'\w+')

# create English stop words list
from nltk.corpus import stopwords
en_stop = stopwords.words("english")

# Create p_stemmer of class PorterStemmer
p_stemmer = PorterStemmer()

texts = []

# This for-loop is reading and cleaning the nysk.json data

for ib in range(1,2):
    inputf=io.open('anti-vaccine.json', 'r',  encoding='utf8',errors='ignore')
    linenum = 0;
    for line in inputf:
        whetheraboutvaccine = False
        data = json.loads(line)
        bodytexto = data['full_text'].encode('utf-8')
        bodytext = re.sub(r'[^\x00-\x7f]',r' ',bodytexto.decode("utf-8"))
        bodytextlower = bodytext.lower()
        timestamptext = int(data['created_at'][8:10]) # because the raw data is from one year, we have to look into day -- Dian

        tokens = tokenizer.tokenize(bodytextlower)
        stopped_tokens = [i for i in tokens if not i in en_stop]
        stemmed_tokens = [p_stemmer.stem(i) for i in stopped_tokens]

        texts.append(stemmed_tokens)
        
    inputf.close()

# This convert the json list into a string format so that lda package can process it.

text_purestring = []
for item in texts:
    emtrys=""
    for token in item:
        emtrys=emtrys+token+" "
    text_purestring.append(emtrys)

# you all know this part now
vect = CountVectorizer(min_df=0.01, max_df=0.99,ngram_range=(1, 2))
X = vect.fit_transform(text_purestring)
print(X)

# make bigrams obvious with "-"
feature_name = vect.get_feature_names()
for index,item in enumerate(feature_name):
    feature_name[index]=item.replace(" ", "-")

output_pickle_2 = open('anti_vaccine_feature_name.pkl', 'wb')
pickle.dump(feature_name, output_pickle_2)
output_pickle_2.close()

# Train the LDA model
model = lda.LDA(n_topics=9, n_iter=100, random_state=1)
model.fit(X)
log_likelihoods=model.loglikelihood()

print(log_likelihoods)

#cannot use perplexity to choose topic number in this question, therefore, use loglikelihood instead, the bigger the loglikelihood is the better
#perplexity=np.exp(-log_likelihoods/len(texts))
#print(perplexity)
# Save the LDA model

output_pickle = open('anti_vaccine.pkl', 'wb')
pickle.dump(model, output_pickle)
output_pickle.close()
  

