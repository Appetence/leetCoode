package com.xiaodai.fund.mgmt.financial.task.graph.kruskal;

import com.xiaodai.fund.mgmt.financial.task.graph.Node;

import java.util.Map;

public class UnionFind {
    private Map<Node, Node> parent;
    private Map<Node, Integer> rank;

    public Node find(Node x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x))); // 路径压缩
        }
        return parent.get(x);
    }

    public void union(Node x, Node y) {
        Node rootX = find(x);
        Node rootY = find(y);
        if (rootX == rootY) return;

        // 按秩合并
        if (rank.get(rootX) < rank.get(rootY)) {
            parent.put(rootX, rootY);
        } else if (rank.get(rootX) > rank.get(rootY)) {
            parent.put(rootY, rootX);
        } else {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootX) + 1);
        }
    }
}
