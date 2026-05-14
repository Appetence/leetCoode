package org.example.leetcode.tree.ancestor;

import org.example.leetcode.linked.base.Node;
import org.example.leetcode.tree.orderEach.TreeRecur;

public class Code_LowestAncestor {
    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();
        Node<Integer> result = lowestAncestor(node, new Node(4), new Node(3));
        System.out.println(result.data);
    }

    private static Node<Integer> lowestAncestor(Node<Integer> head, Node<Integer> left, Node<Integer> right) {
        if (head == null || head.data.intValue() == left.data.intValue() || head.data.intValue() == right.data.intValue()) {
            return head;
        }
        Node<Integer> leftNode = lowestAncestor(head.prev, left, right);
        Node<Integer> rightNode = lowestAncestor(head.next, left, right);
        if (leftNode != null && rightNode != null) {
            // double result
            return head;
        }

        return left != null ? left : right;
    }

}
