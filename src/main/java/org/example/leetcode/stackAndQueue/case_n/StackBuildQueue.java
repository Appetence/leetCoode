package org.example.leetcode.stackAndQueue.case_n;

public class StackBuildQueue {
  /**
   * 两个栈
   * 
   * @param args
   */
  public static void main(String[] args) {
    C_Queue q = new C_Queue();
    System.out.println(q.add(0));
    System.out.println(q.add(1));
    System.out.println(q.add(2));
    System.out.println(q.add(2));
    System.out.println(q.add(2));
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());

    System.out.println(q.add(2));
    System.out.println(q.remove());
  }

}

/**
 * Stack build
 * 
 */
class C_Queue {

  private AarrayUtil push = AarrayUtil.instance(3);
  private AarrayUtil pop = AarrayUtil.instance(3);

  public boolean add(int node) {
    boolean pushResult = push.push(node);
    pushToPop();
    return pushResult;

  }

  public Integer remove() {
    // 将oldStack all node move new stack
    // if (pop.isEmpty() && push.isEmpty()) {
    // throw new RuntimeException();
    // }
    pushToPop();
    return pop.pop();

  }

  /**
   * push -> pop
   */
  private void pushToPop() {
    if (pop.isEmpty()) {
      while (!push.isEmpty()) {
        pop.push(push.pop());
      }
    }
  }

}

class AarrayUtil {
  int[] arr;
  int size;

  int limit;
  int begin;

  public AarrayUtil(int size) {
    this.size = size;
    arr = new int[size];
  }

  public boolean isEmpty() {
    return begin == limit;
  }

  public static AarrayUtil instance(int size) {
    return new AarrayUtil(size);
  }

  public boolean push(int value) {

    if (limit < size) {
      arr[limit++] = value;
      return true;
    } else {
      int offset = limit - begin;

      if (offset < size && offset > 0) {
        arr[offset] = value;
        limit++;
        return true;
      } else {
        return false;
      }

    }
  }

  public Integer pop() {
    if (limit <= size && limit > 0) {
      int item = arr[--limit];
      return item;
    }
    return null;
  }

}