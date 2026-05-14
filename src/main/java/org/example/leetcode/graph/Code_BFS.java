package org.example.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 宽度优先遍历
 * 从根节点开始，依次按照宽度进队列然后弹出
 * 每弹出一个节点，把该节点所有没进过队列的相邻节点放入队列
 * 直到队列变空
 */
public class Code_BFS {
    public static void main(String[] args) {
        bfs(Base_Graph.testSimpleGraph());
        bfs(Base_Graph.testCyclicGraph());

    }

    /**
     * 遍历图
     * 
     * @param node
     */
    private static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Set<Node> set = new HashSet<>();
        Queue<Node> stack = new LinkedList();

        set.add(node);
        stack.add(node);
        while (!stack.isEmpty()) {
            Node element = stack.poll();
            System.out.println(element.value);
            for (Node n : element.nexts) {
                if (!set.contains(n)) {
                    set.add(n);
                    stack.offer(n);
                }
            }
        }
    }

}
