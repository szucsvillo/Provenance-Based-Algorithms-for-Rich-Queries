package alg;

import graph.Edge;
import graph.Graph;
import graph.Node;
import semirings.AbstractSemiring;

import java.util.ArrayList;

public class Dijkstra {
    public float[] execute(Graph g, Node startNode, AbstractSemiring s) {
        int NodeCount = g.getNodeCount();
        ArrayList<Node> S = new ArrayList<>();
        float[][] edges = new float[4][NodeCount * NodeCount];
        int h = -1;
        for (Node n : g.getNodes()) {
            for (Edge e : n.getEdges()) {
                if (n.getLabel() < e.getTarget().getLabel()) {
                    h++;
                    edges[0][h] = h;
                    edges[1][h] = n.getLabel();
                    edges[2][h] = e.getTarget().getLabel();
                    edges[3][h] = e.getWeight();
                }
            }
        }
        float[] w = new float[NodeCount];
        for (int i = 0; i < NodeCount; i++) {
            w[i] = s.zero();
        }
        w[startNode.getLabel()] = s.one();
        boolean isedge = true;
        while (S != g.getNodes() && isedge) {
            float minwa = Float.POSITIVE_INFINITY;
            Node a = new Node(-1);
            isedge = false;
            for (Node n : g.getNodes()) {
                if (!S.contains(n) && w[n.getLabel()] <= minwa) {
                    minwa = w[n.getLabel()];
                    a=n;
                    isedge=true;
                }
            }
            S.add(a);
            for (Node n : g.getNodes()) {
                if (!S.contains(n)) {
                    for (int k = 0; k < h + 1; k++) {
                        float f2 = a.getLabel();
                        if (edges[2][k] == f2) {
                            int i1 = (int) edges[1][k];
                            w[i1] = s.add(w[i1], s.times(w[a.getLabel()], edges[3][k]));
                        } else if (edges[1][k] == f2) {
                            int i2 = (int) edges[2][k];
                            w[i2] = s.add(w[i2], s.times(w[a.getLabel()], edges[3][k]));
                        }
                    }
                }
            }
        }
        System.out.println("Dijkstra Results: ");
        for (int i = 0; i < w.length; ++i) {
            System.out.println("" + i + ": " + w[i]);
        }
        return w;
    }
}
