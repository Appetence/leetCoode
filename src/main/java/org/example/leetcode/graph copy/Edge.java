package com.xiaodai.fund.mgmt.reconciliation.graph;

public class Edge {
    // 边的权重
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
