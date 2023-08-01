package org.example.leetcode.track;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 数字 字符串，获取所有可能的IP
 */
public class Code1_TrackIp {
  public static List<String> ipList = new ArrayList<>();

  public static void main(String[] args) {
    String str = "12456789";

    trackIp(str, "", 0);
    System.out.println(ipList);
  }

  /**
   * 获取IP
   * 
   * @param str 字符串
   * @param cur
   * @param num
   * @return
   */
  private static void trackIp(String str, String cur, int num) {
    // 3 * (4 - num ) 限制每次循环的数据大小
    if (str == null || str.length() > 3 * (4 - num)) {
      return;
    }
    if (num == 4) {
      // 结束条件 num = 4 表示
      int lastIndexOf = cur.lastIndexOf('.');
      ipList.add(cur.substring(0, lastIndexOf));
      return;
    }
    for (int i = 1; i < 4 && i <= str.length(); i++) {
      String item = str.substring(0, i);
      if (item.length() > 1 && item.charAt(0) == '0') {
        break;
      }
      int value = Integer.parseInt(item);
      if (value > 255) {
        break;
      }
      trackIp(str.substring(i), cur+ item + ".", num + 1);

    }
  }

}
