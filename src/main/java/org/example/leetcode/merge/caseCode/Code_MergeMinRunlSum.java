package org.example.leetcode.merge.caseCode;

import java.util.LinkedList;

public class Code_MergeMinRunlSum {
  public static void main(String[] args) {
    int n = 3;
    int m = 2;
    int result = findSurvivor(n, m);
    System.out.println(result);
    int lastPerson = josephus(n, m);
    System.out.println("最后出列的人的编号: " + lastPerson);
  }

  /**
   * 使用 LinkedList 模拟约瑟夫问题
   * 
   * @param n 总人数
   * @param k 报数间隔
   * @return 最后出列的人的编号
   */
  public static int findSurvivor(int n, int k) {
    LinkedList<Integer> list = new LinkedList<>();

    // 初始化列表
    for (int i = 0; i < n; i++) {
      list.add(i);
    }

    int index = 0; // 当前指针位置

    // 模拟出列过程
    while (list.size() > 1) {
      // 计算报数后的位置
      index = (index + k - 1) % list.size() ;
      list.remove(index);
    }

    return list.getFirst();
  }

  /**
   * 递归方法解决约瑟夫问题
   * 
   * @param n     当前圈内人数
   * @param m     报数间隔（从1开始计数）
   * @param start 从start编号的人开始报数
   * @return 最后留下的人的编号
   */
  public static int josephus(int n, int m, int start) {
    if (n == 1) {
      return start;
    } else {
      // 计算下一个被排除的人的序号，注意递归调用中m应减1，因为报数是从1开始的
      return josephus(n - 1, m, (start + m - 1) % n + 1);
    }
    /**
     * n = 1 only one node
     * 
     * n > 1 next_start = (start + m - 1) % n + 1
     * start + m 向前推 m step
     * start + m - 1 nextNodeIdx 索引从0开始
     * (start + m - 1) % n 限制下范围
     * (start + m - 1) % n + 1 转换成1开始的索引 (当前元素)
     */
  }

  // 重载方法，提供默认的start参数
  public static int josephus(int n, int m) {
    return josephus(n, m, 1);
  }
}
