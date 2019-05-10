#!/usr/bin/env python
# coding: utf-8

# In[20]:


"""
author - Wang Peiyu
"""
import pandas as pd
data=pd.read_csv("u.data", sep="\t", header=None)
data.columns=['user_id','item_id','rating','timestamp']
print(data)
print(data.dtypes)


# In[53]:



#dataset preprocessing
user_id_list=data['user_id'].unique().tolist()
print(len(user_id_list))
item_id_list=data['item_id'].unique().tolist()
print(len(item_id_list))
already_checked_index=[]
user_item=pd.DataFrame()
print(min(user_id_list))
print(min(item_id_list))
for item in item_id_list:
    print(item)
    user_list=[]
    rating_list=[]
    for i in range(100000):
        #print(data.iloc[i,0]==user)
        if data.iloc[i,1]==item:
            user_list.append(data.iloc[i,0])
            rating_list.append(data.iloc[i,2])
            #already_checked_index.append(i)
    print(np.unique(rating_list))
    ratings=np.zeros(943)
    for j in range(len(user_list)):
        index=user_list[j]-1
        ratings[index]=rating_list[j]
    print(ratings)
    user_item[str(item)]=ratings
print(user_item)


# In[ ]:


def rmse(prediction, ground_truth):
    prediction = prediction[ground_truth.nonzero()].flatten() 
    #print(prediction)
    ground_truth = ground_truth[ground_truth.nonzero()].flatten()
    return np.sqrt(((prediction-ground_truth)**2).mean(axis=None)) #((A - B)**2).mean(axis=ax)


# In[106]:


import matplotlib.pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')
import numpy as np
def SGD(z,learning_rate,feature,epochs):#almost all computations in np is O(n)
    """
    z is a training matrix that has the shape of m*n, m is the number of users and n is the number of items
    learning_rate,
    epochs= # of iterations
    print the cost history over for each iterations
    """
    m=z.shape[0]
    n=z.shape[1]
    z_train=z[:800]#partition Z into two sets
    z_test=z[800:]#training and testing sets
    cost_history=np.zeros(epochs)
    val_errors=[]
    x=5 * np.random.rand(feature,m)#initialize X randomly
    y=5 * np.random.rand(feature,n)#initialize Y randomly
    z_train_array=np.asarray(z_train)
    users,items = np.nonzero(z_train_array)
    print(zip(users,items))
    for epoch in range(epochs):
        error_list=[]
        for u, i in zip(users,items):
            e = z_train.iloc[u, i] - np.dot(x[:,u].T,y[:,i])  # Calculate error for gradient update
            error_list.append(e)
            x[:,u] = x[:,u].astype(float)+learning_rate * ( e * y[:,i] ) # Update latent user feature matrix
            y[:,i] = y[:,i].astype(float)+learning_rate * ( e * x[:,u] )
        #RMSE=np.sqrt(np.mean(np.sum(np.square(error_list))))
        train_RMSE=rmse(np.dot(x.T,y),z_train_array)
        test_RMSE = rmse(np.dot(x.T,y),np.asarray(z_test))
        val_errors.append(test_rmse)
        cost_history[epoch]=train_RMSE# Update latent item feature matrix
    print(cost_history)
    plt.plot(range(epochs), cost_history, marker='o', label='Training Data');
    plt.plot(range(epochs), val_errors, marker='v', label='Validation Data');
    plt.xlabel('Number of Epochs');
    plt.ylabel('RMSE');
    plt.legend()
    plt.grid()
    plt.show()


        #Time Complexity: hard to say because matrix multiplication is a major concern in this algorithm and the time complexity of different matrix multiplication varies


# In[107]:


print("k=10, epochs =40 : ")
SGD(user_item,0.001,10,40)#0.05638
print("k=10, epochs =80 : ")
SGD(user_item,0.001,10,80)#0.0537
print("k=10, epochs =120 : ")
SGD(user_item,0.001,10,120)#0.8221
print("k=10, epochs =160 : ")
SGD(user_item,0.001,10,160)#0.6709
print("k=10, epochs =200 : ")
SGD(user_item,0.001,10,200)#0.5819


# In[108]:


print("k=20, epochs =40 : ")
SGD(user_item,0.001,20,40)#1.0438
print("k=20, epochs =80 : ")
SGD(user_item,0.001,20,80)#0.9383
print("k=20, epochs =120 : ")
SGD(user_item,0.001,20,120)#0.7974
print("k=20, epochs =160 : ")
SGD(user_item,0.001,20,160)#0.6718
print("k=20, epochs =200 : ")
SGD(user_item,0.001,20,200)#0.5680


# In[109]:


