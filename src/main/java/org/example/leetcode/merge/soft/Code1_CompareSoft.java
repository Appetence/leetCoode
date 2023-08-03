package org.example.leetcode.merge.soft;

/**
 * 给定一组数据
 */
public class Code1_CompareSoft {
  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 2, 7 };
    // int leftSize = countRightGreaterLeft(arr);
    // System.out.println(leftSize);
    int rightSize = countLeftGreaterRight(arr);
    System.out.println(rightSize);

  }

  private static int countRightGreaterLeft(int[] arr) {
    if (arr == null || arr.length == 0)
      return 0;
    return righterThanLeft(arr, 0, arr.length - 1);
  }

  private static int righterThanLeft(int[] arr, int L, int R) {

    // 截止条件
    if (L == R) {
      return 0;
    }
    int mid = L + ((R - L) >> 1);

    int leftCount = righterThanLeft(arr, L, mid);

    int rightCount = righterThanLeft(arr, mid + 1, R);
    int mergeResult = merge(arr, L, mid, R);
    return leftCount + rightCount + mergeResult;
  }

  private static int merge(int[] arr, int L, int mid, int R) {
    int i = 0;
    int hL = L;
    int hR = mid + 1;
    int size = 0;
    int[] help = new int[R - L + 1];

    // 左右都有数据的情况
    while (hL <= mid && hR <= R) {
      if (arr[hL] < arr[hR]) {
        size += R - hR + 1;
        help[i++] = arr[hL++];
      } else {
        help[i++] = arr[hR++];
      }
    }
    while (hL <= mid) {
      help[i++] = arr[hL++];
    }
    while (hR <= R) {
      help[i++] = arr[hR++];
    }
    // 原数组变有序必不可少
    for (int index = 0; index < help.length; index++) {
      arr[L + index] = help[index];
    }
    return size;
  }

  /**
   * 右边大于左边
   * 
   * @param arr
   * @return
   */
  private static int countLeftGreaterRight(int[] arr) {
    if (arr == null || arr.length < 2) {
      return 0;
    }
    return leftGreaterRight(arr, 0, arr.length - 1);
  }

  private static int leftGreaterRight(int[] arr, int L, int R) {
    // end filter
    if (L == R) {
      return 0;
    }
    int mid = L + ((R - L) >> 1);
    int leftCount = leftGreaterRight(arr, L, mid);
    int rightCount = leftGreaterRight(arr, mid + 1, R);

    int merge = mergeLeftGreaterRight(arr, L, mid, R);
    return leftCount + rightCount + merge;
  }

  private static int mergeLeftGreaterRight(int[] arr, int L, int mid, int R) {

    int i = 0;
    int pL = L;
    int pR = mid + 1;
    int result = 0;
    int windowR = mid + 1;
    // 左右都存在数据时候，统计下左边大于右边的数据
    // 本质 左侧元素排好序，依次遍历，记录当前元素之前大于右侧几个元素，后续遍历时候直接相加
    for (int idx = L; idx <= mid; idx++) {
      while (windowR <= R && arr[idx] > (arr[windowR])) {
        windowR++;
      }
      result += windowR - mid - 1;
    }

    // 有限大小，做一个中间数组 对数据进行排序
    int[] help = new int[R - L + 1];
    while (pL <= mid && pR <= R) {
      help[i++] = arr[pL] <= arr[pR] ? arr[pL++] : arr[pR++];
    }
    while (pL <= mid) {
      help[i++] = arr[pL++];
    }
    while (pR <= R) {
      help[i++] = arr[pR++];
    }
    for (int index = 0; index < help.length; index++) {
      arr[L + index] = help[index];
    }

    return result;
  }
}
