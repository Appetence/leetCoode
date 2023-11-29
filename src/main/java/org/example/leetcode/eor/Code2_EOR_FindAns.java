package org.example.leetcode.eor;

/**
 * 给定一个数组 指定两个元素出现奇次，其他元素均出现偶数次
 */
public class Code2_EOR_FindAns {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 4, 555, 4, 1, 2, 555, 111, 3 };
    findAns(arr);
  }

  public static void main1(String[] args) {
    int i = 9;
    // 源码：1001
    System.out.println(Integer.toBinaryString(i));
    // 补码：11111111111111111111111111110111
    System.out.println(Integer.toBinaryString(-i));
    // 反码：11111111111111111111111111110110
    System.out.println(Integer.toBinaryString((~i)));
  }

  public static void findAns(int[] arr) {
    // eor result
    int ans = 0;
    // eor last 1
    int onlyOne = 0;
    for (int item : arr) {
      ans = ans ^ item;
    }
    // 获取某个元素专属 -ans = (~ans + 1 ) ; ans & -(ans) = 用于获取最右侧为1的那个数据
    int lastOne = ans & (-ans);
    for (int item : arr) {
      // 获取特殊元素
      if ((item & lastOne) != 0) {
        onlyOne = onlyOne ^ item;
      }
    }
    System.out.println(onlyOne + " ");
    System.out.println(ans ^ onlyOne);

  }

}
