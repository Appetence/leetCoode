package org.example.leetcode.linked.loop;

public class FindIntersectionNode {

    public static void main(String[] args) {
        Node node = getNodeContainLoop();
        Node firstNode = getLoopNode(node);
        System.out.println(firstNode);
        node = getNodeNotContainLoop();
        firstNode = getLoopNode(node);
        System.out.println(firstNode);
    }

    private static Node getNodeNotContainLoop() {
        // 无环测试: 1 -> 2 -> 3 -> null
        Node noLoop1 = new Node(1);
        Node noLoop2 = new Node(2);
        Node noLoop3 = new Node(3);
        noLoop1.next = noLoop2;
        noLoop2.next = noLoop3;
        return noLoop1;
    }

    private static Node getNodeContainLoop() {
        // 创建链表: 1 -> 2 -> 3 -> 4 -> 2 (环回节点 2)
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 创建环
        return node1;
    }

    private static Node getLoopNode(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }
        // open node
        Node slow = node.next;
        Node fast = node.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // diff open
        fast = node;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
