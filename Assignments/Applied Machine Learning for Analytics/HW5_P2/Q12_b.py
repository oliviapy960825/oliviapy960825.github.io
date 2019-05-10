#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr 25 22:31:18 2019

@author: wangpeiyu
"""

from time import gmtime, strftime, localtime
from datetime import date, timedelta
from nltk.tokenize import RegexpTokenizer
from nltk.stem.porter import PorterStemmer
import nltk
from operator import itemgetter
from sklearn.feature_extraction.text import CountVectorizer
import numpy as np
import lda
import pandas as pd
import pickle
import random

# create English stop words list
from nltk.corpus import stopwords
en_stop = stopwords.words("english")

# Create p_stemmer of class PorterStemmer
p_stemmer = PorterStemmer()

# Load the the trained LDA model

model = pickle.load(open('LDA_2018.pkl', 'rb'))
feature_name =  pickle.load(open('LDA_2018_feature_name.pkl', 'rb'))

# The following block's function is to display the top 10
# most-representative tokens (unigram or bigrams) in each topic.
# Note the topic index start with 0, not 1. 
topic_word = model.topic_word_
n_top_words = 10
topic_words_frame = []
for i, topic_dist in enumerate(topic_word):
    topic_words = np.array(feature_name)[np.argsort(topic_dist)][:-(n_top_words+1):-1]
    topic_words_frame.append('Topic {}: {}'.format(i, ' '.join(topic_words)))
print(topic_words_frame)

# The following block formats the document-topic matrix so that we can see which are the most representative topics in each document.
# The columns index is the topic id, and the row index is the document number
document_topic_matrix_in_prob = pd.DataFrame(model.doc_topic_.T)
document_topic_matrix_in_frequency = pd.DataFrame(model.ndz_.T)

# Create a column of time of the documents
number_of_entry=document_topic_matrix_in_frequency.shape[1]
days= []
nysk=pd.read_json("nysk.json", lines=True)
#print(nysk['year'][0][8:10])
for i in range(len(nysk)):
    days.append(int(nysk['year'][i][8:10]))
print(days)

# Make a copy of the orginal dataframe without the dummy year.
document_topic_matrix_in_frequency_with_day = document_topic_matrix_in_frequency.copy()
# Now we have a new dataframe with a new row of made up year!
document_topic_matrix_in_frequency_with_day.loc["day"] = days

# The following block tracks how the frequency of topic_id X changes over years.
x = 10
# Initiate year token dictionary
token_of_topic_in_each_day={}
for i in range(min(days),max(days)+1):
    token_of_topic_in_each_day[i]=0

# Add the token frequency to each year
for index, row in document_topic_matrix_in_frequency_with_day.T.iterrows(): # Transform for easy interation
    token_of_topic_in_each_day[row["day"]] += row[x]

print (token_of_topic_in_each_day)
# For question 12, perplexity can be found at http://qpleple.com/perplexity-to-evaluate-topic-models/"""
