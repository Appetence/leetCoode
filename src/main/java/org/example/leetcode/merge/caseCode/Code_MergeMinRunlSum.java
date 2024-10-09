package org.example.leetcode.merge.caseCode;

import java.util.LinkedList;

/**
 * 约瑟夫问题
 * 递归模式：
 * 从最后一次执行结果反推第一次执行结果
 * 
 * 循环链表模式（可以用linkedList 也可以自定义list）
 * 
 * 数组模式
 * 
 * 动态规划（状态转移）
 * 
 * 数学公式法（）
 */
public class Code_MergeMinRunlSum {
  public static void main(String[] args) {
    int n = 9;
    int m = 2;
    int result = findSurvivor(n, m);
    System.out.println(result);
    int lastPerson = josephus(n, m);
    System.out.println("最后出列的人的编号: " + lastPerson);
    System.out.println("动态规划求解结果" + dynomicProgrems(n, m));
    System.out.println("数学公式计算 " + mathematicalFormula(n, m));
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
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    int index = 0; // 当前指针位置

    // 模拟出列过程
    while (list.size() > 1) {
      // 计算下一个人要被淘汰的逻辑是：(当前索引 + 步长m - 1) 对链表总长度取余数，这样可以循环回到链表的开始
      // 当前index 已经被淘汰了，所以计算下一个人时候需要额外-1
      index = (index + k - 1) % list.size();
      // System.out.println("index = " + index + " node = " + list.get(index) + " size
      // " + list.size());
      list.remove(index);
    }

    /**
     * index = 2 size 4
     * index = 1 size 3
     * index = 1 size 2
     * 1
     * start = 0 n = 4
     * start = 3 n = 3
     * start = 3 n = 2
     */
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
  public static int josephus(int n, int m) {
    if (n == 1) {
      // 最后一个人
      return 1;
    } else {
      // 前 n-1 个人中最后剩下的编号
      int start = josephus(n - 1, m);
      // 下次执行剩下的编号
      return (start + m - 1) % n + 1;
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

  public static int dynomicProgrems(int n, int m) {
    int[] f = new int[n + 1];
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      // 第1次的执行结果 = 第 i-1 次执行后剩下的编号 向后推 （ m - 1） 计算出本次要删除的节点，最后向后推一个就是存活节点
      f[i] = (f[i - 1] + m - 1) % i + 1;
    }
    return f[n];
  }

  /**
   * [
   * 当 n = 1 时，只有一个人，这个人就是最后剩下的编号，所以 J(1, m) = 1。
   * 递推公式：
   * 
   * 对于 n > 1 的情况，假设 J(n - 1, m) 已知，那么 J(n, m) 可以通过以下公式计算：
   *  [ J(n, m) = ((J(n - 1, m) + m - 1) \mod n) + 1 ]
   * 
   * ]
   * 
   * 
   * 基于上述分析，对于任意给定的 (n) 和 (m)，最后的幸存者的原始编号 (J(n, m)) 可以用以下公式表达：
   * 
   * [ J(n, m) = ((J(n - 1, m) + m - 1) \mod n) + 1 ]
   * 
   * 然而，上述递推公式在实际应用中难以直接计算，因为每次计算都需要知道 (J(n-1,
   * m))，这本质上还是回到了递归或迭代的计算方式。因此，更实用的数学解法是基于对历史解法的总结和数学归纳，直接给出了一个简化的计算公式：
   * 
   * [ J(n, m) = ((m - 1) \times (1 + \sum_{k=2}^{n}\frac{1}{k})) \mod n + 1 ]
   * 
   * 但这个公式并不常见，且计算复杂度较高。
   * 
   * 更实用且易于理解的直接解法是通过数学家约瑟夫·弗洛里克发现的公式：
   * 
   * [ J(n, m) = (m - 1) \times (1 + \sum_{i=1}^{n-1}J^{-1}(i, m) \mod n) \mod n +
   * 1 ]
   * 
   * 尽管这个公式看起来复杂，但其实质是利用了对数列的分析和模运算的特性来直接找到解。
   * 
   * 
   * f (n , m ) 
   * 
   * 0            1      k - 1     k + 1          n - 1            n - 2             上一次的序列
   * k + 1        k+ 2     0         1            n - 1 = n - k -2    n - k -3        新序列
   * 
   *  新序列 h (n - 1 , m ) 
   * 
   *  新序列映射为 0 - n -1 的约瑟夫环 f(n - 1, m) 
   * 
   *  
   * 
   * 实现解析
   */
  public static int mathematicalFormula(int n, int m) {

    int x = 0;
    for (int i = 2; i <= n; i++) {
      // 每次被删除的节点
      x = (x + m) % i;
      System.out.println("被移除节点为：" + x);
    }
    // 往后推一个
    return x + 1;
  }

}
