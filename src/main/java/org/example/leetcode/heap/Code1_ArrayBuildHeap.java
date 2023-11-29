package org.example.leetcode.heap;

import org.example.leetcode.common.BaseArray;

/**
 * 给定数据，构建数组
 * 
 * 从下向上构建 时间复杂度 O(N)
 * 从上向下构建 时间复杂度 O(N * log N)
 */
public class Code1_ArrayBuildHeap {

  public static void main(String[] args) {
    // int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
    int arr[] = { 1, 7, 3, 4, 5, 6, 2 };
    // int[] arr = { 7, 3, 4, 5, 6, 1, 2 };
    // 构建堆
    // method1(arr);
    // 构建堆并排序
    // heapSort(arr);
    heapSort2(arr);
    BaseArray.each(arr);
  }

  private static void heapSort2(int[] arr) {

    if (arr == null || arr.length < 2) {
      return;
    }
    // 将数组构建成堆log(N)
    for (int idx = 0; idx < arr.length; idx++) {
      lowerRootHeapInsert(arr, idx);
    }
    // 排序
    int heapSize = arr.length;
    // 将最大数移动到堆末尾
    BaseArray.swap(arr, 0, --heapSize);
    // N * log N
    while (heapSize > 0) {
      // 0 - ( length - 1 ) 重新生产大根堆
      lowerRootHeapify(arr, 0, heapSize);
      BaseArray.swap(arr, 0, --heapSize);
    }
  }

  private static void heapSort(int[] arr) {

    if (arr == null || arr.length < 2) {
      return;
    }
    // 将数组构建成堆
    for (int idx = 0; idx < arr.length; idx++) {
      heapInsert(arr, idx);
    }
    // 排序
    int heapSize = arr.length;
    // 将最大数移动到堆末尾
    BaseArray.swap(arr, 0, --heapSize);
    // N* log N
    while (heapSize > 0) {
      // 0 - ( length - 1 ) 重新生产大根堆
      heapify(arr, 0, heapSize);
      //将最大的永远限制在末尾
      BaseArray.swap(arr, 0, --heapSize);
    }

  }

  private static void method1(int[] arr) {
    // 依据数组构建一个堆
    // for (int index = 0; index < arr.length; index++) {
    // heapInsert(arr, index);
    // }
    // 从下向上插入构建堆
    // for (int index = arr.length; index >= 0; index--) {
    // heapify(arr, index, arr.length);
    // }

    // 小根堆
    // for (int index = 0; index < arr.length; index++) {
    // lowerRootHeapInsert(arr, index);
    // }
    // 小根堆 从下到上排序
    for (int index = arr.length; index > 0; --index) {
      lowerRootHeapify(arr, index, arr.length);
    }

    // heapify(arr)
  }

  private static void lowerRootHeapify(int[] arr, int index, int heapSize) {
    int left = 2 * index + 1;
    while (left < heapSize) {
      // 子节点取最小值 注意限制 size < heapSize
      int subMinIndex = (left + 1 < heapSize && arr[left + 1] < arr[left]) ? left + 1 : left;
      // 树最小值
      int minIdx = arr[index] > arr[subMinIndex] ? subMinIndex : index;
      if (minIdx == index) {
        break;
      }

      BaseArray.swap(arr, index, minIdx);
      // 新的子节点做当前节点
      index = minIdx;
      left = 2 * index + 1;

    }
  }

  private static void lowerRootHeapInsert(int[] arr, int index) {
    while (arr[index] < arr[(index - 1) / 2]) {
      BaseArray.swap(arr, index, (index - 1) / 2);
      index = (index - 1) / 2;
    }
  }

  // 判断当前节点的子节点大小
  private static void heapify(int[] arr, int index, int heapSize) {
    int left = (2 * index) + 1;
    while (left < heapSize) {
      // 最大的子节点
      int largest = (left + 1 < heapSize) && arr[left] < arr[left + 1] ? left + 1 : left;
      // 最大的子节点是否等于当前节点
      int maxIndex = arr[largest] > arr[index] ? largest : index;
      if (maxIndex == index) {
        // 当前节点是小堆的最大节点
        break;
      }
      BaseArray.swap(arr, index, largest);
      index = largest;
      left = (index * 2) + 1;

    }

  }

  // 判断当前节点的上一个节点是多少
  private static void heapInsert(int[] arr, int index) {
    // 判断父节点 大小
    while (arr[index] > arr[(index - 1) / 2]) {
      BaseArray.swap(arr, index, (index - 1) / 2);
      index = (index - 1) / 2;
    }
  }

}
