package org.example.leetcode.common;

import java.util.Random;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-06-06 12:56
 */
public class Node<T> implements Comparable<Node<T>>{
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public static Node buildNode(Node next) {
        Random random = new Random();
        Node<Integer> result = new Node<>(random.nextInt(10), next);
        return result;
    }

    /**
     * 构建一个指定长度的链表
     *
     * @param i
     */
    public static Node buildNode(int i) {
        Node node = null;
        if (i > 0) {
            Node nextNode = buildNode(--i);
            node = buildNode(nextNode);
        }
        return node;
    }


    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrev() {
        return this.prev != null;
    }

    public void eachNode() {
        StringBuilder result = new StringBuilder();
        Node<T> node = this;
        // 有下一个
        while (node.hasNext()) {
            result.append(node.data).append(",");
            node = node.next;
        }
        // 最后一个
        result.append(node.data);
        System.out.println(result);
    }

    @Override
    public int compareTo(Node<T> o) {
        if(data instanceof Integer ){
            return (Integer) data - (Integer)o.data;
        }
        return 0;
    }
}
