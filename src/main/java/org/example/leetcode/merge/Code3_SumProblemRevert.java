package org.example.leetcode.merge;

public class Code2_SumProblem {
    public static void main(String[] args) {
        countSmallSum(new int[3]);
    }

    private static int countSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private static int process(int[] arr, int l, int r, int[] help) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid, help) + process(arr, mid + 1, r, help) + merge(arr, l, mid, r, help);

    }

    private static int merge(int[] arr, int l, int mid, int r, int[] help) {
        int res = 0;

        int hi = l;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                res += (r - p2 + 1) * arr[p1];
                help[hi++] = arr[p1++];
            } else {
                help[hi++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[hi++] = arr[p1++];
        }
        while (p2 <= r) {
            help[hi++] = arr[p2++];
        }
        for (int i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return res;
    }
}
