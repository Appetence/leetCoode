package org.example.leetcode.sort;

public class mergeSort {
  public static void main(String[] args) {
    int[] arr = { -1, 9, 5, 3, 7, 6, 2, 8, 1 };
    int length = arr.length;
    System.out.println("begin");
    sort(arr, 0, length - 1);
    each(arr);
    System.out.println("end");

  }

  public static void each(int[] arr) {
    for (int item : arr) {
      System.out.println(item);
    }
  }

  private static void sort(int[] arr, int i, int j) {
    if (i >= j) {
      return;
    }
    int mid = i + (j - i) / 2;
    sort(arr, i, mid);
    sort(arr, mid + 1, j);
    operation(arr, i, mid, j);
  }

  private static void operation(int[] arr, int left, int mid, int right) {
    if (left >= right) {
      return;
    }
    int[] ans = new int[right - left + 1];
    int idx = 0;
    int idx1 = left;
    int idx2 = mid + 1;
    while (idx1 <= mid && idx2 <= right) {
      if (arr[idx1] > arr[idx2]) {
        ans[idx++] = arr[idx1++];
      } else {
        ans[idx++] = arr[idx2++];
      }
    }
    while (idx1 <= mid) {
      ans[idx++] = arr[idx1++];
    }
    while (idx2 <= right) {
      ans[idx++] = arr[idx2++];
    }
    for (int item : ans) {
      arr[left++] = item;
    }
  }
}
