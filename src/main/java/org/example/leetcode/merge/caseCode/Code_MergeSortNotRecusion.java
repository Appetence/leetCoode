package org.example.leetcode.merge.caseCode;

import org.example.leetcode.sort.mergeSort;

/**
 * 非递归 归并
 * 
 * 核心点：
 * 1 offset 步长 从1 开始，按照 2 * offsset 递增，merge相邻的两个集合
 * 2 左半部分 右半部分 相同步长来限制数据范围
 * 3 结束条件 offset = length /2 。mid = length - 1 ， R = length -1
 */
public class Code_MergeSortNotRecusion {

  public static void main(String[] args) {

    int[] array = { 3, 8, 7, 1, 2, 6, 9 };
    // int[] array = { 3, 8, 2, 1 };

    process1(array);
    display(array);
  }

  private static void process1(int[] array) {
    if (array == null || array.length <= 0) {
      return;
    }
    int length = array.length;
    int offset = 1;
    while (offset < length) {
      int L = 0;

      while (L < length) {
        int M = 0;
        if (L + offset - 1 < length - 1) {
          M = L + offset - 1;
        } else {
          M = length - 1;
        }
        if (M == length - 1) {
          break;
        }
        int ans = M + offset;
        int R = ans >= length ? length - 1 : ans;
        merge(array, L, M, R);
        if (R == length - 1) {
          break;
        }
        L = R + 1;
      }
      if (offset >= (length / 2)) {
        break;
      }
      offset = offset * 2;
    }
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

  private static void mergeSort(int[] array, int begin, int mid, int end) {
    int[] help = new int[end - begin + 1];
    if (begin == end) {
      return;
    }
    int hIdx = 0;
    int beginIdx = begin;
    int mid2 = mid + 1;
    while (begin <= mid && mid2 <= end) {
      help[hIdx++] = array[begin] < array[mid2] ? array[begin++] : array[mid2++];
    }
    while (begin <= mid) {
      help[hIdx++] = array[begin++];
    }
    while (mid2 <= end) {
      help[hIdx++] = array[mid2++];
    }
    for (int item : help) {
      array[beginIdx++] = item;
    }
  }

  public static void display(int[] array) {

    for (int item : array) {

      System.out.println("node:" + item);
    }
  }

}
