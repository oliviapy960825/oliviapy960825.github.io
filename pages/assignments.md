---
layout: page
title: labs & assignments
description: Wang Peiyu's assignments
---


<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li><a href="#DataAnalyticsIntroductionAndPracticum">Data Analytics Introduction and Practicum Assignments & Projects</a></li>
            <li><a href="#ProgrammingForAnalytics">Programming For Analytics Assignments & Projects</a></li>
            <li><a href="#DataAnalysisForEngNSci">Data Analysis for Eng & Sci Assignments & Projects</a></li>
            <li><a href="#Algorithms">Design and Analysis of Algorithms Assignments & Projects</a></li>
            <li><a href="#DBMSForDataAnalytics">DBMS For Data Analytics Assignments & Projects</a></li>
            <li><a href="#AppliedMachineLearningForAnalytics">Applied Machine Learning For Analytics Assignments & Projects</a></li>
        </ul>
    </div>
</div>


### <a name="DataAnalyticsIntroductionAndPracticum"></a> Data Analytics Introduction and Practicum Assignments & Projects
####  <a name="Assignment1"></a>Assignment1
##### <a name="datamanipulationandaggregation"></a>data maniuplation and aggregation
* [Lab: Exploratory Data Analysis for Classification using Pandas and Matplotlib](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_eda/lab3.ipynb)

{the goals of this assignment are:
      To practice data manipulation with Pandas
      To develop intuition about the interplay of precision, accuracy, and bias when making predictions
      To better understand how election forecasts are constructed}


##### <a name="visualization"></a>visualization
* [Lab: Exploratory Data Analysis for Classification using Pandas and Matplotlib](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_eda/lab3.ipynb)

{Applying different visualization techniques to Part 1}
{Project Proposal also attached below}

Results | Research Proposal
---|---
<a href="https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/HW1.ipynb">Assignment1</a>|<a href="https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Research%20Proposal.txt">Research Proposal</a>

---


####  <a name="Assignment2"></a>Assignment2
##### <a name="scientificcomputing"></a>scientific computing
* [Lab: Scikit-Learn, Regression, PCA](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_scikitlearn_regression_pca/Lab4.ipynb)

{ The goal of this assignment is to introduce Scikit-Learn and its functions, Regression, and PCA, and still more regression.  All objects within scikit-learn share a uniform common basic API consisting of three complementary interfaces: an estimator interface for building and ﬁtting models, a predictor interface for making predictions and a transformer interface for converting data.  The estimator interface is at the core of the library. It deﬁnes instantiation mechanisms of objects and exposes a fit method for learning a model from training data. All supervised and unsupervised learning algorithms (e.g., for classiﬁcation, regression or clustering) are oﬀered as objects implementing this interface. Machine learning tasks like feature extraction, feature selection or dimensionality reduction are also provided as estimators.}


##### <a name="statisticalanalysis"></a>statistic alanalysis
* [Lab: Bias, Variance, Cross-Validation](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_bias_variance_crossvalidation/Lab5.ipynb)
* [Lab: Bayes, Linear Regression, and Metropolis Sampling](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_bayes_linearregression_sampling/BayesLinear.ipynb)

{In this lab, and in homework 2, we alluded to cross-validation with a weak explanation about finding the right hyper-parameters, some of which were regularization parameters. We will have more to say about regularization soon, but lets tackle the reasons we do cross-validation. The bottom line is: finding the model which has an appropriate mix of bias and variance. We usually want to sit at the point of the tradeoff between the two: be simple but no simpler than necessary.  We do not want a model with too much variance: it would not generalize well.  This phenomenon is also called overfitting. There is no point doing prediction if we cant generalize well. At the same time, if we have too much bias in our model, we will systematically underpredict or overpredict values and miss most predictions. This is also known as underfitting.  Cross-Validation provides us a way to find the "hyperparameters" of our model, such that we achieve the balance point.}

| Results                | Repository                 |
| ---------------------- |:--------------------------:|
| <a href="https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Assignments/HW2.ipynb">Assignment2</a>| <a href="https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/HW2.ipynb">[assignment2 repositiory]</a>|

---


