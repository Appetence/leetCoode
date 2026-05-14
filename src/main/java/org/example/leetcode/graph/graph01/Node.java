package com.xiaodai.fund.mgmt.financial.task.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
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
}
