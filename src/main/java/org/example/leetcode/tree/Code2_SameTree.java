package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

import java.util.Objects;

/**
 * @program: Leetcode
 * @description: 判断两棵树是否相同
 * @author: liuhao
 * @date: 2023-06-08 13:02
 */
public class Code2_SameTree {
    /**
     * 当前节点
     * 左节点
     * 右节点
     */
    public static void main(String[] args) {
        TreeNode tree = TreeNodeBuild.getTree(3);
        /**
         * 根节点
         */
        boolean result = checkSameTree(tree);
        System.out.println(result);
        boolean sameTree = isSameTree(tree, tree);
        System.out.println(sameTree);

    }

    private static boolean checkSameTree(TreeNode tree) {
        if (Objects.isNull(tree)) {
            return true;
        }
        return isSameTree(tree.left, tree.right);
    }

    private static boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.data == right.data && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }

}
