# import the graph
fileName<- "~/Desktop/email-EU/email-EU.edges"
con <- file(fileName,open="r")
lines<-readLines(con)
lines
data<-read.table(textConnection(lines))
View(data)
install.packages("igraph")
library(igraph)
g <- graph_from_data_frame(data, directed=TRUE)
print(g, e=TRUE, v=TRUE)
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
gcon <- simplify(gcon, edge.attr.comb = list(weight = "sum", function(x)length(x)))
gcc <- induced.subgraph(gcon, V(gcon)$weight > 20)
V(gcc)$degree <- unname(degree(gcc))

# Plot the simplified graph
set.seed(42)
par(mar = rep(0.1, 4))
g.layout <- layout.kamada.kawai(gcc)
plot.igraph(gcc, edge.arrow.size = 0.1, layout = g.layout, vertex.size = 0.5 * (V(gcc)$degree))
