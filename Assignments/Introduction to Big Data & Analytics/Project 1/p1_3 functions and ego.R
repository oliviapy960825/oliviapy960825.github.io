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

# ego function
ego_size(g, order = 0, 1:3)
ego(g, order = 0, 1:3)
make_ego_graph(g, order = 0, 1:3)