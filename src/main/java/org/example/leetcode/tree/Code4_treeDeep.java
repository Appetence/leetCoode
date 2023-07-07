package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

/**
 * @program: Leetcode
 * @description: 一棵树的最大深度
 * @author: liuhao
 * @date: 2023-06-08 13:20
 */
public class Code4_treeDeep {
    public static void main(String[] args) {
        //
        TreeNode tree = TreeNodeBuild.getTree(3);
        TreeNode tree2 = TreeNodeBuild.getTree(3);
        tree.right = tree2;
        TreeNode treeNode = new TreeNode(0);
        int result = maxDeep(tree);
        System.out.println(result);
        result = maxDeep(treeNode);
        System.out.println(result);
    }

    private static int maxDeep(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        // 左树的 max deep

        // 右树的 max deep
        // 取最大
        int leftDeep = maxDeep(tree.left);
        int rightDeep = maxDeep(tree.right);
        int deep = leftDeep > rightDeep ? leftDeep : rightDeep;
        return deep + 1;
    }

}
