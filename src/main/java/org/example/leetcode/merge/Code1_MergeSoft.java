package org.example.leetcode.merge;

import org.example.leetcode.common.BaseArray;

/**
 * @program: Leetcode
 * @description: 给定数组，归并排序
 * @author: liuhao
 * @date: 2023-07-06 10:38
 */
public class Code1_MergeSoft {
    public static void main(String[] args) {
        int[] arr = BaseArray.baseArr();
        // int[] arr = {9, 3, 4, 1};
        BaseArray.each(arr);
        //
        process(arr);

        BaseArray.each(arr);
    }

    private static void process(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // recursionProcess(arr, 0, arr.length - 1);
        // mergeSort(arr);
        c_mergeSort(arr);
    }

    private static void c_mergeSort(int[] arr) {
        // 非递归，
        if (arr == null || arr.length == 1) {
            return;
        }
        // 总元素个数
        int length = arr.length;
        int step = 1;
        while (step < length) {
            int left = 0;
            while (left < length) {
                // left + step -1 - 1体现为left 本身占一位
                // 步长在限定范围内
                int mid = 0;
                if (left + step - 1 < length - 1) {
                    mid = left + step - 1;
                } else {
                    mid = length - 1;
                }
                // 最左边界 不存在右侧数据，结束
                if (mid == length - 1) {
                    break;
                }

                int right;
                if (mid + step > length - 1) {
                    right = length - 1;
                } else {
                    right = mid + step;
                }
                merge(arr, left, mid, right);
                if (right == length - 1) {
                    break;
                } else {
                    left = right + 1;
                }
            }
            if (step <= length / 2) {
                step = step * 2;
            } else {
                break;
            }

        }
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
        // 步长
        int step = 1;
        while (step < length) {
            int L = 0;
            while (L < length) {
                int mid = 0;
                // 左节点
                // 从L开始，往后推 step -1 位置（包含L）
                if (length - L - 1 >= step - 1) {
                    // -1 是因为index 从0开始 左组最后一个节点的位置
                    mid = L + step - 1;
                } else {
                    mid = length - 1;
                }
                // 最左边界 不存在右侧数据，结束
                if (mid == length - 1) {
                    break;
                }
                int R = 0;
                // 从 mid + 1 开始 往后推 step -1 位
                if (length - 1 - mid >= step) {
                    // R = mid + 1 + step - 1;
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

}
