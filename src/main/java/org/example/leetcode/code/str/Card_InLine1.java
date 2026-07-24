package org.example.leetcode.code.str;

public class Card_InLine1 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 100, 101, 5 };
        System.out.println(profit(arr));
    }

    private static int profit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        // 当前玩家能拿到的最大收益
        // n left n right
        int[][] dp = new int[n][n];

        /**
         * 先算只有 1 张牌的情况
         * 再算 2 张牌的情况
         * 再算 3 张牌的情况
         * 
         * 这样一步步往外扩
         * 因为算 dp[i][j](区间长度大)需要用到更短的子区间结果
         * ,比如 dp[i+1][j-1](去掉两头,长度小 2)
         * 。所以必须先算完所有短区间,再算长区间
         * ,这也是代码里外层循环 i 从大到小、
         * 内层 j 从小到大遍历的原因——保证用到的子问题都已经算好了。
         * 
         * dp[0][3]=103	4	依赖 dp[2][3]③、dp[1][2]⑤
         */
        for (int i = n - 1; i >= 0; i--) {
            // 如果区间里只有一张牌，那你当然拿它，收益就是这张牌的值
            dp[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                // 拿完之后，剩下的区间变成了 [i + 1, j]，对手会从里面继续拿。

                // 为了保证你最终拿到的收益最大，你会假设对手也会尽量拿到更多，
                // 所以你取“对手未来能拿到的最小收益”作为你这一步后的损失

                int takeLeft = arr[i] + (i + 2 <= j ?
                // 你拿了 i 剩下的是 [i+2][j] && [i + 1][j-1]
                        Math.min(dp[i + 2][j], dp[i + 1][j - 1]) : 0);
                int takeRight = arr[j] + (i <= j - 2 ?
                // 拿了 j 剩下
                        Math.min(dp[i + 1][j - 1], dp[i][j - 2]) : 0);
                // 从第i张牌到 第张h牌这一段 当前这个人最多能拿到多少value
                // dp[0][5] 就是整副牌的最优结果
                // dp[2][4] 就是从第 3 张到第 5 张这一段的最优结果
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }
        // 整副牌的最优结果
        return dp[0][n - 1];
    }
}
