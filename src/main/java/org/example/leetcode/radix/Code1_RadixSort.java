package org.example.leetcode.radix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * radix sort
 * 
 * @description 基数排序
 * 
 * @date 2021-01-06 22:06
 */
public class Code1_RadixSort {

  public static void main(String[] args) {
    // 指定数组
    String[] arr = { "22", "123", "154", "101", "225", "6", "97", "18", "49", "101" };
    radixSort(arr);
  }

  /**
   * 
   * @param arr
   */
  private static void radixSort(String[] arr) {

    // 1 find max element length
    int maxLength = findMaxLength(arr);

    // 2 count number rate
    radixSort(arr, 1, maxLength);

    // 3 count size

    // 4 sort

  }

  private static void radixSort(String[] arr, int handleByte, int maxLength) {

    int[] rateRecord = new int[10];

    for (String item : arr) {
      int value = Integer.valueOf(item.substring(handleByte - 1, handleByte));
      rateRecord[value]++;
    }
    int[] rateCount = new int[10];
    for (int idx = 0; idx < rateRecord.length; idx++) {
      if (idx == 0) {
        rateCount[idx] = rateRecord[idx];
      } else {
        // count
        rateCount[idx] = rateRecord[idx] + rateCount[idx - 1];
      }
    }
    for (String item : arr) {
       int value = Integer.valueOf(item.substring(handleByte - 1, handleByte)); 
       
    }

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
