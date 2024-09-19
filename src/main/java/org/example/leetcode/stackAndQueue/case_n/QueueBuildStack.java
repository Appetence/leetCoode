package org.example.leetcode.stackAndQueue.case_n;

/**
 * 队列 构建栈
 */
public class QueueBuildStack {

  public static void main(String[] args) {
    Stack stack = Stack.instance();
    System.out.println(stack.push(0));
    System.out.println(stack.push(1));
    System.out.println(stack.push(2));
    System.out.println(stack.push(3));

    System.out.println(">>>>");
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.push(3));
    System.out.println(stack.pop());

  }

}

class Stack {
  public static Stack instance() {
    return new Stack();
  }

  ArrayUtil push = ArrayUtil.instance(3);
  ArrayUtil pop = ArrayUtil.instance(3);

  public boolean push(int node) {
    boolean pushResult = push.add(node);
    // todo
    // pushToPop();
    return pushResult;
  }

  public Integer pop() {
    // todo
    pushToPop();
    return pop.remove();
  }

  private void pushToPop() {
    if (pop.isEmpty()) {
      while (!push.isEmpty()) {
        pop.add(push.remove());
      }
    }
  }

}

class ArrayUtil {
  int[] arr;
  int size;

  int limit;
  int begin;

  public ArrayUtil(int size) {
    this.size = size;
    arr = new int[size];
  }

  public boolean isEmpty() {
    return limit == begin;
  }

  public static ArrayUtil instance(int size) {
    return new ArrayUtil(size);
  }

  public boolean add(int item) {
    int offset = limit - begin;
    if (offset < size) {
      arr[offset] = item;
      limit++;
      return true;
    }
    return false;
  }

  public Integer remove() {
    int offset = limit - begin - 1;
    if (offset < size && offset >= 0) {
      int item = arr[begin % size];
      begin++;
      return item;
    }
    return null;

  }
}
