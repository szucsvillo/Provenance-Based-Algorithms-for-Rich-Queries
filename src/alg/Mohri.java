package alg;

import graph.Edge;
import graph.Graph;
import graph.Node;
import semirings.AbstractSemiring;

import java.util.ArrayList;

public class Mohri {
    public float[] execute(Graph g, Node startNode, AbstractSemiring s) {
        int NodeCount = g.getNodeCount();
        float[] w = new float[NodeCount];
        float[] r = new float[NodeCount];
        for (int i = 0; i < NodeCount; i++) {
            w[i] = s.zero();
            r[i] = s.zero();
        }
        w[startNode.getLabel()] = s.one();
        r[startNode.getLabel()] = s.one();
        ArrayList<Node> S = new ArrayList<>();
        S.add(startNode);
        while (!S.isEmpty()) {
            Node q = S.get(0);
            S.remove(0);
            float r1 = r[q.getLabel()];
            r[q.getLabel()] = s.zero();
            for (Edge e : q.getEdges()) {
                int e_label = e.getTarget().getLabel();
                float a = w[e_label];
                float ew = e.getWeight();
                float b = s.add(w[e_label], s.times(r1, ew));
                if (a != b) {
                    w[e_label] = b;
                    r[e_label] = s.add(r[e_label], s.times(r1, ew));
                    if (!S.contains(e.getTarget())) {
                        S.add(e.getTarget());
                    }
                }
            }

        }
        w[startNode.getLabel()] = s.one();

        System.out.println("Mohri Results: ");
        for (int i = 0; i < w.length; ++i) {
            System.out.println("" + i + ": " + w[i]);
        }

        return w;
    }
}
