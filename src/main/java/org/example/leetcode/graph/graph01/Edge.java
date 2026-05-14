package com.xiaodai.fund.mgmt.financial.task.graph;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Edge {
    // 边的权重
    public int weight;
    public Node from;
    public Node to;

}
