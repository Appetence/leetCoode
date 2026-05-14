package org.example.leetcode.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Code_DST {

    /**
     * 深度优先遍历
     * 利用stack
     * 从source node点开始，依次把节点按deep 放入 stack
     * 每poll一个点，把该节点下一个没有 push 进 stack 的邻节点放入 stack
     * 直到stack变空
     */
    public static void main(String[] args) {
        dfs(Base_Graph.testCyclicGraph());
        dfs(Base_Graph.testCyclicGraph());
    }

    private static void dfs(Node node) {

        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        Set<Node> set = new HashSet<>();

        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            List<Node> nexts = pop.nexts;
            for (Node n : nexts) {
                if (!set.contains(n)) {

                    stack.push(n);
                    set.add(n);
                    stack.push(pop);
                    System.out.println(n.value);
                    break;
                }

            }
        }
    }
}
