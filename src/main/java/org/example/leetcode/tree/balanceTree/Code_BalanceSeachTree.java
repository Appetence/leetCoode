package org.example.leetcode.tree.balanceTree;

import org.example.leetcode.linked.base.Node;
import org.example.leetcode.tree.orderEach.TreeRecur;
import org.example.leetcode.common.ReturnType;;

/**
 * 平衡搜索树
 */
public class Code_BalanceSeachTree {

    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();

        balanceSeachTree(node);
    }

    private static ReturnType balanceSeachTree(Node<Integer> node) {
        if (node == null) {
            return null;
        }
        int min = node.data;
        int max = node.data;
        ReturnType left = balanceSeachTree(node.prev);
        ReturnType right = balanceSeachTree(node.next);

        if (left != null) {
            // left 最大值 小于 node.data
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }
        if (right != null) {
            // left 最大值 小于 node.data
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }
        boolean isBst = false;
        if ((left != null ? left.isBalance && left.max < node.data
                : true) || (right != null ? right.isBalance && right.min > node.data : true)) {
            isBst = true;

        }
        return new ReturnType(max, min, isBst);
    }
}
