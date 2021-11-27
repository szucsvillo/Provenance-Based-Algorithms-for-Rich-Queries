import alg.Dijkstra;
import alg.Mohri;
import graph.Graph;
import semirings.Boolean;
import semirings.Counting;
import semirings.Tropical;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "graph_1";
        Graph g = Graph.load(inputFile);
        String inputFile1 = "graph_2";
        Graph g1 = Graph.load(inputFile1);

        Mohri M = new Mohri();
        //Mohri+Tropical-->length of shortest path
        M.execute(g,g.getNodes().get(0),new Tropical());
        //Mohri+Boolean-->existence of a path
        M.execute(g,g.getNodes().get(0),new Boolean());
        Dijkstra D = new Dijkstra();
        //Dijsktra+Tropical-->length of shortest path
        D.execute(g,g.getNodes().get(0),new Tropical());
        D.execute(g1,g.getNodes().get(0),new Tropical());

        //Mohri+Counting (not working, The semiring is not k-closed)--> total number of paths between ? and ? ,
        //edge weights being interpreted as number of edges between two vertices.
        M.execute(g,g.getNodes().get(0),new Counting());
    }
}