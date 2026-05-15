package org.example.leetcode.graph.graph01;


import java.util.ArrayList;

public class Node {
    public int value;

    public int in;

    public int out;
    //  current node 直接发散出去的 node
    public ArrayList<Node> nexts;
    // 有哪些边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Node(int value, int in, int out, ArrayList<Node> nexts, ArrayList<Edge> edges) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts = nexts;
        this.edges = edges;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public ArrayList<Node> getNexts() {
        return nexts;
    }

    public void setNexts(ArrayList<Node> nexts) {
        this.nexts = nexts;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    
}
