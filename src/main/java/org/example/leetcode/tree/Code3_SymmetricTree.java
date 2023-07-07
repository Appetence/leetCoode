package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

/**
 * @program: Leetcode
 * @description: 判断一个树是否为 镜面树
 * @author: liuhao
 * @date: 2023-06-08 13:09
 */
public class Code3_SymmetricTree {
    public static void main(String[] args) {
        // 镜面树 左节点 == 右节点
        TreeNode tree = TreeNodeBuild.getSymmetric(3);


        boolean result = checkSymmetric(tree);
        System.out.println(result);
        // 错误示例
        TreeNode tree2 = TreeNodeBuild.getTree(3);
        result = checkSymmetric(tree2);
        System.out.println(result);
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = tree;
        treeNode.right = tree;
        result = checkSymmetric(treeNode);
        System.out.println(result);
    }

    private static boolean checkSymmetric(TreeNode tree) {
        if (tree == null) {
            return false;
        }
        return isSymmertricTree(tree, tree);
    }

    private static boolean isSymmertricTree(TreeNode left, TreeNode right) {
        // 左节点 == 右节点
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.data == right.data && isSymmertricTree(left.left, right.right) && isSymmertricTree(left.right, right.left);
    }
}
