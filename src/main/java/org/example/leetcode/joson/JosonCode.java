package org.example.leetcode.joson;

import java.util.Arrays;
import java.util.LinkedList;

public class JosonCode {
  // static int array[] = new int[] { 1, 2, 3, 4, 5 };
  static int array[] = new int[] { 0, 1, 2, 3, 4 };
  static LinkedList<Integer> list = new LinkedList<>();
  static {
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }
  }

  /**
   * 约瑟夫问题
   * 
   * @param args
   */
  public static void main(String[] args) {
    /**
     * 1 2 3 4 5
     * 1 2 4 5 index = 1 mov 3 next 4 4 5 1 2
     * 2 4 5 index = 4 mov 1 next 2 2 4 5
     * 2 4 index = 2 mov 5 next 2 2 4 2
     * 4 index = 2 move 2 next 4 4
     */
    int n = 5;
    int m = 2;
    int joson = joson(n, m);
    System.out.println("joson is " + joson);
    int result = Arrays.stream(array).filter(item -> item != -1).findFirst().getAsInt();
    System.out.println(result);
  }

  private static int joson(int n, int m) {
    // start 从1 开始
    int start = 0;
    return joson(n, m, start);
  }

  private static int joson(int n, int m, int start) {
    System.out.println("开始位置 " + start);
    if (n == 1) {
      // just only node
      return start;
    }
    // + 1 向后推一位 表示下次开始位置
    return joson(n - 1, m, (start + m) % n + 1);
  }
}
