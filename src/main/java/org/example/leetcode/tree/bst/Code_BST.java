package org.example.leetcode.tree.bst;

import java.util.Stack;

import org.example.leetcode.linked.base.Node;
import org.example.leetcode.tree.orderEach.TreeRecur;

public class Code_BST {

    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();

        System.out.println(checkBST(node));
        System.out.println(checkBSTUnResur(node));

    }

    static int preValue = Integer.MIN_VALUE;

    private static boolean checkBST(Node<Integer> node) {
        if (node == null) {
            return true;
        }
        boolean isLeft = checkBST(node.prev);
        if (!isLeft) {
            return false;
        }
        // 控制 前一个节点永远小于后一个节点
        if (node.data <= preValue) {
            return false;
        } else {
            preValue = node.data;
        }

        boolean isRight = checkBST(node.next);
        return isRight;

    }

    public static boolean checkBSTUnResur(Node<Integer> node) {

        if (node == null) {
            return true;
        }

        Stack<Node<Integer>> stack = new Stack();
        Integer preValue = Integer.MIN_VALUE;

        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                stack.add(node);
                node = node.prev;
            } else {
                Node<Integer> pop = stack.pop();
                if (pop.data <= preValue) {
                    System.out.println("非法节点: " + pop.data);
                    System.out.println("前驱节点: " + preValue);
                    return false;
                }
                preValue = pop.data;
                node = pop.next;
            }
        }
        return true;
    }
}
