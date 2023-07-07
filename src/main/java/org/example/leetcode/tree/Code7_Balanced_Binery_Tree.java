package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

import java.util.Objects;

/**
 * @program: Leetcode
 * @description: 二叉树，是否为平衡搜索二叉树
 * 平衡树：
 * 搜索树： 左数节点都比我小 右数节点都比我大
 * 平衡搜索二叉树：
 * @author: liuhao
 * @date: 2023-06-15 13:31
 */
public class Code7_Balanced_Binery_Tree {
    public static void main(String[] args) {
        // 平衡二叉树 最高节点 最低节点 高度差 不超过 1
        TreeNode tree = TreeNodeBuild.getTree(3);
        NodeInfo nodeInfo = checkBalanceBineryTree(tree);
        System.out.println(nodeInfo);
    }

    private static NodeInfo checkBalanceBineryTree(TreeNode tree) {
        if (Objects.isNull(tree)) {
            NodeInfo nodeInfo = new NodeInfo(0, true);
            return nodeInfo;
        }

        NodeInfo leftInfo = checkBalanceBineryTree(tree.left);
        NodeInfo rightInfo = checkBalanceBineryTree(tree.right);
        boolean isLevelBineryTree = leftInfo.isLevelBineryTree() && rightInfo.isLevelBineryTree()
                && Math.abs(leftInfo.getHeight() - rightInfo.getHeight()) <= 1;
        int height = Math.max(leftInfo.getHeight(), rightInfo.getHeight()) + 1;
        return new NodeInfo(height,isLevelBineryTree);
    }
}

class NodeInfo {
    private int height;
    private boolean isLevelBineryTree;

    public NodeInfo(int height, boolean isLevelBineryTree) {
        this.height = height;
        this.isLevelBineryTree = isLevelBineryTree;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isLevelBineryTree() {
        return isLevelBineryTree;
    }

    public void setLevelBineryTree(boolean levelBineryTree) {
        isLevelBineryTree = levelBineryTree;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "height=" + height +
                ", isLevelBineryTree=" + isLevelBineryTree +
                '}';
    }
}
