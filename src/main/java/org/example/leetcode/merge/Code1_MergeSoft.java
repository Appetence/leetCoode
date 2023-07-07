package org.example.leetcode.merge;

/**
 * @program: Leetcode
 * @description: 给定数组，归并排序
 * @author: liuhao
 * @date: 2023-07-06 10:38
 */
public class Code1_MergeSoft {
    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 1, 2, 5, 6, 0, 1, 0, 1, 23, 22, 566, 1};
//        int[] arr = {9, 3, 4, 1};
        each(arr);
        //
        process(arr);

        each(arr);
    }

    private static void process(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        recursionProcess(arr, 0, arr.length - 1);
        mergeSort(arr);
    }

    /**
     * 非递归调用
     *
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        // 二分法 1 2 4 8 16 作为边界
        // 做大index
        int length = arr.length;
        // 第几步骤
        int step = 1;
        while (step < length) {
            int L = 0;
            while (L < length) {
                int mid = 0;
                // 左节点
                if (length - L >= step) {
                    mid = L + step - 1;
                } else {
                    mid = length - 1;
                }
                // 最左边界
                if (mid == length - 1) {
                    break;
                }
                int R = 0;
                if (length - 1 - mid >= step) {
                    R = mid + step;
                } else {
                    R = length - 1;
                }
                merge(arr, L, mid, R);
                if (R == length - 1) {
                    // 最右边界
                    break;
                } else {
                    L = R + 1;
                }

            }
            if (step <= length / 2) {
                // 继续下次
                step = step * 2;
            } else {
                break;
            }
        }


    }

    /**
     * 递归调用
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void recursionProcess(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        // 临界点
        int mid = left + ((right - left) >> 2);

        // 左边界
        recursionProcess(arr, left, mid);
        // 右边界
        recursionProcess(arr, mid + 1, right);

        // 合并
        merge(arr, left, mid, right);


    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 两个数组边界两辆比较替换
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int h = 0; h < help.length; h++) {
            arr[left + h] = help[h];
        }
    }

    static void each(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(">>");
    }
}
