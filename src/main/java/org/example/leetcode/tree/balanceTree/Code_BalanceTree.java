package org.example.leetcode.tree.balanceTree;

import org.example.leetcode.linked.base.Node;
import org.example.leetcode.tree.orderEach.TreeRecur;

/**
 * 平衡树
 * 左右子树，高度差最大为1 
 */
public class Code_BalanceTree {

    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode();
        ReturnType balance = isBalance(node);
        System.out.println(balance.isBalance);
        System.out.println(balance.high);
    }

    private static ReturnType isBalance(Node<Integer> node) {

        if (node == null) {
            return new ReturnType(0, true);
        }
        ReturnType left = isBalance(node.prev);
        ReturnType right = isBalance(node.next);
        int high = Math.max(left.high, right.high);
        boolean isBalance = left.isBalance && right.isBalance && (Math.abs(left.high - right.high) < 2);

        return new ReturnType(high + 1, isBalance);

    }

}

class ReturnType {
    Integer high;
    boolean isBalance;

    public ReturnType(Integer high, boolean isBalance) {
        this.high = high;
        this.isBalance = isBalance;
    }
}