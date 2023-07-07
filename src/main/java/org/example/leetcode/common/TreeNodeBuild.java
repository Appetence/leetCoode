package org.example.leetcode.common;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-06-08 20:06
 */
public class TreeNodeBuild {

    public static TreeNode getSymmetric(int deep) {
        TreeNode treeNode4 = new TreeNode(4);
        // right tree
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(2);
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;

        // left tree
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode4.left = treeNode2;
        treeNode4.right = treeNode6;

        return treeNode4;
    }

    public static TreeNode getTree(int deep) {
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode4.left = treeNode2;
        treeNode4.right = treeNode6;

        return treeNode4;
    }

    /**
     * 平衡二叉树
     *
     * @param nodeNumber
     * @return
     */
    public static TreeNode levelBineryTree(int nodeNumber) {
        ArrayList<Integer> arr = randomArray(nodeNumber);
        TreeNode result = null;
        for (Integer data : arr) {
            if (result == null) {
                result = new TreeNode(data);
            } else {
                levelAppendNode(data, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = levelBineryTree(10);
        System.out.println(treeNode);
    }

    /**
     * 返回的是当前节点
     * @param data
     * @param node
     * @return
     */
    private static TreeNode appendNode(Integer data, TreeNode node) {
        if (node == null) {
            TreeNode treeNode = new TreeNode(data);
            return treeNode;
        }
        if (data > node.data) {
            node.right = appendNode(data, node.right);

        } else {
            node.left = appendNode(data, node.left);
        }
        return node;
    }
    private static TreeNode levelAppendNode(Integer data, TreeNode node) {
        if (node == null) {
            TreeNode treeNode = new TreeNode(data);
            return treeNode;
        }
        // 判断
        if (data > node.data) {
            node.right = appendNode(data, node.right);

        } else {
            node.left = appendNode(data, node.left);
        }
        return node;
    }

    private static ArrayList<Integer> randomArray(int nodeNumber) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        int index = 0;
        do {
            int nextInt = random.nextInt(nodeNumber);
            if (!arr.contains(nextInt)) {
                index++;
                arr.add(nextInt);
            }
            if (index == nodeNumber) {
                break;
            }
        } while (true);
        return arr;
    }


    /**
     * 非平衡二叉树
     *
     * @param nodeNumber
     * @return
     */
    public static TreeNode nonlevelBineryTree(int nodeNumber) {
        ArrayList<Integer> arr = randomArray(nodeNumber);
        TreeNode treeNode = new TreeNode(arr.get(0));
        /*for (int i = 1; i < nodeNumber; i++) {

        }*/
        TreeNode result = null;
        for (Integer data : arr) {
            if (result == null) {
                result = new TreeNode(data);
            } else {
                appendNode(data, result);
            }
        }

        return result;
    }


}
