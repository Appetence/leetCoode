package org.example.leetcode.tree.cbt;

import java.util.LinkedList;

import org.example.leetcode.linked.base.Node;
import org.example.leetcode.tree.orderEach.TreeRecur;

/**
 * 完全二叉树
 */
public class Code_CBT {
    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();
        boolean result1 = checkCompleteBineryTree(node);
        System.out.println(result1);
    }

    private static boolean checkCompleteBineryTree(Node<Integer> node) {
        if (node == null) {
            return true;
        }
        LinkedList<Node<Integer>> list = new LinkedList<>();
        boolean leaf = false;
        list.add(node);
        while (!list.isEmpty()) {
            Node<Integer> pop = list.pop();
            Node<Integer> l = pop.prev;
            Node<Integer> r = pop.next;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                list.add(l);
            }
            if (r != null) {
                list.add(r);
            }
            if (l == null && r == null) {
                // 有棵树没有叶子节点 后边的都不可以有叶子节点
                leaf = true;
            }

        }
        return true;
    }
}
