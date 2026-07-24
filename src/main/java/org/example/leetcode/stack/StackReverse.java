package org.example.leetcode.stack;

import java.util.Stack;

public class StackReverse {

    public static void main(String[] args) {
        // 给定一个stack 倒序
        Stack stack = buildStack();
        reverse(stack, 0);
        each(stack);
    }

    private static void each(Stack stack) {
        System.out.println(">>>>>");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(">>>>>");
    }

    private static Stack buildStack() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        Stack<Integer> stack = new Stack();
        for (int item : arr) {
            stack.push(item);
        }
        return stack;
    }

    private static void reverse(Stack stack, int i) {
        if (stack.isEmpty()) {
            return;
        }

        int cur = f(stack);

        reverse(stack, i);
        stack.push(cur);
    }

    /**
     * stack botton
     * 
     * @param stack
     * @return
     */
    private static int f(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        }
        Integer result = f(stack);
        stack.push(pop);
        return result;
    }
}
