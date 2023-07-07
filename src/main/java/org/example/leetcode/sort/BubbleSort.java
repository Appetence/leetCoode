package org.example.leetcode.sort;

import org.example.leetcode.common.BaseArray;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-07-07 15:30
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = BaseArray.baseArr();
        BaseArray.each(ints);
        bubbleSort(ints);
        BaseArray.each(ints);
    }

    private static void bubbleSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            int ans;
            for (int j = i+1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    ans = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = ans;
                }
            }
        }

    }
}
