package org.example.leetcode.graph;

public class Edge {

    private Integer weight;
    private Node from;
    private Node to;
    public Edge(Integer weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }


}
