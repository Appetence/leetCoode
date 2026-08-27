package org.example.leetcode.code.arr;

public class Code_BagProblem {

    // 给定两个数组,weight 和 value 求 指定bag 最大的权益

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5 };
        int[] values = { 1, 2, 3, 4, 5 };

        int bag = 5;
        int alreadyWeight = 0;
        process(weights, values, 0, alreadyWeight, bag);
    }

    private static int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {

        if (weights.length == i || alreadyWeight >= bag) {
            return 0;
        }

        return Math.max(process(weights, values, i + 1, alreadyWeight, bag),
                values[i] + process(weights, values, i + 1, weights[i] + alreadyWeight, bag));
    }
}
