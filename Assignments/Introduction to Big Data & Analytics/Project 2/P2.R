install.packages(c('tm', 'SnowballC', 'wordcloud', 'topicmodels'))
library(tm)
setwd("~/Desktop/CSCI6444/Project 2/part_c")
getwd()
#fileName<- "~/Desktop/CSCI6444/Project 2/Dreams.txt"
#con <- file(fileName,open="r")
#lines<-readLines(con)
#lines <- readLines(fileName) ##This is another way of reading the lines in the file
#lines
SAT<-VCorpus(DirSource(".",ignore.case=TRUE, mode="text"))
SAT
inspect(SAT)
str(SAT)
#dreams<-SAT[[1]]
dreams
SATtdm<-TermDocumentMatrix(SAT)
SATtdm
inspect(SATtdm[1:10,1:2])
dreamstf<-termFreq(dreams)
dreamstf
dreamsdf<-as.data.frame(dreamstf)
dreamsdf
SATlow<-tm_map(SAT,content_transformer(tolower))
SATlow
removeNumPunct<-function(x) gsub("[^[:alpha:][:space:]]*","",x)
removeNumPunct
SATcl <-tm_map(SATlow, content_transformer(removeNumPunct))
SATcltdm <-TermDocumentMatrix(SATcl)
SATcltdm
inspect(SATcltdm[1:10,1:2])
myStopWords <-c(stopwords('english'))
myStopWords
SATstop <-tm_map(SATcl, removeWords, myStopWords)
inspect(SATstop[1:2])
SATtdm2 <- TermDocumentMatrix(SATstop, control = list(wordlengths=c(1,Inf)))
SATtdm2
#SATnosparse(SATtdm2,0.50)
SATtdm3 <- TermDocumentMatrix(SATstop, control = list(wordLengths=c(1,Inf), weighting=weightBin))
SATtdm3
SATtdm4 <- TermDocumentMatrix(SATstop, control = list(wordLengths=c(1,Inf), weighting=weightTfIdf))
SATtdm4
freq.terms<- findFreqTerms(SATtdm2,lowfreq = 5)
freq.terms
findAssocs(SATtdm2, "dreams", 0.25)
freq.terms3<-findFreqTerms(SATtdm3,lowfreq = 5)
freq.terms3
freq.terms4<-findFreqTerms(SATtdm4,lowfreq = 5)
freq.terms4
term.freq<-rowSums(as.matrix(SATtdm2))
term.freq<-subset(term.freq,term.freq>=5)
df<-data.frame(term=names(term.freq),freq=term.freq)
term.freq
df
install.packages("ggplot2")
library(ggplot2)
ggplot(df,aes(x=term,y=freq))+geom_bar(stat = "identity")+xlab("Terms")+ylab("Count")+coord_flip()
tdm2<-removeSparseTerms(SATtdm,sparse = 0.50)
tdm2
distMatrix<-dist(scale(SATtdm2))
distMatrix
fit <- hclust(distMatrix, method = "ward.D2")
plot(fit)
m1<- as.matrix(SATtdm2)
word.freq<-sort(rowSums(m1),decreasing = T)
word.freq
library(wordcloud)
pal<- brewer.pal(9,"BuGn")
pal<- pal[-(1:4)]
wordcloud(words = names(word.freq), freq = word.freq, min.freq = 3, random.order = F, colors=pal)


