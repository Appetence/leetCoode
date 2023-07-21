package org.example.leetcode.eor;

/**
 * 给定一个数组，某个元素出现 K 次 其他元素出现 M 次 求出现 K 次的数 限制 K < M
 */
public class Code3_EOR_FindRepetionElement {
  public static void main(String[] args) {
    int[] arr = { -1, 2, 3, 4, 2, 2, 4, 4, 3, 3 };
    // M = 3 K = 1
    int m = 3;
    int k = 1;
    int element = repetionElement(arr, m, k);
    System.out.println(element);
  }

  public static int repetionElement(int[] arr, int m, int k) {
    int[] countArr = new int[32];
    for (int item : arr) {
      String binaryString = Integer.toBinaryString(item);
      char[] chars = binaryString.toCharArray();
      for (int charArray = 0; charArray < chars.length; charArray++) {
        if (chars[charArray] == '1') {
          countArr[charArray] = countArr[charArray] + 1;
        }
      }
    }
    for (int idx = 0; idx < countArr.length; idx++) {
      int item = countArr[idx];
      int val = item % m;
      if (val == 0) {
        countArr[idx] = 0;
      } else {
        countArr[idx] = 1;
      }
    }
    // String bineryString = "";
    // for (int item : countArr) {
    // bineryString = item + bineryString ;
    // }
    // Integer.parseInt(bineryString, 2)
    int result = 0;
    for (int item = 0; item < countArr.length; item++) {
      if (countArr[item] % m != 0) {
        result |= (1<< item);
      }
    }

    return result;
  }

}
