package org.example.leetcode.track;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的字符串获取所有可能的全排列
 */
public class Code2_BackTrackAllOrder {
  public static List<String> ipList = new ArrayList<>();

  public static void main(String[] args) {
    String str = "1234";
    trackAllOrder(str, "", str.length());

    System.out.println(ipList);
  }

  private static void trackAllOrder(String str, String cur, int length) {

    if (str == null) {
      return;
    }
    // 新字符串长度等于老字符串长度时候加入结果队列中
    if (length == cur.length()) {
      ipList.add(cur);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      String substring = str.substring(i, i + 1);
      trackAllOrder(str.replace(substring, ""), cur + substring, length);
    }
  }

}
