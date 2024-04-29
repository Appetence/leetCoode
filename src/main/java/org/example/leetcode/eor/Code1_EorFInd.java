package org.example.leetcode.eor;

/**
 * 给定一个数组，其他元素 出现偶数次，有一个元素出现奇数次 寻找出现奇数次的元素
 */
public class Code1_EorFInd {
  public static void main(String[] args) {
    int a = 444;
    int b = 333;
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println(a);
    System.out.println(b);

  }

}
