#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 24 23:47:46 2019

@author: wangpeiyu
"""
import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfTransformer
from sklearn.linear_model import SGDClassifier
from sklearn import metrics
import pickle
import numpy as np
import json
import csv
from sklearn.metrics.pairwise import cosine_similarity

pd_component_and_word = pickle.load(open('component_and_word.pkl', 'rb'))
pd_component_and_word_T = pickle.load(open('component_and_word_T.pkl', 'rb'))
pd_component_and_document = pickle.load(open('component_and_document.pkl', 'rb'))
pd_component_and_document_T = pickle.load(open('component_and_document_T.pkl', 'rb'))
#print (pd_component_and_document)

topic_1_keyword_document = pd_component_and_document.iloc[0]
topic_1_keyword_document_value=topic_1_keyword_document.values


topic1_similarity_list = []
"""raw_reviews = []
raw_reviews_id = []

raw_reviews_username = []
raw_reviews_utc = []"""

# Testing the accuracy of the LSA result, if the dot product of the vector is 1
#print (np.dot(topic_1_keyword_document_value, topic_1_keyword_document_value))

n = 100

"""openfile = 'tutorial_11_data.json'
inputf = open(openfile,'r')

raw_reviews.append("topic_1_keywords")
raw_reviews.append("topic_2_keywords")

raw_reviews_username.append("topic_1_keywords")
raw_reviews_username.append("topic_2_keywords")

raw_reviews_utc.append(0)
raw_reviews_utc.append(0)

for line in inputf:
    data = json.loads(line)
    username = data['author']
    bodytext = data['body'].lower().encode('ascii','ignore')
    utc = data['created_utc']
    raw_reviews.append(bodytext)
    raw_reviews_username.append(username)
    raw_reviews_utc.append(utc)"""

for i in range(0,n+2):
    this_document = pd_component_and_document.iloc[i]
    this_document_value = this_document.values
    
    # why are we using not product here?
    topic1_similarity_score = np.dot(this_document_value, topic_1_keyword_document_value)
    topic1_similarity_list.append(topic1_similarity_score)
    
    
#print (len(raw_reviews))
print (len(topic1_similarity_list))

pd_document_and_similarity = pd.DataFrame(list(topic1_similarity_list),columns = ["similarity"])

outputf2 = open('pd_component_and_word_T.csv','w')
pd_component_and_word_T.to_csv(outputf2, index=True, header=True)
outputf2.close()

outputf3 = open('pd_document_and_similarity.csv','w')
pd_document_and_similarity.to_csv(outputf3, index=True, header=True)
outputf3.close()

cosine=np.mean(pd_document_and_similarity,axis=0)
print(cosine)
