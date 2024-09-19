package org.example.leetcode.linked.rebuild;

import org.example.leetcode.util.ArrayUtil;

/**
 * array build stack
 */
public class ArrayBuildQueueOrStack {
  public static void main(String[] args) {
    AarrayUtil stack = new AarrayUtil(3);
    // System.out.println(stack.push(10));
    // System.out.println(stack.push(12));
    // System.out.println(stack.push(30));
    // System.out.println(stack.push(40));

    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.pop());
    // System.out.println(stack.push(40));

    System.out.println(">>>>>>");
    System.out.println(stack.add(10));
    System.out.println(stack.add(12));
    System.out.println(stack.add(30));
    System.out.println(stack.add(40));

    System.out.println(stack.remove());
    System.out.println(stack.remove());
    System.out.println(stack.remove());
    System.out.println(stack.remove());
    System.out.println(stack.add(40));
    System.out.println(stack.remove());
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

  public AarrayUtil instance(int size) {
    return new AarrayUtil(size);
  }

  public boolean push(int value) {

    if (limit < size) {
      arr[limit++] = value;
      return true;
    } else {
      int offset = limit % size;

      if (arr.length < size) {
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