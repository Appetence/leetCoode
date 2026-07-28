package org.example.leetcode.code.nQueen;

public class Code_NQueenProblem2 {
    public static void main() {
        num2(3);
    }

    private static int num2(int n) {
        if (n < 1) {
            return 0;
        }
        int upperLimit = n < 32 ? 1 << n - 1 : -1;
        return process(upperLimit, 0, 0, 0);

    }

    private static int process(int upperLim, int colLim, int lDiaLim, int rDiaLim) {

        if (colLim == upperLim) {
            return 1;
        }

        int mostRightOne = 0;
        // all effective range
        int pos = upperLim & ~(colLim | lDiaLim | rDiaLim);

        int res = 0;
        while (pos != 0) {
            // low to high
            mostRightOne = pos & (~pos - 1);
            // reverse lower bound
            pos = pos - mostRightOne;
            res += process(upperLim, (colLim | mostRightOne), (lDiaLim | mostRightOne) << 1,
                    (rDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
