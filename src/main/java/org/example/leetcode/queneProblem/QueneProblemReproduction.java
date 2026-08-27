package org.example.leetcode.queneProblem;

public class QueneProblemReproduction {
    public static void main(String[] args) {
        int n = 8;
        quereProblem(n);
    }

    private static int quereProblem(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    private static int process(int limit, int cur, int left, int right) {
        if (cur == limit) {
            return -1;
        }
        //  可以放的位置
        int pos = limit & ~(cur | left | right);
        int res = 0;
        int mostRight = 0;
        while (pos != 0) {
            mostRight = pos & -pos;
            pos = pos - mostRight;
            res += process(limit, (cur | mostRight), (left | mostRight) << 1, (right | mostRight) >>> 1);
        }

        return res;
    }

}