####  <a name="Assignment3"></a>Assignment3
##### <a name="deeplearning"></a>machine learning part1
* [Lab: Neural Networks](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_neuralnetworks_svm/Lab_10.ipynb)

{Classification

Identifying to which category an object belongs to.
Applications: Spam detection, Image recognition.
Algorithms: SVM, nearest neighbors, random forest, …

Regression

Predicting a continuous-valued attribute associated with an object.
Applications: Drug response, Stock prices.
Algorithms: SVR, ridge regression, Lasso, …

Clustering

Automatic grouping of similar objects into sets.
Applications: Customer segmentation, Grouping experiment outcomes
Algorithms:  k-Means, spectral clustering, mean-shift, …
}


##### <a name="machinelearning"></a>machine learning part2
* [Lab: Support Vector Machines](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_neuralnetworks_svm/Lab_10.ipynb)

{Dimensionality reduction

Reducing the number of random variables to consider.
Applications: Visualization, Increased efficiency
Algorithms: PCA, feature selection, non-negative matrix factorizations

Model selection

Comparing, validating and choosing parameters and models.
Goal: Improved accuracy via parameter tuning
Modules:  grid search, cross validation, metrics.

Preprocessing

Feature extraction and normalization.
Application: Transforming input data such as text for use with machine learning algorithms.
Modules: preprocessing, feature extraction.
}


| Results                | Repository                 |
| ---------------------- |:--------------------------:|
| <a href="https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Assignments/HW3.ipynb">Assignment3 </a>| <a href="https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/HW3.ipynb">Assignment3 Repository </a>|

---



####  <a name="Assignment4"></a>Extra Lab
##### <a name="networkanalysis"></a>network analysis
* [Lab: Networks](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_networks_graphs/lab_9.ipynb)

{In this lab we will do the following:

    1. Get a LinkedIn API key
    2. Use oauth2 to get an acceess token
    3. First we are going to download our own LinkedIn data using the LinkedIn API.
    4. Then we are exporting this data as a csv file to be able to import it into Gephi.
    5. Before starting Gephi we will do some network analysis directly in python
    6. We will analyze our data with the external tool Gephi
}


##### <a name="bigdataanalytics"></a>big data analytics
* [Lab: MapReduce](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_mapreduce/lab8_mapreduce.ipynb)

{In this week's lab, we will mostly ignore statistics and instead focus on some practical issues that you will encouter on Homework 4. Section 4 of that homework includes new python techniques (classes, inheritance), an unfamiliar approach to breaking up large computing problems (MapReduce), code that has to be run outside the friendly confines of an ipython notebook, and then you are asked to put it all to use on Amazon's Elastic Compute Cloud (EC2). This sounds very complicated, but the end result is a simpler algorithm for that problem of calculating similarity scores, as well as the ability to expand to arbitrarily large data sets.}


---


####  <a name="ExtraCredit"></a>Extra Lab2
##### <a name="webscraping"></a>webs craping
* [Lab: Web Scraping Part 1](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_webscraping/Lab_2_A_Live.ipynb)
[Lab: Web Scraping Part 2](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_webscraping/Lab_2_B_Live.ipynb)
{In this example we will fetch data about countries and their population from Wikipedia}


##### <a name="textprocessing"></a>sampling and text processing
* [Lab: Sampling and Text Processing ](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_sampling_textprocessing/GibbsSampler.ipynb)

{In this example we will see how to sample data and do text processing}

---


#### EMSE 6992 Labs
##### <a name="labassignments"></a>lab assignments

