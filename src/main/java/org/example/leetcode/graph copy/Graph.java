package com.xiaodai.fund.mgmt.reconciliation.graph;


import java.util.HashMap;
import java.util.HashSet;


public class Graph {
    public HashMap<Integer, Node> nodes = new HashMap<>();
    public HashSet<Edge> edge = new HashSet<>();

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edge) {
        this.nodes = nodes;
        this.edge = edge;
    }

    public Graph() {
    }
}
