package org.example.leetcode.linked;

import java.util.Objects;
import java.util.Stack;

import org.example.leetcode.util.Node;

/**
 * 链表实现栈
 */
public class Code2_LinkedBuildStack {

  public static void main(String[] args) {

    /**
     * 栈 先进 后出
     */
    L_Stack foo = new L_Stack(new Node("9"));
    System.out.println(foo.push(new Node("8")));
    System.out.println(foo.push(new Node("7")));
    foo.each();
    Node pop = foo.pop();
    System.out.println("pop content :" + (Objects.nonNull(pop) ? pop.getData() : null));
    foo.each();
    System.out.println(foo.push(new Node("6")));

    foo.each();
  }

}

class L_Stack {
  /**
   * 栈顶
   */
  private Node head;

  public L_Stack(Node head) {
    this.head = head;
  }

  public boolean push(Node n) {
    if (Objects.nonNull(n)) {
      if (head == null) {
        head = n;
      } else {
        n.next = head;
        head = n;
      }
      return true;
    } else {
      return false;
    }
  }

  public Node pop() {
    if (head == null) {
      return null;
    } else {
      Node oldHead = head;
      if (head.next == null) {
        head = null;
      } else {
        head = oldHead.next;
      }
      return oldHead;
    }

  }

  public void each() {
    if (Objects.isNull(head)) {
      return;
    } else {
      String result = head.data;
      Node node = this.head;
      while (node.next != null) {
        result = result + " ," + node.next.data;
        node = node.next;
      }
      System.out.println(result);
    }
  }
}
