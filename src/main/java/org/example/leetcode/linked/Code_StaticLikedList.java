package org.example.leetcode.linked;

public class Code_StaticLikedList {
  /**
   * array build list
   * 
   * @param args
   */

  public static void main(String[] args) {
    LinkedList list = LinkedList.instance(3);
    list.add(11);
    list.add(12);
    list.add(13);

    list.remove(12);
    list.add(14);
  }

}

class LinkedList {
  // 头节点存储空闲节点
  // 尾节点存储被使用的节点
  Node[] node;
  int count = 0;
  int capacity;

  public LinkedList(Node[] node, int capacity) {
    this.node = node;
    this.capacity = capacity;
  }

  public static LinkedList instance(int capacity) {
    // unuse node
    Node[] node = new Node[capacity];

    
    return new LinkedList(node, capacity);
  }

  public boolean add(int value) {

    return true;
  }

  public Node remove(int value) {

    return null;
  }

}

/**
 * InnerCode_StaticLikedList
 */
class Node {
  int next;
  int data;

  public Node(int next) {
    this.next = next;
  }

}
