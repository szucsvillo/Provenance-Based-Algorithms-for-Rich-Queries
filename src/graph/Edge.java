package graph;

public class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "target=" + target +
                ", weight=" + weight +
                '}';
    }

    public Node getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
}
