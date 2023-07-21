package org.example.leetcode.binery;

/**
 * @program: Leetcode
 * @description: 二分法查询某个数是否存在
 * @author: liuhao
 * @date: 2023-07-18 09:38
 */
public class Code1_BinerySerach {
  public static void main(String[] args) {

    int[] arr = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
    int ans = 1;
    boolean result = exitSearch(arr, ans);
    System.out.println("===>" + result);

  }

  public static boolean exitSearch(int[] arr, int ans) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);

      // 大于
      if (arr[mid] > ans) {
        right = mid - 1;
      } else if (arr[mid] < ans) {
        // 小于
        left = mid + 1;
      } else {
        // arr[mid] = ans
        return true;
      }
    }
    return arr[left] == ans;
  }
}
