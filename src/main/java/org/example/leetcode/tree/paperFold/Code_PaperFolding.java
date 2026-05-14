package org.example.leetcode.tree.paperFold;

/**
 * 二叉树，
 * 左边头节点都是 凹
 * 右边头节点都是 凸
 */
public class Code_PaperFolding {
    public static void main(String[] args) {
        int N = 3;
        paperFolding(1, N, true);
    }

    private static void paperFolding(int i, int N, boolean b) {
        if (i > N) {
            // end flag 
            return;
        }
        paperFolding(i + 1, N, true);
        System.out.println(b ? "凹" : "凸");
        paperFolding(i + 1, N, false);
    }

}
