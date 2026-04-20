package org.example.leetcode.tree.orderEach;

import org.example.leetcode.linked.base.Node;

/**
 * 二叉树，先，中，后序遍历
 */
public class TreeRecur {

    public static void main(String[] args) {
        Node<Integer> node = buildNode();

        preOrderNormal(node);
        System.out.println(">>>>>>");
        midOrderNormal(node);
        System.out.println(">>>>>>");
        afterOrderNormal(node);
    }

    private static void midOrderNormal(Node<Integer> node) {
        if (node == null) {
            return;
        }
        midOrderNormal(node.prev);
        System.out.println(node.data);
        midOrderNormal(node.next);
    }

    private static void afterOrderNormal(Node<Integer> node) {
        if (node == null) {
            return;
        }
        afterOrderNormal(node.prev);
        afterOrderNormal(node.next);
        System.out.println(node.data);
    }

    public static Node<Integer> buildNode() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.prev = n2;
        n1.next = n3;
        n2.prev = n4; // n2 只有左子，next = null
        n3.next = n5; // n3 只有右子，prev = null

        return n1;
    }
    public static Node<Integer> buildNode2() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(5);
        Node<Integer> n7 = new Node<>(5);

        n1.prev = n2;
        n1.next = n3;
        n2.prev = n4; // n2 只有左子，next = null
        n2.next = n5;
        n3.prev = n6; // n3 只有右子，prev = null
        n3.next = n7; // n3 只有右子，prev = null

        return n1;
    }
    private static void preOrderNormal(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Integer head = node.data;
        System.out.println(head);
        preOrderNormal(node.prev);
        preOrderNormal(node.next);
    }

}
