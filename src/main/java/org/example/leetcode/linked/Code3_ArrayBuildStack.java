package org.example.leetcode.linked;

import org.example.leetcode.util.Node;

/**
 * 数组实现栈
 */
public class Code3_ArrayBuildStack {

  public static void main(String[] args) {
    ArrayStack stack = new ArrayStack(5);
    System.out.println(stack.push(1));
    System.out.println(stack.push(2));
    System.out.println(stack.push(3));
    System.out.println(stack.push(4));
    System.out.println(stack.push(5));
    System.out.println(stack.push(5));
    System.out.println(stack.pop());

    System.out.println(stack.push(6));
    System.out.println(stack.pop());
    System.out.println(stack.push(7));

  }

}

class ArrayStack {

  private int size;

  private int[] arr;

  /*
   * 尾部节点
   */
  private int tailIndex = 0;
  /*
   * 头部节点
   */
  private int headIndex = 0;

  public ArrayStack(int size) {
    this.size = size;
    arr = new int[size];
  }

  public boolean push(int value) {
    int idx = tailIndex % size;
    if (idx < size && tailIndex - headIndex < size) {
      arr[idx] = value;
      tailIndex++;
      return true;
    } else {
      return false;
    }
  }

  public int pop() {
    int idx = (tailIndex - 1) % size;
    if (idx < size && tailIndex - headIndex < size) {
      headIndex++;
      int val = arr[idx];
      arr[idx] = -1;
      return val;
    } else {
      return -1;
    }
  }

  public void each() {
    int max = tailIndex % size;

  }
}
