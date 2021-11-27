package alg;

import graph.Edge;
import graph.Graph;
import graph.Node;
import semirings.AbstractSemiring;

import java.util.ArrayList;
import java.util.List;

public class NodeElimination {
    //not working, missing the star() methods from the Semirings
    public float execute(Graph g, Node startNode, Node endNode, AbstractSemiring s) {
        int NodeCount = g.getNodeCount();
        List<Node> V = g.getNodes();
        Node s1 = new Node(NodeCount);
        V.add(s1);
        Node t1 = new Node(NodeCount + 1);
        V.add(t1);
        List<Edge> E = new ArrayList<>();
        for (int i = 0; i < NodeCount; i++) {
            for(Edge e: g.getNodes().get(i).getEdges()){
                E.add(e);
            }
        }
        s1.addEdge(startNode, 0);
        startNode.addEdge(s1, 0);
        E.add(s1.getEdges().get(0));
        t1.addEdge(endNode, 0);
        endNode.addEdge(t1, 0);
        E.add(t1.getEdges().get(0));
        float[][] w = new float[V.size()][V.size()];
        for(Node i: V){
            for(Node j: V){
                float we = 0;
                for(Edge e: i.getEdges()){
                    if (e.getTarget()==j){
                        we = e.getWeight();
                    }
                }
                if (i != j) {
                    w[i.getLabel()][j.getLabel()] = we;
                }
                else{
                    w[i.getLabel()][j.getLabel()] = s.add(s.one(), we);
                }
            }
        }
        for(Node k: V) {
            for (Node l : V) {
                if(l!=k){
                    for(Edge e: l.getEdges()){
                        if(e.getTarget()==k){
                            for(Edge e2: k.getEdges()) {
                                if (e2.getTarget()!=l) {
                                    w[l.getLabel()][e2.getTarget().getLabel()] = s.add(w[l.getLabel()][e2.getTarget().getLabel()],
                                            (s.times(s.times(w[l.getLabel()][k.getLabel()], s.star(w[k.getLabel()][k.getLabel()])),
                                                    w[k.getLabel()][e2.getTarget().getLabel()])));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Result: ");
        System.out.println(w[s1.getLabel()][t1.getLabel()]);
        return w[s1.getLabel()][t1.getLabel()];

    }

}
