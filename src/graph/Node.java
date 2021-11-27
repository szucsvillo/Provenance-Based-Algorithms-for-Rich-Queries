package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Edge> edges = new ArrayList<>();
    int label;

    public Node(int label) {
        this.label = label;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void addEdge(Node node, int weight) {
        this.addEdge(new Edge(node, weight));
    }

    @Override
    public String toString() {
        return "Node{" +
                ", label=" + label +
                '}';
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getLabel() {
        return label;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
