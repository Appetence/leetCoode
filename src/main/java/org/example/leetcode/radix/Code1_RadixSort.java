package org.example.leetcode.radix;

import java.util.Arrays;

/**
 * radix sort
 * 
 * @description 基数排序
 * 1 统计每一位上，各元素出现的次数 ，
 * 2 根据各元素出现的次数，确定各元素在排序后的位置
 * 3 根据各元素在排序后的位置，确定各元素在排序后的位置
 * 4 循环
 * @date 2021-01-06 22:06
 */
public class Code1_RadixSort {

  public static void main(String[] args) {
    // 指定数组
    String[] arr = { "22", "123", "154", "101", "225", "6", "97", "18", "49", "101","0" };
    for (String item : radixSort(arr)) {
      System.out.println(item);
    }
  }

  /**
   * 
   * @param arr
   */
  private static String[] radixSort(String[] arr) {

    // 1 find max element length
    int maxLength = findMaxLength(arr);

    // leftAppend(arr, maxLength);
    // 2 count number rate
    return radixSort(arr, 1, maxLength);

    // 3 count size

    // 4 sort

  }

  private static String[] radixSort(String[] arr, int handleByte, int maxLength) {
    String[] result = arr;
    if (handleByte <= maxLength) {
      // 辅助表 1
      int[] rateRecord = new int[10];
      // count
      for (String item : arr) {
        int value = offsetValue(item, handleByte);
        rateRecord[value]++;
      }

      for (int idx = 1; idx < rateRecord.length; idx++) {
        rateRecord[idx] = rateRecord[idx] + rateRecord[idx - 1];
      }

      String[] arrHelp = new String[arr.length];
      // right -> left
      for (int idx = arr.length - 1; idx >= 0; idx--) {
        String item = arr[idx];
        int value = offsetValue(item, handleByte);
        int i = --rateRecord[value];
        arrHelp[i] = item;
      }

      result = radixSort(arrHelp, handleByte + 1, maxLength);
    }
    return result;

  }

  private static int offsetValue(String item, int handleByte) {
    int length = item.length();
    if (length < handleByte) {
      return 0;
    }
    int end = length - handleByte;
    return Integer.valueOf(item.substring(end, end + 1));
  }

  /**
   * max length
   * 
   * @param arr
   * @return
   */
  private static int findMaxLength(String[] arr) {

    return Arrays.stream(arr)
        .map(item -> item.length())
        .max((o1, o2) -> o1.compareTo(o2))
        .orElse(0);
  }

}
