package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

import java.util.Objects;

/**
 * @program: Leetcode
 * @description:
 *               二叉树：每个节点有左右两颗子树
 *               先序 头节点在前
 *               中序 头节点在center
 *               后序列 头节点在后
 *
 *               递归序：遍历每一个节点的顺序
 *
 *
 * @author: liuhao
 * @date: 2023-06-07 13:03compensation
 */
public class BinneryTreeProgram {
    public static void main(String[] args) {
        TreeNode tree = TreeNodeBuild.getTree(3);
        // predEach(tree);
        // centerEach(tree);
        afterEach(tree);
    }

    private static void afterEach(TreeNode tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        afterEach(tree.left);
        afterEach(tree.right);
        System.out.println(tree.data);
    }

    private static void centerEach(TreeNode tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        afterEach(tree.left);
        System.out.println(tree.data);
        afterEach(tree.right);
    }

    /**
     * 先序遍历
     * 
     * @param tree
     */
    private static void predEach(TreeNode tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        System.out.println(tree.data);
        predEach(tree.left);
        predEach(tree.right);

    }
}
