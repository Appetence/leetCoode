package org.example.leetcode.graph;

public class Base_Graph {
    
    public static Node testSimpleGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node2.nexts.add(node4);

        System.out.println("DFS遍历:");
        return node1;
    }

    public static Node testCyclicGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.nexts.add(node2);
        node2.nexts.add(node3);
        node3.nexts.add(node4);
        node4.nexts.add(node1); // 形成环

        System.out.println("DFS遍历(带环):");
        return node1;
    }
}
