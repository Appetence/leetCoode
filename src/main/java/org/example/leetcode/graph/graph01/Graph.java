package com.xiaodai.fund.mgmt.financial.task.graph;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;


@NoArgsConstructor
public class Graph {
    public HashMap<Integer, Node> nodes = new HashMap<>();
    public HashSet<Edge> edge = new HashSet<>();

}
