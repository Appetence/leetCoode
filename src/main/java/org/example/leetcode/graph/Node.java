package org.example.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Integer value;

    List<Node> nexts;

    public Node(Integer value) {
        this.value = value;
        this.nexts = new ArrayList<>();
    }
}
