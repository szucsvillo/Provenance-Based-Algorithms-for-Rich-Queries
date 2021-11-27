# Provenance-Based-Algorithms-for-Rich-Queries
Provenance-Based Algorithms for Rich Queries over Graph Databases

How to use the program

First, define the graph. Here is an example:
{
7
0 1 5
0 2 3
1 2 7
2 3 4
3 4 2
3 6 10
5 6 8
}
The first line shows, that how many nodes are in the graph. The other lines are the non-directed edges.
So for example the "0 1 5" line means, that from the 0-labeled node to the 1-labeled node is an edge, wich weight is 5.

The next step is creating a new Mohri or Dijkstra objektum. For example:

Mohri M = new Mohri();

After that you can choose a semiring, and a starting node to run the algorithm. (Note, that not all the semirings work with all the algoritms, vid.: p16.pdf)

M.execute(g,g.getNodes().get(0),new Tropical());
