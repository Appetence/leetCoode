package org.example.leetcode.tree;

import org.example.leetcode.common.TreeNode;
import org.example.leetcode.common.TreeNodeBuild;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description: 二叉树，按层遍历 收集节点
 * @author: liuhao
 * @date: 2023-06-15 13:31
 */
public class Code6_Level_Binery_Count {

    public static void main(String[] args) {
        TreeNode tree = TreeNodeBuild.getTree(3);
        List<List<Integer>> result = new LinkedList<>();
        levelBineryCount(tree, result);
        System.out.println(result);

    }

    private static void levelBineryCount(TreeNode tree, List<List<Integer>> result) {
        if (tree == null) {
            return;
        }
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curAns.add(poll.data);
                if (Objects.nonNull(poll.left)) {
                    queue.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    queue.add(poll.right);
                }
            }
            result.add(curAns);
        }
    }
}
