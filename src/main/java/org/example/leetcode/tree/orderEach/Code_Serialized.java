package org.example.leetcode.tree.orderEach;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.leetcode.linked.base.Node;

/**
 * 序列化 反序列化 一个二叉树
 */
public class Code_Serialized {

    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();
        String result = serialized(node);
        System.out.println(result);
        Node resultNode = unSerialized(result);
        System.out.println(resultNode);
    }

    private static Node unSerialized(String result) {
        String[] arr = result.split("_");
        Queue<String> list = new LinkedList<String>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return reconPreOrder(list);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String poll = queue.poll();
        if ("#".equals(poll)) {
            return null;
        }
        Node left = reconPreOrder(queue);
        Node right = reconPreOrder(queue);

        Node node = new Node(Integer.parseInt(poll));

        node.prev = left;
        node.next = right;
        return node;

    }

    private static String serialized(Node<Integer> node) {
        if (node == null) {
            return "#";
        }
        String result = String.valueOf(node.data);
        result = result + "_" + serialized(node.prev);
        result = result + "_" + serialized(node.next);
        return result;
    }
}
