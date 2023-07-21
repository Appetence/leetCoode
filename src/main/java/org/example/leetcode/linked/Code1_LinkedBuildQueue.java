package org.example.leetcode.linked;

import java.util.Objects;

import org.example.leetcode.util.Node;

/**
 * 链表实现队列
 */
public class Code1_LinkedBuildQueue {

  public static void main(String[] args) {
    /**
     * 队列，先进先出
     */
    C_Queue foo = new C_Queue(new Node("9"));
    System.out.println(foo.push(new Node("8")));
    System.out.println(foo.push(new Node("7")));
    System.out.println(foo.push(new Node("6")));
    foo.each();
    System.out.println(foo.pop());
    foo.each();

  }

}

class C_Queue {

  private Node first;
  private Node tail;
  private int size;

  public C_Queue(Node node) {
    first = node;
    tail = node;
  }

  public void each() {
    if (Objects.isNull(first)) {
      return;
    } else {
      String result = first.data;
      Node node = this.first;
      while (node.next != null) {
        result = result + " ," + node.next.data;
        node = node.next;
      }
      System.out.println(result);
    }
  }

  /**
   * 新增节点
   * 
   * @param n
   * @return
   */
  public boolean push(Node n) {
    if (Objects.nonNull(n)) {
      if (Objects.nonNull(tail)) {
        this.tail.next = n;
        this.tail = n;
      } else {
        this.first = this.tail = n;
      }
    } else {
      return false;
    }

    return true;
  }

  /**
   * 
   * 取出头节点
   * 
   * @return
   */
  public Node pop() {
    if (Objects.nonNull(first)) {

      if (Objects.nonNull(first.next)) {
        first = first.next;
      } else {
        first = null;
        tail = null;
      }
      return first;
    } else {
      return null;
    }

  }
}
