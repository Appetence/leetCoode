package org.example.leetcode.heap.buildHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.example.leetcode.common.BaseArray;

public class Code7_ArrayBuildHeapFilterRule {
  /**
   * 给定数组，构建堆 ; 数组为几乎有序数组，几乎有序，限制规则 每个节点移动 K 位即可
   * 
   * @param args
   */
  public static void main(String[] args) {
    int arr[] = { 1, 3, 4, 2, 7, 5, 6 };
    buildHeap(arr, 3);
    BaseArray.each(arr);
  }

  private static void buildHeap(int[] arr, int k) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int limit = arr.length < k ? arr.length : k;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int idx = 0; idx < arr.length; idx++) {
      if (minHeap.size() > limit) {
        arr[idx - limit] = minHeap.poll();
      }
      minHeap.add(arr[idx]);
    }

    while (!minHeap.isEmpty()) {
      arr[arr.length - limit + 1] = minHeap.poll();
    }

  }

  private static List<Line> baseData() {
    List<Line> list = new ArrayList<>();
    list.add(new Line(1, 3));// 3
    list.add(new Line(2, 6));// 3
    list.add(new Line(4, 9));// 3
    list.add(new Line(1, 5));// 5
    list.add(new Line(2, 3));// 3
    return list;
  }
}

class Line {
  public int end;
  public int start;

  public Line(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Line [end=" + end + ", start=" + start + "]";
  }

}