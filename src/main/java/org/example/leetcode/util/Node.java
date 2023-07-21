package org.example.leetcode.util;

public class Node {

  public String data;
  public Node pred;
  public Node next;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Node getPred() {
    return pred;
  }

  public void setPred(Node pred) {
    this.pred = pred;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node(String data) {
    this.data = data;
  }

}
