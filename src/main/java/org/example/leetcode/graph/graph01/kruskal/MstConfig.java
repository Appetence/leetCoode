package com.xiaodai.fund.mgmt.financial.task.graph.kruskal;

import com.xiaodai.fund.mgmt.financial.task.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MstConfig {

    HashMap<Node, List<Node>> hashMap;

    public MstConfig(List<Node> nodeList) {
        hashMap = new HashMap<>();
        nodeList.forEach(node -> {
            List<Node> list = new ArrayList<>();
            list.add(node);
            hashMap.put(node, list);
        });
    }

    public boolean isSameSet(Node cur, Node other) {
        List<Node> nodes = hashMap.get(cur);
        List<Node> otherNodes = hashMap.get(other);
        return nodes == otherNodes;
    }

    public void union(Node from, Node to) {
        List<Node> nodes = hashMap.get(from);
        List<Node> toNodes = hashMap.get(to);
        if (nodes == toNodes) {
            return;
        }
        for (Node node : toNodes) {
            nodes.add(node);
            hashMap.put(node, nodes);
        }
    }
}
