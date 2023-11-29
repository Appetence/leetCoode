
package org.example.leetcode.tree;

/**
 * @program: Leetcode
 * @description: 给定指定数组，判断是否符合先序遍历
 * @author: liuhao
 * @date: 2023-06-26 19:26
 */
public class Code11_BeforeEach {
  public static void main(String[] args) {
    /**
     * 先序， 头节点在最左边
     */

    int[] arr = { 5, 2, 1, 3, 4, 6 };
    System.out.println(beforeEach(arr));

  }

  private static boolean beforeEach(int[] arr) {
    if (arr == null) {
      return false;
    }
    if (arr.length < 2) {
      return true;
    }
    return isBeforeEach(arr, 0, arr.length - 1);

  }

  private static boolean isBeforeEach(int[] arr, int begin, int end) {
    if (begin >= end) {
      return true;
    }
    int head = arr[begin];
    int beginRightIndex = 0;
    for (int idx = begin + 1; idx <= end; idx++) {
      if (arr[idx] > head) {
        beginRightIndex = idx;
        break;
      }
    }
    // 相等则表示，只有做节点，只判断左边即可
    for (int idx = beginRightIndex + 1; idx <= end; idx++) {
      if (arr[idx] < head) {
        return false;
      }
    }

    boolean left = isBeforeEach(arr, begin + 1, beginRightIndex - 1);
    boolean right = isBeforeEach(arr, beginRightIndex, end);
    return left && right;
  }
}