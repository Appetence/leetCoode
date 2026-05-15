package org.example.leetcode.graph.graph01;

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
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Node getFrom() {
        return from;
    }
    public void setFrom(Node from) {
        this.from = from;
    }
    public Node getTo() {
        return to;
    }
    public void setTo(Node to) {
        this.to = to;
    }

    
}
