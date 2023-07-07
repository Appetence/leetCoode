package org.example.leetcode;

import org.example.leetcode.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description: 合并k个升序列表
 * @author: liuhao
 * @date: 2023-06-06 12:43
 */
public class MergeListNode {
    /**
     * 给定k个升序列表，进行合并
     */
    public static void main(String[] args) {
        List<Node<Integer>> list = new LinkedList<>();
        list.add(Node.buildNode(3));
        list.add(Node.buildNode(3));
        list.stream().forEach(item -> item.eachNode());
        //二叉树节点有序排列
        nodeSort(list);
        Node<Integer> result = mergeAndSort(list);
        result.eachNode();


    }

    private static void nodeSort(List<Node<Integer>> list) {
        for (Node<Integer> node : list) {
            if (!node.hasNext()) {
                continue;
            }
            //
            Node first = node;
            Node current = first.next;
            while (current.hasNext()){
                // 插入排序



            }

        }
    }

    private static Node<Integer> mergeAndSort(List<Node<Integer>> list) {
        // 定义一个有序队列
        PriorityQueue<Node<Integer>> heap = new PriorityQueue<>();
        for (Node<Integer> subNode : list) {
            heap.add(subNode);
        }
        if (heap.isEmpty()) {
            return null;
        }
        // 取头节点
        Node<Integer> head = heap.poll();
        //
        Node<Integer> pre = head;
        // 依次遍历头节点的各子节点
        if (pre.hasNext()) {
            heap.add(pre.next);
        }
        // 循环条件
        while (!heap.isEmpty()) {
            Node<Integer> cur = heap.poll();
            // 挂到链表上
            pre.next = cur;
            pre = cur;
            if (cur.hasNext()) {
                heap.add(cur.next);
                cur.next = null;
            }
        }
        return head;

    }

}
