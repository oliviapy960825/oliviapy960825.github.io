fileName<- "~/CSCI6444/email-EU/email-EU.edges"
con <- file(fileName,open="r")
lines<-readLines(con)
#lines <- readLines(fileName)
lines
data<-read.table(textConnection(lines))
#library(tidyverse)
library(igraph)
g <- graph_from_data_frame(data, directed=TRUE)
print(g, e=TRUE, v=TRUE)
adjmatrix = as_adjacency_matrix(g)
#adjmatrix
#simplified_g<-simplify(g)
#plot(simplified_g)
#subv <- c(1,2,3,4,5,6,7,8,9,10)
#g2 <- induced.subgraph(graph=simplified_g,vids=subv)
#plot(g2)
#plot(g)

#closeness
#closeness(g,mode ='all')

#diameter
diameter(g, directed = TRUE, unconnected = TRUE, weights = NULL)
diameter(g)

#radius
radius(g, mode = 'all')

#largest clique
largest_cliques(g)

betweenness(g)
