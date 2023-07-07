package org.example.leetcode.sort;

import org.example.leetcode.common.BaseArray;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-07-07 15:03
 */
public class SelectSort {
    /**
     * 选排
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] ints = BaseArray.baseArr();
        BaseArray.each(ints);
        selectSort(ints);
        BaseArray.each(ints);

    }

    private static void selectSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            int ans = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    ans = j;
                }
            }
            if(ans != i){
                int temp = arrs[i];
                arrs[i] = arrs[ans];
                arrs[ans] = temp;
            }
        }
    }
}
