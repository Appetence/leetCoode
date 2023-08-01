
package org.example.leetcode.stackAndQueue;

import java.util.Stack;

/**
 * 基于栈构建 队列
 * 
 * 
 */
public class Code2_StackBuildQueue {
  public static void main(String[] args) {
    /**
     * 预期：队列 先进先出
     * 前提：栈 先进后出
     */
    C_Queue queue = new C_Queue();
    queue.add(1);
    queue.add(10);
    System.out.println(">>>");
    System.out.println(queue.poll());
    queue.add(20);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }
}

class C_Queue {
  // 入栈队列
  private Stack<Integer> stackPush = new Stack<>();
  // 出栈队列
  private Stack<Integer> stackPop = new Stack<>();

  public void add(int node) {
    stackPush.push(node);
    pushToPop();
  }

  private void pushToPop() {
    if (stackPop.isEmpty()) {
      while (!stackPush.isEmpty()) {
        stackPop.add(stackPush.pop());
      }
    }
  }

  public Integer poll() {
    pushToPop();
    if (stackPop.isEmpty()) {
      return null;
    }
    return stackPop.pop();
  }
}
