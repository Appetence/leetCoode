package org.example.leetcode.merge.soft;

/**
 * 给定一组数据
 * 1 统计当前节点大于2倍右侧节点数据之和
 * 2 统计当前节点大于2倍左侧节点数据之和
 */
public class Code3_CountLeftGreateTwoRight {

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 2, 2, 7 };
    int result = countLeftGreaterTwoRight(arr);
    System.out.println("result is :" + result);

  }

  private static int countLeftGreaterTwoRight(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return 0;
    }
    // return countLeftGreaterTwoRight(arr, 0, arr.length - 1);
    return countRightGreaterTwoLeft(arr, 0, arr.length - 1);
  }

  private static int countRightGreaterTwoLeft(int[] arr, int L, int R) {
    if (arr == null || arr.length <= 1 || L >= R) {
      return 0;
    }

    int mid = (L + R) >> 1;
    int leftSize = countRightGreaterTwoLeft(arr, L, mid);
    int rightSize = countRightGreaterTwoLeft(arr, mid + 1, R);

    int size = countRightGreateTwoLeft(arr, L, mid, R);
    return leftSize + rightSize + size;
  }

  private static int countRightGreateTwoLeft(int[] arr, int L, int mid, int R) {
    int pL = L;
    int pR = mid + 1;
    int result = 0;
    // while (pL <= mid && pR <= R) {
    // // 右边大于2 * 左边
    // if (arr[pR] > 2 * arr[pL]) {
    // System.out.println("right node = 2 * left Node " + arr[pR] + " nodeL " +
    // arr[pL]);
    // pL++;
    // // 满足条件时候统计一下后边有多少个数
    // result += R - pR + 1;
    // } else {
    // pR++;
    // }
    // }

    for (; pR <= R; pR++) {
      while (pL <= mid && arr[pR] > 2 * arr[pL]) {
        System.out.println("right node = 2 * left Node " + arr[pR] + " nodeL " + arr[pL]);
        pL++;
        result += R - pR + 1;
      }
      /**
       * 每次满足条件单独计算一下有多少个数据 效率低
       */
      // result = pL - L;
    }
    int[] help = new int[R - L + 1];
    int idx = 0;
    pL = L;
    pR = mid + 1;
    while (pL <= mid && pR <= R) {
      help[idx++] = arr[pL] > arr[pR] ? arr[pR++] : arr[pL++];
    }

    while (pR <= R)

    {
      help[idx++] = arr[pR++];
    }
    while (pL <= mid) {
      help[idx++] = arr[pL++];

    }

    return result;
  }

  private static int countLeftGreaterTwoRight(int[] arr, int L, int R) {

    if (L >= R) {
      return 0;
    }
    int mid = (R + L) >> 1;
    int leftSize = countLeftGreaterTwoRight(arr, L, mid);
    int rightSize = countLeftGreaterTwoRight(arr, mid + 1, R);
    int size = checkAndMerge(arr, L, mid, R);
    return leftSize + rightSize + size;
  }

  private static int checkAndMerge(int[] arr, int L, int mid, int R) {
    // 左侧值大于 2倍右侧值的节点
    int pL = L;
    int pR = mid + 1;
    int windowR = pR;
    int result = 0;

    int ppL = L;
    int ppR = pR;
    for (; pL <= mid; pL++) {
      while (pR <= R && arr[pL] > 2 * arr[pR]) {
        System.out.println("full rule data is :" + arr[pL] + " nodeR is =" + arr[pR]);
        // 满足条件，后推
        pR++;
      }
      // 多少个
      result += pR - windowR;
    }
    int[] help = new int[R - L + 1];
    int idx = 0;
    while (ppL <= mid && ppR <= R) {
      help[idx++] = arr[ppL] > arr[ppR] ? arr[ppR++] : arr[ppL++];
    }

    while (ppR <= R) {
      help[idx++] = arr[ppR++];
    }
    while (ppL <= mid) {
      help[idx++] = arr[ppL++];

    }
    return result;
  }

}
