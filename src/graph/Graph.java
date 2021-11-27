package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    List<Node> nodes = new ArrayList<>();
    private int NodeCount;

    private Graph(int nodeCount) {
        for (int i = 0; i < nodeCount; i++) {
                nodes.add(new Node(i));
        }
        this.NodeCount = nodeCount;
    }

    private void addEdge(int n1_index, int n2_index, int w) {
        Node n1 = nodes.get(n1_index);
        Node n2 = nodes.get(n2_index);

        n1.addEdge(n2, w);
        n2.addEdge(n1, w);
    }

    public static Graph load(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner reader = new Scanner(f);

        int nodeCount = Integer.parseInt(reader.nextLine());

        Graph g = new Graph(nodeCount);

        while (reader.hasNextLine()) {
            String[] line = reader.nextLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            g.addEdge(n1, n2, w);
        }

        return g;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int getNodeCount() {
        return NodeCount;
    }
}
