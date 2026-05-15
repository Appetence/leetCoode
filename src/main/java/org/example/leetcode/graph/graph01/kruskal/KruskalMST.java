package com.xiaodai.fund.mgmt.financial.task.graph.kruskal;

import com.xiaodai.fund.mgmt.financial.task.graph.Edge;
import com.xiaodai.fund.mgmt.financial.task.graph.Graph;
import com.xiaodai.fund.mgmt.financial.task.graph.Node;

import java.util.*;
import java.util.stream.Collectors;

public class KruskalMST {
    @Test
    public void testSimpleTriangle() {
        // 测试用例1：简单三角形
        // 1 ---(4)--- 2
        //  \         /
        //   \(2)  (3)
        //    \   /
        //      3
        // 期望MST: 边(1-3, 2) + 边(2-3, 3) = 总权重5

        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 4);
        addEdge(graph, 1, 3, 2);
        addEdge(graph, 2, 3, 3);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(2, mst.size(), "MST应该有2条边");

        int totalWeight = mst.stream().mapToInt(e -> e.weight).sum();
        assertEquals(5, totalWeight, "最小权重应该是5");

        assertTrue(mst.stream().anyMatch(e -> e.weight == 2), "应该包含权重为2的边");
        assertTrue(mst.stream().anyMatch(e -> e.weight == 3), "应该包含权重为3的边");
    }

    @Test
    public void testSquareGraph() {
        // 测试用例2：正方形
        // 1 ---(1)--- 2
        // |           |
        // (4)        (2)
        // |           |
        // 4 ---(3)--- 3
        // 期望MST: 1-2(1) + 2-3(2) + 3-4(3) = 总权重6

        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 2, 3, 2);
        addEdge(graph, 3, 4, 3);
        addEdge(graph, 4, 1, 4);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(3, mst.size(), "MST应该有3条边");
        assertEquals(6, mst.stream().mapToInt(e -> e.weight).sum());
    }

    @Test
    public void testComplexGraph() {
        // 测试用例3：复杂图（经典示例）
        //       1
        //      /|\
        //    (2)(3)(1)
        //    /  |  \
        //   2   |   3
        //    \ (4) /
        //     \|  |(5)
        //       4

        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 1, 4, 3);
        addEdge(graph, 2, 4, 4);
        addEdge(graph, 3, 4, 5);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(3, mst.size(), "4个节点的MST应该有3条边");
        assertEquals(6, mst.stream().mapToInt(e -> e.weight).sum());
    }

    @Test
    public void testSingleNode() {
        // 测试用例4：单节点
        Graph graph = createTestGraph();
        getOrCreateNode(graph, 1);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(0, mst.size(), "单节点图不应该有边");
    }

    @Test
    public void testTwoNodesOneEdge() {
        // 测试用例5：两个节点一条边
        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 10);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(1, mst.size());
        assertEquals(10, mst.iterator().next().weight);
    }

    @Test
    public void testDisconnectedGraph() {
        // 测试用例6：非连通图
        // 1 --- 2    3 --- 4
        // 应该返回两个组件的MST

        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 5);
        addEdge(graph, 3, 4, 7);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(2, mst.size(), "非连通图应该包含两个组件的边");
    }

    @Test
    public void testEqualWeights() {
        // 测试用例7：相同权重的边
        // 1 ---(5)--- 2
        // |           |
        // (5)        (5)
        // |           |
        // 3 ---(5)--- 4

        Graph graph = createTestGraph();
        addEdge(graph, 1, 2, 5);
        addEdge(graph, 2, 4, 5);
        addEdge(graph, 4, 3, 5);
        addEdge(graph, 3, 1, 5);

        Set<Edge> mst = KruskalMST.kruskalMST(graph);

        assertEquals(3, mst.size());
        assertEquals(15, mst.stream().mapToInt(e -> e.weight).sum());
    }

    @Test
    public void testMstConfigUnion() {
        // 测试用例8：直接测试MstConfig的union功能
        Graph graph = createTestGraph();
        Node n1 = getOrCreateNode(graph, 1);
        Node n2 = getOrCreateNode(graph, 2);
        Node n3 = getOrCreateNode(graph, 3);

        MstConfig config = new MstConfig(java.util.Arrays.asList(n1, n2, n3));

        assertFalse(config.isSameSet(n1, n2), "初始时n1和n2不在同一集合");

        config.union(n1, n2);
        assertTrue(config.isSameSet(n1, n2), "union后n1和n2应该在同一集合");

        assertFalse(config.isSameSet(n1, n3), "n3应该还是独立的");

        config.union(n2, n3);
        assertTrue(config.isSameSet(n1, n3), "union后所有节点应该在同一集合");
    }

    /**
     * 创建测试图的辅助方法
     */
    private Graph createTestGraph() {
        Graph graph = new Graph();
        graph.nodes = new HashMap<>();
        graph.edge = new HashSet<>();
        return graph;
    }

    private Node getOrCreateNode(Graph graph, int value) {
        return graph.nodes.computeIfAbsent(value, Node::new);
    }

    private void addEdge(Graph graph, int from, int to, int weight) {
        Node fromNode = getOrCreateNode(graph, from);
        Node toNode = getOrCreateNode(graph, to);

        Edge edge = new Edge(weight, fromNode, toNode);
        graph.edge.add(edge);

        fromNode.out++;
        fromNode.nexts.add(toNode);
        fromNode.edges.add(edge);

        toNode.in++;
    }

    public static Set<Edge> kruskalMST(Graph graph) {

        List<Node> collect = graph.nodes.values().stream().collect(Collectors.toList());
        MstConfig unionFind = new MstConfig(collect);
        PriorityQueue<Edge> queue = new PriorityQueue<>(collect.size(), (o1, o2) -> o1.weight - o2.weight);
        for (Edge edge : graph.edge) {
            queue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (!unionFind.isSameSet(poll.from, poll.to)) {
                result.add(poll);
                unionFind.union(poll.from, poll.to);
            }
        }
        return result;
    }
}
