package org.example.leetcode.queneProblem;

public class QueneProblem {

    public static int sum2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /**
     * 保证 不在同一列，非左对角 非右对角 排除这些位置，即可用
     * 
     * @param limit       限制位的大小
     * @param colLim      列俄限制 ，1 的位置不能放皇后，0饿位置可以
     * @param leftDiaLim  左斜线的限制，1 的位置不能放皇后 0 的可以
     * @param rightiaiLim 右斜线俄限制 1 的位置不能放皇后 0 的可以
     * @return
     */
    private static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            // 每一列都被填充
            return 1;
        }

        // 能被选做 queue的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));

        int mostRightOne = 0;

        int res = 0;
        while (pos != 0) {
            // 10010 -> ~ 01101 + 1 -》 01110 & 获取最右侧的1
            mostRightOne = pos & (~pos + 1);
            // - 最右侧的1 代表该位被占用 因为-1 所以只要非0 的场景下，都代表我有位置可以试试
            pos = pos - mostRightOne;
            // 新的colLim 左对角 右对角 包含所有已经被占用的位置
            res += process2(limit, (colLim | mostRightOne), ((leftDiaLim | mostRightOne) << 1),
                    ((rightDiaLim | mostRightOne) >>> 1));

        }
        return res;
    }
}
