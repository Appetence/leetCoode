package org.example.leetcode.heap.buildHeap;

import org.example.leetcode.common.BaseArray;
import org.example.leetcode.util.ArrayUtil;

/**
 * 给定数据，构建数组
 * 
 * 从下向上构建 时间复杂度 O(N)
 * 从上向下构建 时间复杂度 O(N * log N)
 */
public class Code5_ArrayBuildHeap {

  public static void main(String[] args) {
    int[] arr = { 1, 5, 8, 9, 2 };
    int[] result = heapSort(arr);
    BaseArray.each(result);
  }

  private static int[] heapSort(int[] arr) {
    int heapSize = arr.length;
    // 数组建堆
    for (int idx = 0; idx < arr.length; idx++) {
      buildHeap(arr, idx);
    }
    // 堆排序
    // 将头结点移动到末尾
    BaseArray.swap(arr, 0, --heapSize);
    while (heapSize > 0) {
      heapifySort(arr, 0, heapSize);

      BaseArray.swap(arr, 0, --heapSize);
    }

    return arr;
  }

  private static void heapifySort(int[] arr, int idx, int heapSize) {
    int left = (idx * 2) + 1;
    while (left < heapSize) {
      int largest = (left + 1) < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
      int maxId = arr[largest] > arr[idx] ? largest : idx;
      if (maxId == idx) {
        return;
      }
      BaseArray.swap(arr, idx, largest);
      // 索引变更
      idx = largest;
      left = (idx * 2) + 1;
    }

  }

  private static void buildHeap(int[] arr, int idx) {
    while (arr[(idx - 1) / 2] < arr[idx]) {
      int item = arr[(idx - 1) / 2];
      arr[(idx - 1) / 2] = arr[idx];
      arr[idx] = item;
      idx = (idx - 1) / 2;
    }
  }

}