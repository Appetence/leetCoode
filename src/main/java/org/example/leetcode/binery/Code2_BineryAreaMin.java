package org.example.leetcode.binery;

import org.example.leetcode.common.BaseArray;

/**
 * @program: Leetcode
 * @description: 二分法局部最小
 * @author: liuhao
 * @date: 2023-07-18 09:38
 */
public class Code2_BineryAreaMin {
    /**
     * 
     * 数据状况：二分不一定有序 ， 构建排他性
     * 问题本身：
     *
     */
    public static void main(String[] args) {
        int[] arr = BaseArray.baseArr();
        int index = bineryAreaMin(arr);
        System.out.println(index);
    }

    public static int bineryAreaMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
