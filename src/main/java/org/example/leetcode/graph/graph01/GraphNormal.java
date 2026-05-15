package org.example.leetcode.graph.graph01;

import java.util.*;

public class GraphNormal {

    static int[][] baseData = { { 1, 2, 1 }, { 1, 3, 1 }, { 2, 4, 1 }, { 2, 5, 1 }, { 3, 6, 1 }, { 3, 7, 1 },
            { 4, 8, 1 }, { 5, 9, 1 }, { 6, 10, 1 }, { 7, 11, 1 }, };

    public static void main(String[] args) {

        Graph graph = createGraph(baseData);

        System.out.println(graph);
        Node node = graph.nodes.values().stream().filter(item -> Objects.nonNull(item.getNexts())).findAny().get();
        bfs(node);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // 建立连接关系
        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node2.nexts.add(node4);
        node2.nexts.add(node5);

        // 设置出入度
        node1.out = 2;
        node2.in = 1;
        node2.out = 2;
        node3.in = 1;
        node4.in = 1;
        node5.in = 1;

        System.out.println("Testing BFS order verification:");
        GraphNormal.bfs(node1);
        System.out.println("Testing DFS order verification:");
        dfs(node1);
        System.out.println("Testing TOPOLOGY order verification:");

        List<Node> nodes = sortedTopology(graph);
        System.out.println(nodes);
    }

    public static Graph createGraph(int[][] data) {

        Graph graph = new Graph();
        for (int i = 0; i < data.length; i++) {
            int weight = data[i][0];
            int from = data[i][1];
            int to = data[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;

            fromNode.edges.add(edge);
            graph.edge.add(edge);
        }

        return graph;
    }

    /**
     * 广度优先搜索
     *
     * @param node
     */
    public static void bfs(Node node) {
        System.out.println("bfs begin");
        if (node == null) {
            return;
        }
        // 入queue 出queue
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node pool = queue.poll();
            System.out.println(pool.value);
            for (Node cn : pool.getNexts()) {
                if (!set.contains(cn)) {
                    set.add(cn);
                    queue.add(cn);
                }
            }
        }
        System.out.println("bfs end");
    }

    public static void dfs(Node node) {
        System.out.println("dfs begin");
        if (node == null) {
            return;
        }
        // 入queue 出queue
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            // 不在这里处理是因为栈是先进后出，所以要先处理当前节点的子节点
            for (Node cn : pop.getNexts()) {
                if (!set.contains(cn)) {
                    set.add(cn);
                    // 先进后出
                    stack.push(pop);
                    stack.add(cn);
                    System.out.println(cn.value);
                    break;
                }
            }
        }
        System.out.println("dfs end");

    }

    public static List<Node> sortedTopology(Graph graph) {

        Queue<Node> zeroQueue = new LinkedList<>();
        HashMap<Node, Integer> nodeInMap = new HashMap<>();

        List<Node> result = new ArrayList<>();

        HashMap<Integer, Node> nodes = graph.nodes;
        for (Node node : nodes.values()) {
            if (node.in == 0) {
                zeroQueue.add(node);
            } else {
                nodeInMap.put(node, node.in);
            }
        }

        while (!zeroQueue.isEmpty()) {
            Node poll = zeroQueue.poll();
            System.out.println(poll.value);
            result.add(poll);
            for (Node next : poll.nexts) {
                Integer in = nodeInMap.get(next) - 1;
                nodeInMap.put(next, in);
                if (in == 0) {
                    zeroQueue.add(next);
                }
            }
        }

        return result;
    }

}
