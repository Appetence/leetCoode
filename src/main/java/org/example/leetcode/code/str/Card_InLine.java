package org.example.leetcode.code.str;

public class Card_InLine {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 100, 101, 5 };
        System.out.println(profit(arr));
    }

    private static int profit(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int s = s(arr, 0, arr.length - 1);
        int f = f(arr, 0, arr.length - 1);
        return Math.max(s, f);
    }

    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        // 后手 最小值
        int min = Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
        return min;
    }

    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        // 当前元素 + 后手范围内 能拿到的最大值
        int max = Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
        return max;
    }
}
