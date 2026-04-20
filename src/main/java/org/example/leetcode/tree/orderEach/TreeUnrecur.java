package org.example.leetcode.tree.orderEach;

import java.util.Stack;

import org.example.leetcode.linked.base.Node;

/**
 * 二叉树，先，中，后序遍历
 */
public class TreeUnrecur {

    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode();
        // preOrderStack(node);
        System.out.println(">>>>>>");
        // midOrderStack(node);
        System.out.println(">>>>>>");
        afterOrderStack(node);
        afterOrderStack2(node);

    }

    private static void afterOrderStack2(Node<Integer> node) {
         
    }

    /**
     * 整棵树，左边进栈，依次弹出节点的过程中对右边界进站
     * 
     * @param node
     */
    private static void midOrderStack(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.prev;
            } else {
                Node<Integer> pop = stack.pop();
                System.out.println(pop.data);
                node = pop.next;
            }

        }

    }

    /**
     * cur 入栈一
     * 
     * stack1 取 cur ,cur 入 stack2； left 入 stack1 right 入 stack1
     * 
     * stack2 遍历
     * 
     * 
     * @param node
     */
    private static void afterOrderStack(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack();
        Stack<Node<Integer>> stack2 = new Stack();

        stack.push(node);
        while (!stack.isEmpty()) {
            Node<Integer> pop = stack.pop();
            stack2.push(pop);
            if (pop.prev != null) {
                stack.push(pop.prev);
            }
            if (pop.next != null) {
                stack.push(pop.next);
            }

        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data);

        }
    }

    private static void preOrderStack(Node<Integer> node) {
        if (node == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();

        // while (!stack.isEmpty() || node != null) {
        // if (node != null) {
        // stack.push(node);
        // node = node.prev;
        // } else {
        // Node<Integer> pop = stack.pop();
        // System.out.println(pop.data);
        // node = node.next;

        // }
        // }

        stack.push(node);

        while (!stack.isEmpty()) {
            Node<Integer> pop = stack.pop();
            System.out.println(pop.data);
            if (pop.next != null) {
                stack.push(pop.next);
            }
            if (pop.prev != null) {
                stack.push(pop.prev);
            }
        }
    }
}