* [Web Scraping](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_webscraping/Lab_2_A_Live.ipynb)
* [Exploratory Data Analysis for Classification using Pandas and Matplotlib](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_eda/lab3.ipynb)
* [Scikit-Learn, Regression, PCA](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_scikitlearn_regression_pca/Lab4.ipynb)
* [Bias, Variance, Cross-Validation](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_bias_variance_crossvalidation/Lab5.ipynb)
* [Bayes, Linear Regression, and Metropolis Sampling](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_bayes_linearregression_sampling/BayesLinear.ipynb)
* [Support Vector Machines](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_neuralnetworks_svm/Lab_10.ipynb)
* [Networks](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_networks_graphs/lab_9.ipynb)
* [MapReduce](https://github.com/bsharvey/EMSEDataAnalytics/blob/master/EMSE6992_Labs/lab_mapreduce/lab8_mapreduce.ipynb)

---

### <a name="ProgrammingForAnalytics"></a> Programming For Analytics Assignments & Projects
* [List, List Comprehensions, Dictionary, Function, Class](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Programming%20for%20Analytics/%7BWang%20Peiyu%7D%20%E2%80%93%20Assignment_01_Submission.ipynb)
* [Numpy Array](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Programming%20for%20Analytics/%7BWang_Peiyu%7D%20%E2%80%93%20Assignment_02_Submission.ipynb)
* [DataFrame, Nan handling, Graph Plotting, Data Processing](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Programming%20for%20Analytics/%7BWang%20Peiyu%7D%20%E2%80%93%20Assignment_03_Submission.ipynb)
* [Midterm Take-home Exam](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Programming%20for%20Analytics/%7BWang_Peiyu%7D%20%E2%80%93%20Midterm_Submission.ipynb)
* [Final Project: General/Logistic Regression/Decision Tree Analysis based on Adult Census Income Data](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Programming%20for%20Analytics/project)

---

### <a name="DataAnalysisForEngNSci"></a> Data Analysis for Eng & Sci Assignments & Projects
* [Linear Regression Project with Minitab & Excel](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Data%20Analysis%20for%20Eng%20%26%20Sci/Linear%20Regression%20Project)
* [PCA Project with Minitab & Excel](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Data%20Analysis%20for%20Eng%20%26%20Sci/PCA%20Project)

---

### <a name="Algorithms"></a> Design and Analysis of Algorithms Assignments & Projects
* [Coding Project 1- Divide and Conquer](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Design%20and%20Analysis%20of%20Algorithms/CS2612PJ1)
* [Coding Project 2- Dynamic Programming](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Design%20and%20Analysis%20of%20Algorithms/CS6212-Coding%20Project2)
* [Coding Project 3- Graph Algorithms](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Design%20and%20Analysis%20of%20Algorithms/CS6212-Coding_Project3)
* [Final Project: Code Implementation for SGD & FSGD for Recommender Systems](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/Design%20and%20Analysis%20of%20Algorithms/SGD%20and%20FSGD%20for%20Recommender%20Systems%20Code%20Implementation.ipynb)


---

### <a name="DBMSForDataAnalytics"></a> DBMS For Data Analytics Assignments & Projects
* [MongoDB Querying and Analysis](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/DBMS%20for%20Data%20Analytics/%7BWang%20Peiyu%7D%20%E2%80%93%20Assignment_01_Submission.ipynb)
* [DynamoDB Querying and Analysis](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/DBMS%20for%20Data%20Analytics/%7BWang%20Peiyu%7D%20-%20Assignment_02_Submission.ipynb)
* [AWS MySQL Querying and Analysis](https://github.com/oliviapy960825/oliviapy960825.github.io/blob/master/Assignments/DBMS%20for%20Data%20Analytics/%7BWang%20Peiyu%7D-%20Assignment_03_Submission.ipynb)
* [Final Project: User Analysis of Kindle Review Dataset](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/DBMS%20for%20Data%20Analytics/Project)


---

### <a name="AppliedMachineLearningForAnalytics"></a> Applied Machine Learning For Analytics Assignments & Projects
* [Pickling/Serialization & Data Importation & Exploration from Different types of data file](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW1)
* [Linear Regression & Logistic Regression & AIC/BIC For Model Evaluation](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW2)
* [Naive Bayes & Support Vector Machine (SVM) & Kernel Tricks](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW3)
* [Crowdsourcing with AMT](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW4)
* [Principal Components Analysis & k-means Clustering & Singular Value Decomposition & Latent Semantic Analysis](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW5)
* [Latent Dirichlet Allocation](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/HW5_P2)
* [Final Project: Feature Engineering & Target Engineering](https://github.com/oliviapy960825/oliviapy960825.github.io/tree/master/Assignments/Applied%20Machine%20Learning%20for%20Analytics/Final%20Project)


---
