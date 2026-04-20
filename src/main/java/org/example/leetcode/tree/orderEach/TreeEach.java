package org.example.leetcode.tree.orderEach;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.example.leetcode.linked.base.Node;

public class TreeEach {
    /**
     * 给定 tree
     * 宽度优先：queue 先进先出
     */
    public static void main(String[] args) {
        Node<Integer> node = TreeRecur.buildNode2();

        int max = w(node);
        System.out.println(max);
        int max2 = getMaxWithOptimized(node);

        System.out.println(max2);

    }

    private static int getMaxWithOptimized(Node<Integer> node) {
        if (node == null) {
            return 0;

        }
        Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.add(node);

        int max = 0;
        while (!queue.isEmpty()) {
            // 当前level 节点数量
            int size = queue.size();

            max = Math.max(max, size);

            // 当前level all sublevel
            for (int i = 0; i < size; i++) {
                Node<Integer> head = queue.poll();
                if (head.prev != null) {
                    queue.add(head.prev);
                }
                if (head.next != null) {
                    queue.add(head.next);
                }

            }
        }
        return max;

    }

    private static int w(Node<Integer> node) {
        if (node == null) {
            return 0;

        }

        Queue<Node<Integer>> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        Map<Node<Integer>, Integer> map = new HashMap();
        // 当前曾节点数
        int currentNodes = 0;
        // 层级
        int currentLevel = 1;

        queue.add(node);
        map.put(node, 1);
        while (!queue.isEmpty()) {
            Node<Integer> pop = queue.poll();
            Integer currentNodeLevel = map.get(pop);
            if (currentLevel == currentNodeLevel) {
                currentNodes++;
            } else {
                max = Math.max(currentNodes, max);
                currentLevel++;
                currentNodes = 1;
            }
            if (pop.prev != null) {
                queue.add(pop.prev);
                map.put(pop.prev, currentLevel + 1);
            }
            if (pop.next != null) {
                queue.add(pop.next);
                map.put(pop.next, currentLevel + 1);
            }

        }

        max = Math.max(max, currentNodes);
        return max;

    }

}
