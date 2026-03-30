package org.example.dataStruct.quick;

import java.util.concurrent.ThreadLocalRandom;

import org.example.leetcode.common.BaseArray;

public class QuickSort_Recursion {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("Before: " + java.util.Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After:  " + java.util.Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // Math.random() * (r - l + 1) 在区间范围内随机一个位置，避免最差勤快
            // BaseArray.swap(arr, l + (int) (Math.random() * ((r - l + 1))), r);
            BaseArray.swap(arr, ThreadLocalRandom.current().nextInt(l, r + 1), r);
            int[] result = partition(arr, l, r);
            quickSort(arr, l, result[0]);
            quickSort(arr, result[1], r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;

        // low area ！= high area
        while (l < more) {
            if (arr[l] < arr[r]) {
                // 小于区间右推
                BaseArray.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 大于区间左移
                BaseArray.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // r is pivot
        BaseArray.swap(arr, more, r);
        return new int[] { less, more + 1 };

    }
}
