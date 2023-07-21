package org.example.leetcode.linked;

/**
 * 数组实现队列
 */
public class Code4_ArrayBuildQueue {
  public static void main(String[] args) {
    A_List stack = new A_List(5);
    System.out.println(stack.add(1));
    System.out.println(stack.add(2));
    System.out.println(stack.add(3));
    System.out.println(stack.add(4));
    System.out.println(stack.add(5));
    System.out.println(stack.poll());

    System.out.println(stack.add(6));
    System.out.println(stack.poll());
    System.out.println(stack.add(7));

  }
}

class A_List {

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

  public A_List(int size) {
    this.size = size;
    arr = new int[size];
  }

  public boolean add(int value) {
    int idx = tailIndex % size;
    if (idx < size && tailIndex - headIndex < size) {
      arr[idx] = value;
      tailIndex++;
      return true;
    } else {
      return false;
    }
  }

  public int poll() {
    int idx = (tailIndex - 1) % size;
    if (idx < size) {
      int val = arr[headIndex];
      arr[idx] = -1;
      headIndex++;
      return val;
    } else {
      return -1;
    }
  }

  public void each() {
    int max = tailIndex % size;

  }
}
