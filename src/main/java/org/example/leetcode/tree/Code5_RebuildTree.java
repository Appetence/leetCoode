package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description: 先序遍历，中序遍历，构建树（先序，中序中无重复节点）
 * @author: liuhao
 * @date: 2023-06-08 13:22
 */
public class Code5_RebuildTree {

    public static void main(String[] args) {

        int[] leftSoft = { 4, 2, 1, 3, 6, 5, 7 };
        int[] centerSoft = { 1, 2, 3, 4, 5, 6, 7 };
        // leftSoft = new int[]{1};
        // centerSoft = new int[]{2};

        boolean result = isLeftSoft(leftSoft, 0, leftSoft.length - 1);
        System.out.println(result);
        TreeNode treeNode = rebuildTree(leftSoft, 0, leftSoft.length - 1, centerSoft, 0, centerSoft.length - 1);
        System.out.println(treeNode);
        TreeNode treeNode2 = rebuildTree2(leftSoft, 0, leftSoft.length - 1, centerSoft, 0, centerSoft.length - 1);
        System.out.println(treeNode2);

    }

    private static boolean isLeftSoft(int[] leftSoft, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int length = end;
        int head = leftSoft[begin];

        int rightIndex = 0;
        for (int index = begin + 1; index <= length; index++) {
            if (leftSoft[index] > head) {
                rightIndex = index;
                break;
            }
        }
        for (int index = rightIndex + 1; index <= length; index++) {
            if (leftSoft[index] < head) {
                return false;
            }
        }

        boolean leftResult = isLeftSoft(leftSoft, begin + 1, rightIndex - 1);
        boolean rightResult = isLeftSoft(leftSoft, rightIndex, end);
        return leftResult && rightResult;
    }

    private static TreeNode rebuildTree2(int[] leftSoft, int begin, int last, int[] centerSoft, int begin2, int last2) {
        // 给定一棵树的先序遍历 中序遍历，构建树
        if (leftSoft == null || centerSoft == null || leftSoft.length != centerSoft.length) {
            return null;
        }
        int size = leftSoft.length;
        int index = 0;
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        while (index < size) {
            valueIndexMap.put(centerSoft[index], index);
            index++;
        }
        return function2(leftSoft, begin, last, centerSoft, begin2, last2, valueIndexMap);
    }

    /**
     * ，
     *
     * @param leftSoft   前序遍历
     * @param centerSoft 中序遍历
     */
    private static TreeNode rebuildTree(int[] leftSoft, int begin, int last, int[] centerSoft, int begin2, int last2) {
        // 给定一棵树的先序遍历 中序遍历，构建树
        if (leftSoft == null || centerSoft == null || leftSoft.length != centerSoft.length) {
            return null;
        }
        return function(leftSoft, begin, last, centerSoft, begin2, last2);
    }

    /**
     * @param leftSoft   先序数据
     * @param L1         先序起始位置
     * @param R1         先序结束位置
     * @param centerSoft 中序
     * @param L2         中序起始位置
     * @param R2         中序结束位置
     * @return
     */
    private static TreeNode function(int[] leftSoft, int L1, int R1, int[] centerSoft, int L2, int R2) {
        // 不是有效范围
        if (L1 > R1) {
            // 单边没数据情况
            return null;
        }
        // 先序遍历获取头节点
        int head = leftSoft[L1];
        TreeNode treeNode = new TreeNode(head);
        if (L1 == R1) {
            // 只有一个节点时候
            return treeNode;
        }
        // 中序遍历 find 头节点 ； 先序遍历 1 -> find 为左树 find + 1 -> last右树
        // 从l2的头节点开始找，所以默认 = l2
        int find = L2;
        while (centerSoft[find] != head) {
            find++;
        }
        // 左节点 l1 + find - l2 表示 从 l1 开始 往后走 find -L2 个位置
        treeNode.left = function(leftSoft, L1 + 1, L1 + find - L2, centerSoft, L2, find - 1);
        // 右节点
        treeNode.right = function(leftSoft, L1 + find - L2 + 1, R1, centerSoft, find + 1, R2);
        // 依次 递归
        return treeNode;
    }

    /**
     * 优化策略，优化取数时间
     */
    private static TreeNode function2(int[] leftSoft, int L1, int R1, int[] centerSoft, int L2, int R2,
            Map<Integer, Integer> valueIndexMap) {
        // 不是有效范围
        if (L1 > R1) {
            // 单边没数据情况
            return null;
        }
        // 先序遍历获取头节点
        int head = leftSoft[L1];
        TreeNode treeNode = new TreeNode(head);
        if (L1 == R1) {
            // 只有一个节点时候
            return treeNode;
        }
        // 中序遍历 find 头节点 ； 先序遍历 1 -> find 为左树 find + 1 -> last右树
        // 从l2的头节点开始找，所以默认 = l2
        int find = valueIndexMap.get(head);
        // 左节点 l1 + find - l2 表示 从 l1 开始 往后走 find -L2 个位置
        treeNode.left = function2(leftSoft, L1 + 1, L1 + find - L2, centerSoft, L2, find - 1, valueIndexMap);
        // 右节点
        treeNode.right = function2(leftSoft, L1 + find - L2 + 1, R1, centerSoft, find + 1, R2, valueIndexMap);
        // 依次 递归
        return treeNode;
    }

}