print("k=30, epochs =40 : ")
SGD(user_item,0.001,30,40)#1.0402
print("k=30, epochs =80 : ")
SGD(user_item,0.001,30,80)#0.9357
print("k=30, epochs =120 : ")
SGD(user_item,0.001,30,120)#0.7814
print("k=30, epochs =160 : ")
SGD(user_item,0.001,30,160)#0.6718
print("k=30, epochs =200 : ")
SGD(user_item,0.001,30,200)#0.5715


# In[121]:


import scipy.special
import math

def FSGD(z,learning_rate,fractional_learning_rate,epochs,feature,fractional_order): 
    """
    z is a training matrix that has the shape of m*n, m is the number of users and n is the number of items
    learning_rate,
    epochs= # of iterations
    print the cost history over for each iterations
    fractional_order & fractional_learning_rate: unique for FSGD
    """
    m=z.shape[0]
    n=z.shape[1]
    z_train=z[:800]
    z_test=z[800:]
    cost_history=np.zeros(epochs)
    val_errors=[]
    x=5 * np.random.rand(feature,m)#initialize X randomly
    y=5 * np.random.rand(feature,n)#initialize Y randomly
    z_train_array=np.asarray(z_train)
    users,items = np.nonzero(z_train_array)
    print(zip(users,items))
    for epoch in range(epochs):
        error_list=[]
        for u, i in zip(users,items):
            e = z_train.iloc[u, i] - np.dot(x[:,u].T,y[:,i])  # Calculate error for gradient update
            error_list.append(e)
            x[:,u] = x[:,u].astype(float)+learning_rate*(e*y[:,i])+fractional_learning_rate/math.factorial(int(1-fractional_order+0.5))*e*np.multiply(y[:,i],np.power(np.absolute(x[:,u]),(1-fractional_order))) # Update latent user feature matrix
            y[:,i] = y[:,i].astype(float)+learning_rate*e*x[:,u]+fractional_learning_rate/math.factorial(int(1-fractional_order+0.5))*e*np.multiply(x[:,u],np.power(np.absolute(y[:,i]),(1-fractional_order)))
        #RMSE=np.sqrt(np.mean(np.sum(np.square(error_list))))
        train_RMSE=rmse(np.dot(x.T,y),z_train_array)
        test_RMSE = rmse(np.dot(x.T,y),np.asarray(z_test))
        val_errors.append(test_rmse)
        cost_history[epoch]=train_RMSE
    print(cost_history)
    plt.plot(range(epochs), cost_history, marker='o', label='Training Data');
    plt.plot(range(epochs), val_errors, marker='v', label='Validation Data');
    plt.xlabel('Number of Epochs');
    plt.ylabel('RMSE');
    plt.legend()
    plt.grid()
    plt.show()


# In[122]:


print("k=10, epochs =40, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,40,10,0.25)#0.0338, better than SGD when k=10 and epochs=40
print("k=10, epochs =80, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,80,10,0.25)#0.0347
print("k=10, epochs =120, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,120,10,0.25)#0.0385
print("k=10, epochs =160, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,160,10,0.25)
print("k=10, epochs =200, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,200,10,0.25)


# In[123]:


print("k=10, epochs =40, fractional order=0.5 : ")
FSGD(user_item,0.001,0.001,40,10,0.5)
print("k=10, epochs =80, fractional order=0.5 : ")
FSGD(user_item,0.001,0.001,80,10,0.5)
print("k=10, epochs =120, fractional order=0.5 : ")
FSGD(user_item,0.001,0.001,120,10,0.5)
print("k=10, epochs =160, fractional order=0.5 : ")
FSGD(user_item,0.001,0.001,160,10,0.5)
print("k=10, epochs =200, fractional order=0.5 : ")
FSGD(user_item,0.001,0.001,200,10,0.5)


# In[125]:


print("k=10, epochs =40, fractional order=0.75 : ")
FSGD(user_item,0.001,0.001,40,10,0.75)
print("k=10, epochs =80, fractional order=0.75 : ")
FSGD(user_item,0.001,0.001,80,10,0.75)
print("k=10, epochs =120, fractional order=0.75 : ")
FSGD(user_item,0.001,0.001,120,10,0.75)
print("k=10, epochs =160, fractional order=0.75 : ")
FSGD(user_item,0.001,0.001,160,10,0.75)
print("k=10, epochs =200, fractional order=0.75 : ")
FSGD(user_item,0.001,0.001,200,10,0.75)


# In[124]:


print("k=20, epochs =40, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,40,20,0.25)
print("k=20, epochs =80, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,80,20,0.25)
print("k=20, epochs =120, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,120,20,0.25)
print("k=20, epochs =160, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,160,20,0.25)
print("k=20, epochs =200, fractional order=0.25 : ")
FSGD(user_item,0.001,0.001,200,20,0.25)


# In[ ]:




