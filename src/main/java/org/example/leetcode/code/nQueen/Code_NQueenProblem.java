package org.example.leetcode.code.nQueen;

public class Code_NQueenProblem {
    //
    public static void main(String[] args) {

        // 传统递归
        // 位运算问题
        int n = 3;
        int[] record = new int[n];
        if (n < 1) {
            return;
        }
        int result = process1(0, record, n);

    }

    private static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 0;
        }
        // 每一行选第几列

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;

                res += process1(i + 1, record, n);
            }

        }

        return -1;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int idx = 0; idx < i; idx++) {
            // 共斜线或者同列gktltl1
            return Math.abs(record[idx] - j) == Math.abs(idx - i) || j = record[idx];

        }
        return false;
    }
}
