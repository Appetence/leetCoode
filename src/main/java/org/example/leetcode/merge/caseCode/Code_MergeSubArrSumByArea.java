package org.example.leetcode.merge.caseCode;

import javafx.stage.Window;

/**
 * 子数组的累加和在指定范围内
 * 
 */
public class Code_MergeSubArrSumByArea {
  static int upper = 4;
  static int lose = 2;

  public static void main(String[] args) {

    int[] arr = { 3, 1, 2, 7, 5, 4 };
    // int[] arr = new int[] { 1, -2, 4 };
    int result = countSubArr(arr, 0, arr.length - 1);
    System.out.println("result is " + result);
  }

  private static int countSubArr(int[] arr, int L, int R) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int[] sum = new int[R + 1];
    sum[0] = arr[0];
    for (int i = 1; i <= R; i++) {
      sum[i] = sum[i - 1] + arr[i];
    }
    return countArray(sum, L, R);
  }

  private static int countArray(int[] arr, int L, int R) {
    if (L == R) {
      if (arr[L] >= lose && arr[R] <= upper) {
        return 1;
      }
      return 0;
    }

    int mid = (R + L) >> 1;
    int left = countArray(arr, L, mid);
    int right = countArray(arr, mid + 1, R);
    int result = merge(arr, L, mid, R);

    return left + right + result;

  }

  /**
   * 子数组之和 在指定区间内 （lose uppe） 当前节点之前的数组之和在 （node - uppe ， node - lose 内）
   * 
   * @param arr
   * @param L
   * @param mid
   * @param R
   * @return
   */
  private static int merge(int[] arr, int L, int mid, int R) {
    int windowL = L;
    int windowR = L;
    int size = 0;
    for (int i = mid + 1; i <= R; i++) {
      // 随着arr[i] 越来越大，max min 都是越来越大，
      int min = arr[i] - upper;
      int max = arr[i] - lose;
      // 这么写的好处就是可以减少重复的遍历判断
      // 上边界
      while (windowR <= mid && arr[windowR] <= max) {
        windowR++;
      }
      // 下边界 之所以不用== 是因为下边界的界定
      while (windowL <= mid && arr[windowL] < min) {
        windowL++;
      }
      // 之所以用差 是因为每次偏移后复合范围的数据会变化
      size += windowR - windowL;
    }

    int[] help = new int[R - L + 1];
    int idx = 0;
    int hl = L;
    int hr = mid + 1;
    while (hl <= mid && hr <= R) {
      help[idx++] = arr[hl] > arr[hr] ? arr[hr++] : arr[hl++];
    }

    while (hr <= R) {
      help[idx++] = arr[hr++];
    }
    while (hl <= mid) {
      help[idx++] = arr[hl++];
    }
    // sort
    for (int sI = 0; sI < help.length; sI++) {
      arr[L + sI] = help[sI];
    }
    return size;
  }

}
