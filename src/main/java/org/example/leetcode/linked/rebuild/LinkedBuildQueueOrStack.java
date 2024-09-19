package org.example.leetcode.linked.rebuild;



public class LinkedBuildQueueOrStack {
  /**
   * 链表 构建队列，栈
   * 
   * @param args
   */
  public static void main(String[] args) {
    C_LinkedStack stack = c_stack();


    stack.push(0);
    stack.push(1);
    stack.push(2);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

    C_Linked queue = c_queue();
    /**
     * 队列，先进先出
     */
    queue.add(0);
    queue.add(1);
    queue.add(2);

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());

    // c_stack();
  }

  private static C_LinkedStack c_stack() {

    return C_LinkedStack.instance();
  }

  private static C_Linked c_queue() {
    return C_Linked.instance();
  }

  /**
   * C_Linked
   */
  public static class C_Linked {

    Node head;
    Node end;
    int size;

    public static C_Linked instance() {
      return new C_Linked();
    };

    public boolean add(int value) {
      if (head == null) {
        head = new Node(value);
        end = head;
      } else {
        end.next = new Node(value);
        end.next.prev = end;
        end = end.next;
      }
      return true;
    }

    public Node pop() {
      if (head == null) {
        return null;
      } else {
        Node item = head;

        Node next = item.next;
        if (next == null) {
          head = null;
          end = null;

        } else {
          head = next;
          next.prev = null;
        }

        return item;
      }
    }

  }

  /**
   * C_Linked
   */
  public static class C_LinkedStack {

    Node head;
    Node end;

    public static C_LinkedStack instance() {
      return new C_LinkedStack();
    };

    public boolean push(int value) {
      if (head == null) {
        head = new Node(value);
        end = head;
      } else {
        Node item = new Node(value);
        head.prev = item;
        item.next = head;
        head = item;
      }
      return true;
    }

    public Node pop() {
      if (head == null) {
        return null;
      } else {
        Node item = head;
        Node next = item.next;
        if (next == null) {
          head = null;
          end = null;

        } else {
          head = next;
          next.prev = null;
          item.next = null;
        }

        return item;
      }
    }

  }

  /**
   * Node
   * 
   */
  public static class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return String.valueOf(data);
    }
  }
}
