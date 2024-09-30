package org.example.leetcode.merge.caseCode;

/**
 * 归并排序
 * 给定数组，计算右侧元素大于当前元素的个数之和
 */
public class Code_MergeMinSum {
  public static void main(String[] args) {
    int[] array = { 9, 3, 8, 7, 1, 2, 6, 9, 9 };
    int minSum = minSum(array);
    System.out.println(minSum);

    System.out.println(">>>>>>");
    for (int num : array) {
      System.out.println(num);
    }
  }

  private static int minSum(int[] array) {
    if (array == null || array.length < 2) {
      return 0;
    }
    int length = array.length;
    int sum = mergeSum(array, 0, length - 1);

    return sum;
  }

  private static int mergeSum(int[] array, int left, int right) {
    if (left >= right) {
      return 0;
    }
    int mid = (right + left) / 2;

    int leftSum = mergeSum(array, left, mid);
    int rightSum = mergeSum(array, mid + 1, right);

    int ans = merge(array, left, mid, right);

    return leftSum + rightSum + ans;
  }

  private static int merge(int[] array, int left, int mid, int right) {
    int lI = left;
    int rI = mid + 1;
    int hI = 0;
    int[] help = new int[right - left + 1];
    int ans = 0;
    while (lI <= mid && rI <= right) {
      if (array[lI] < array[rI]) {
        ans += right - rI + 1;
        help[hI++] = array[lI];
        lI++;
      } else if (array[lI] >= array[rI]) {
        help[hI++] = array[rI];
        rI++;
      }
    }
    while (lI <= mid) {
      help[hI++] = array[lI++];
    }
    while (rI <= right) {
      help[hI++] = array[rI++];
    }
    for (int i = 0; i < right - left + 1; i++) {
      array[left + i] = help[i];
    }
    return ans;
  }
}
