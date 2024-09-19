package org.example.leetcode.merge.caseCode;

public class MergeSortByRecusion {
  public static void main(String[] args) {
    // 给定指定一组数据，排序
    Integer[] array = { 3, 8, 7, 1, 2, 6, 9 };
    recusion(array);
  }

  private static void recusion(Integer[] array) {
    if (array == null || array.length == 0) {
      throw new RuntimeException();
    }
    process(array, 0, array.length - 1);

    for (Integer item : array) {
      System.out.println(item);
    }
    return;
  }

  private static void process(Integer[] array, int i, int length) {
    int mid = i + (length - i) / 2;

    if (length == i) {
      // begin = end
      return;
    }

    process(array, 0, mid);
    process(array, mid + 1, length);
    merge(array, i, mid, length);
  }

  private static void merge(Integer[] array, int begin, int mid, int end) {
    Integer[] help = new Integer[end - begin + 1];
    int i = 0;
    int idx = begin;
    int idxAfter = mid + 1;

    while (idx <= mid && idxAfter <= end) {
      int item = array[idx] < array[idxAfter] ? array[idx++] : array[idxAfter++];
      help[i++] = item;
    }

    while (idx <= mid) {
      help[i++] = array[idx++];
    }
    while (idxAfter <= end) {
      help[i++] = array[idxAfter++];
    }
    for (Integer item : help) {
      array[begin++] = item;
    }
  }
}
