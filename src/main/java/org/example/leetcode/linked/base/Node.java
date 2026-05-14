package org.example.leetcode.linked.base;

public class Node<T> {
    public T data;
    public Node<T> prev;
    public Node<T> next;
    public Node<T> parent;

    public Node(T data) {
        this.data = data;
    }
}
