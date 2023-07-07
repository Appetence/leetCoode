package org.example.leetcode.sort;

import org.example.leetcode.common.BaseArray;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-07-07 15:40
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] ints = BaseArray.baseArr();
        BaseArray.each(ints);
        insertionSort(ints);
        BaseArray.each(ints);
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
