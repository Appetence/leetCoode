package org.example.leetcode.heap;

import java.util.PriorityQueue;

import org.example.leetcode.common.BaseArray;

/**
 * 给定数组，构建堆 ; 数组为几乎有序数组，几乎有序，限制规则 每个节点移动 K 位即可
 */
public class Code2_ArrayBuildHeapFilteRule {
  public static void main(String[] args) {
    int arr[] = { 1, 3, 4, 2, 7, 5, 6 };
    method(arr, 3);
    BaseArray.each(arr);

  }

  private static void method(int[] arr, int i) {
    if (arr == null && arr.length < 2)
      return;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int min = Math.min(arr.length, i);
    int idx = 0;
    int arrIdx = 0;
    for (; idx < min; idx++) {
      priorityQueue.offer(arr[idx]);
    }
    while (idx < arr.length) {
      arr[arrIdx++] = priorityQueue.poll();
      priorityQueue.offer(arr[idx++]);
    }
    while(!priorityQueue.isEmpty()){
      arr[arrIdx++] = priorityQueue.poll();
    }
    // for (int index = 0; index < arr.length; index++) {
    // heapInsert(arr, index);
    // }
  }

  private static void heapInsert(int[] arr, int index) {
    while (arr[index] > arr[(index - 1) / 2]) {
      BaseArray.swap(arr, index, (index - 1) / 2);
      index = (index - 1) / 2;
    }
  }
}
