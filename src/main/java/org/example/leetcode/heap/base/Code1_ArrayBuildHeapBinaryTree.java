package org.example.leetcode.heap.base;

import java.util.Arrays;

import org.example.leetcode.common.BaseArray;

/**
 * 二叉树构建堆
 */
public class Code1_ArrayBuildHeapBinaryTree {

    public static void main(String[] args) {
        int[] baseArr = BaseArray.baseArr();

        System.out.println(Arrays.toString(baseArr));
        heapSort(baseArr);
        System.out.println(Arrays.toString(baseArr));
    }

    private static void heapSort(int[] baseArr) {
        if (baseArr == null || baseArr.length <= 1) {
            return;
        }
        // 先构建堆
        // int i = 0;
        // while (i < baseArr.length) {
        // heapInsert(baseArr, i++);
        // }
        int n = baseArr.length;
        // 叶子节点 n/2 - n-1 范围 ，从最后一个非叶子节点开始heapify，向根节点方向
        // 叶子节点已是堆，从下网上确保父子关系正确
        // 最后一个非叶子节点索引 n / 2 - 1 = floor((n -1) / 2)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(baseArr, i, n);

        for (int heapSize = n; heapSize > 1; heapSize--) {
            swap(baseArr, 0, heapSize - 1);
            heapify(baseArr, 0, heapSize - 1);
        }
    }

    private static void heapify(int[] baseArr, int idx, int heapSize) {
        int left = 2 * idx + 1;

        while (left < heapSize) {
            int largest = (left + 1) < heapSize && baseArr[left + 1] > baseArr[left] ? left + 1 : left;

            int maxIdx = baseArr[largest] < baseArr[idx] ? idx : largest;
            if (maxIdx == idx) {
                return;
            }
            swap(baseArr, idx, maxIdx);
            idx = maxIdx;
            left = 2 * idx + 1;
        }
    }

    private static void heapInsert(int[] baseArr, int idx) {

        int cur = idx;
        int parent = (cur - 1) / 2;
        while (baseArr[cur] > baseArr[parent]) {
            swap(baseArr, cur, parent);
            cur = parent;
            parent = (cur - 1) / 2;
        }
    }

    private static void swap(int[] arr, int cur, int parent) {
        if (cur == parent) {
            return;
        }
        arr[cur] = arr[cur] ^ arr[parent];
        arr[parent] = arr[cur] ^ arr[parent];
        arr[cur] = arr[cur] ^ arr[parent];
    }
}
