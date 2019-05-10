#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 24 16:41:28 2019

@author: wangpeiyu
"""

import csv
import re
import time
import json
import pickle
import warnings
import random
import numpy as np
np.set_printoptions(threshold=1)

from nltk.tokenize import RegexpTokenizer
from nltk.stem.porter import PorterStemmer
p_stemmer = PorterStemmer()
from sklearn.feature_extraction.text import CountVectorizer
from bs4 import BeautifulSoup
import pandas as pd
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn import metrics
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.ensemble import RandomForestClassifier
from sklearn.decomposition import TruncatedSVD
from sklearn.preprocessing import Normalizer

import pandas as pd
#vocab_nips=pd.read_csv("vocab.nips.txt",header=None)
#vocab_enron=pd.read_csv("vocab.enron.txt",header=None)
vocab_kos=pd.read_csv("vocab.kos.txt",header=None)

#vocab_nips.columns=['word']
#vocab_enron.columns=['word']
vocab_kos.columns=['word']
#print(vocab_nips)
#docword_nips=pd.read_csv("docword.nips.txt",delim_whitespace=True, header=None)
#docword_nips.columns=['doc','word_index','word_frequency']
#docword_enron=pd.read_csv("docword.enron.txt",delim_whitespace=True, header=None)
#docword_enron.columns=['doc','word_index','word_frequency']
docword_kos=pd.read_csv("docword.kos.txt",delim_whitespace=True, header=None)
docword_kos.columns=['doc','word_index','word_frequency']
#print(docword_nips)

    


kos_word_list=[]
#print(word_index)
for j in range(3431):
    word_list=[]
    for i in range(len(docword_kos)):
        if docword_kos.iloc[i,0]==j:
            word_index=docword_kos.iloc[i,1]-1
            for num in range(docword_kos.iloc[i,2]):
                word_list.extend(vocab_kos.iloc[word_index,0])
    print(j)
    kos_word_list.append(word_list)
print(kos_word_list)

#clean_train_reviews=filter(None, clean_train_reviews)
maxfeature_num=300
components_number=101
component_list = []
for i in range(1,components_number+1):
    component_name = "component" + str(i) 
    component_list.append(component_name)

vectorizer = CountVectorizer(max_df=0.99,min_df=3,ngram_range=(1,1),max_features=maxfeature_num)
#vectorizer = TfidfVectorizer(max_df=0.99,min_df=3,ngram_range=(1,1),max_features=maxfeature_num)
train_data_features = vectorizer.fit_transform(kos_word_list)
pd_head10 = pd.DataFrame(train_data_features.toarray(),index=kos_word_list,columns=vectorizer.get_feature_names())
lsa = TruncatedSVD(n_components=components_number, n_iter=1)
trainset_X_LSA = lsa.fit_transform(train_data_features)
normalizer = Normalizer(copy=False)
trainset_X_LSA = normalizer.fit_transform(trainset_X_LSA)

# attch the LSA result with each documents. 
pd_component_and_word = pd.DataFrame(lsa.components_,index = component_list,columns = vectorizer.get_feature_names())
pd_component_and_document = pd.DataFrame(trainset_X_LSA, index = kos_word_list, columns = component_list)
pd_component_and_word_T = pd.DataFrame(lsa.components_.T,index = vectorizer.get_feature_names(),columns = component_list)
pd_component_and_document_T = pd.DataFrame(trainset_X_LSA.T, index = component_list, columns = kos_word_list)
# Save each pandas dataframe into pickle format
pickleoutput_1 = open('component_and_word.pkl', 'wb')
pickleoutput_2 = open('component_and_document.pkl', 'wb')
pickleoutput_3 = open('component_and_word_T.pkl', 'wb')
pickleoutput_4 = open('component_and_document_T.pkl', 'wb')
pickle.dump(pd_component_and_word, pickleoutput_1)
pickle.dump(pd_component_and_document, pickleoutput_2)
pickle.dump(pd_component_and_word_T, pickleoutput_3)
pickle.dump(pd_component_and_document_T, pickleoutput_4)

print ("LSA space is created with "+ str(components_number)+" components, " + "each component contains " +str(maxfeature_num)+ " features(token).")

pickleoutput_1.close()
pickleoutput_2.close()
pickleoutput_3.close()
pickleoutput_4.close()
centroid=np.mean(pd_component_and_document)
print(centroid)