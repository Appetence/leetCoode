package org.example.leetcode.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/** 基于队列构建栈 */
public class Code1_QueueBuildStack {
  public static void main(String[] args) {
    /**
     * 目标：栈 先进 后出
     * 
     * 前提队列 先进 先出
     */
    C_Stack cStack = new C_Stack();
    System.out.println(cStack.push(0));
    System.out.println(cStack.push(1));
    System.out.println(cStack.push(2));
    System.out.println(">>>>");
    System.out.println(cStack.pop());
    System.out.println(cStack.pop());
    System.out.println(cStack.pop());
    System.out.println(cStack.pop());
  }
}
/**
 * custom stack
 */
class C_Stack {
  /**
   * last add first pop
   */

  private Queue<Integer> data = new LinkedList<>();
  private Queue<Integer> help = new LinkedList<>();

  public boolean push(int node) {
    return data.offer(node);
  }

  public Integer pop() {
    boolean result = preHandData();
    Integer poll = null;
    if (result) {
      poll = data.poll();
      afterHandleData();
    }
    return poll;
  }

  private void afterHandleData() {
    Queue<Integer> ans = help;
    help = data;
    data = ans;
  }

  private boolean preHandData() {
    if (help.isEmpty() && data.size() > 0) {
      while (data.size() > 1) {
        help.offer(data.poll());
      }
      return true;
    } else {
      return false;
    }
  }
}
