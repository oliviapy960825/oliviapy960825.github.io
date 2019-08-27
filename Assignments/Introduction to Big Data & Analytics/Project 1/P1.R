fileName<- "~/Desktop/CSCI6444/Project 1/email-EU/email-EU.edges"
con <- file(fileName,open="r")
lines<-readLines(con)
#lines <- readLines(fileName) ##This is another way of reading the lines in the file
lines
data<-read.table(textConnection(lines))
#library(tidyverse)
library(igraph)
#data %>%
  #rename(
    #FromNode = V1,
    #ToNode = V2
  #)
g <- graph_from_data_frame(data, directed=TRUE)
print(g, e=TRUE, v=TRUE)
adjmatrix = as_adjacency_matrix(g)
adjmatrix
simplified_g<-simplify(g)
plot(simplified_g)
subv <- c(1,2,3,4,5,6,7,8,9,10)
g2 <- induced.subgraph(graph=simplified_g,vids=subv)
plot(g2)

#another way of simplifing the graph
View(g)
set.seed(42)

# Compute communities (clusters)
cl <- walktrap.community(g, steps = 5)
cl$degree <- (degree(g)[cl$names])

# Assign node with highest degree as name for each cluster
cl$cluster <- unname(ave(cl$degree, cl$membership, FUN=function(x)names(x)[which.max(x)]))
V(g)$name <- cl$cluster

# Contract vertices
E(g)$weight <- 1
V(g)$weight <- 1
gcon <- contract.vertices(g, cl$membership, vertex.attr.comb = list(weight = "sum", name = function(x)x[1], "ignore"))

# Simplify edges
gcon <- simplify(gcon, edge.attr.comb = list(weight = "sum", function(x) length(x)))
gcc <- induced.subgraph(gcon, V(gcon)$weight > 20)
V(gcc)$degree <- unname(degree(gcc))

# Plot the simplified graph
set.seed(42)
par(mar = rep(0.1, 4))
g.layout <- layout.kamada.kawai(gcc)
plot.igraph(gcc, edge.arrow.size = 0.1, layout = g.layout, vertex.size = 0.5 * (V(gcc)$degree))


#Part 4 functions:
#add vertices function
g3 <- add_vertices(g2,11)
plot(g3)

#add edges function
add.edges(g3,c(11,1))
add.edges(g3,c(11,3))
plot(g3)
#V(g3)$weight=rnorm(vcount(g3))
#E(g3)$weight=rnorm(ecount(g3))

#count triangles function
atri <- count_triangles(g3)
plot(g3, vertex.label=atri)

#as adjacency list function
list <- as_adj_list(g3)
print(list)

#as adjacency edge list function
edge_list=as_adj_edge_list(g3)
print(edge_list)

#diameter function
diameter(g, directed = TRUE, unconnected = TRUE, weights = NULL)
diameter(g)

#radius function
radius(g, mode = 'all')

#betweenness function
betweenness(g)

# is_directed function
is_directed(g)

# Use the previous method to generate the graph

# Before simplifying the graph(With loops)
edge_density(g, loops=TRUE)

# After simplifying the graph
edge_density(simplify(g), loops=FALSE)

# calculates the line graph of another graph
make_line_graph(g)
make_line_graph(make_line_graph(g))

# shortest paths function
shortest.paths(g2)
#get.shortest.paths(g2, from, mode = "all")

#average path length function
average.path.length(g2, directed=TRUE, unconnected=TRUE)

#mean distance function
mean_distance(g2)

#check the average degree of the graph
mean(degree(g2))

#central degree function
centr_degree(g2,mode="in",normalized=T)

#part 5:
# (a) central person in the graph:
closeness.cent <- closeness(g, mode="all")
closeness.cent
sort(closeness.cent, decreasing = FALSE)
#according to the output, node 622 seems to be the central node

# (b) longest path
dia<-diameter(g)
dia#the output is 13
get_diameter(g)#output is "+ 14/32430 vertices, named, from fb68b88: [1] 17763 16731 8855  3759  2136  1867  1501  1500  1380  1374  1229  1217  999   938" 

# (c) largest clique:
largest_cliques(g)

# (d) ego:
ego_size(g, order = 0, 1:3)
ego(g, order = 0, 1:3)
make_ego_graph(g, order = 0, 1:3)

# (e) power centrality:
power_centr=power_centrality(g2, nodes= V(g2), loops=FALSE, exponent=1, rescale = FALSE, tol = 1e-07, sparse = TRUE)

sort(power_centr, decreasing = FALSE)
#results shown below:
# 26        29        51        56        52        82        83 
#0.0000000 0.0000000 0.0000000 0.0000000 0.1207559 0.2817637 0.6037794 
#85        94        87 
#1.0465510 1.7308343 2.3346137 
#This probably means that node 26,29,51,56,52,82,83,85,94,87 are the most powerful (also their power magnitudes are in decreasing order)
#nodes when their alters become more and more powerful

#some functions mentioned in the PPT
page_rank(simplified_g)
sg1 <- decompose.graph(simplified_g,mode="weak")
sg1

page_rank(g2)
wc=walktrap.community(simplified_g)
plot(wc,simplified_g,vertex.size=.5, layout=layout.fruchterman.reingold)
wc=walktrap.community(g2)
plot(wc,g2,vertex.size=.5, layout=layout.fruchterman.reingold)

neighverts <- unique(unlist(sapply(sg1,FUN=function(s){if(any(V(s)$name %in% subv)) V(s)$name else NULL})))
neighverts
g4 <- induced.subgraph(graph=simplified_g,vids=neighverts)#NOT WORKING APPARENTLY THERE ARE UNCONNECTED VERTICES IN SIMPLIFIED_G SO CANNOT PLOT THE INDUCED GRAPH WITH SIMPLIFIED_G
g4
plot(g4)
E(g2)$weight=rnorm(ecount(g2))
V(g2)$weight=rnorm(vcount(g2))
