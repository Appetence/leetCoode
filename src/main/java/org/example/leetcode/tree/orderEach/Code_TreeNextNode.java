package org.example.leetcode.tree.orderEach;

import org.example.leetcode.linked.base.Node;

public class Code_TreeNextNode {

    /**
     * 给定一个二叉树，求某个节点的后继节点
     * 
     * 思路 ：
     * 1 left tree 左树的后继节点是是 parent
     * 2 右树的后继节点：
     * 2.1 存在第一次为左树的情况，此时的 parent就是后继
     * 2.2 直到父节点为空，是最后一个右节点，后继为空
     * 
     * @param args
     */
    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();

        Node result = getNodeNextNode(node);
        System.out.println(result);

    }

    private static Node getNodeNextNode(Node<Integer> node) {
        if (node == null) {
            return node;
        }

        if (node.next != null) {
            return getLeftNode(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.prev != node) {
                node = parent;
                parent = node.parent;

            }
            return parent;
        }
    }

    private static Node getLeftNode(Node<Integer> node) {
        if (node == null) {
            return node;
        }

        while (node.prev != null) {
            node = node.prev;
        }
        return node;
    }
}
