package org.example.leetcode.linked.buildLinked;

import java.util.Stack;

/**
 * 给定一个链表，判断是否是回文
 * 时间复杂度 O(N) 空间复杂度O（1）
 * 
 * 取中点，反转队列，双端回溯
 */
public class Code4_Plaindrome_Number {

    public static void main(String[] args) {

        // 测试用例 1：奇数长度回文
        Node head1 = buildList(new int[] { 1, 2, 3, 2, 1 });
        System.out.println("链表 1: " + printList(head1));
        System.out.println("方法 1 - 栈：" + isPalindromeWithStack(head1));
        System.out.println("方法 2 - 最优解：" + checkPlaindromeNumber2(head1));
        System.out.println();

        // 测试用例 2：偶数长度回文
        Node head2 = buildList(new int[] { 1, 2, 2, 1 });
        System.out.println("链表 2: " + printList(head2));
        System.out.println("方法 1 - 栈：" + isPalindromeWithStack(head2));
        System.out.println("方法 2 - 最优解：" + checkPlaindromeNumber2(head2));
        System.out.println();

        // 测试用例 3：非回文
        Node head3 = buildList(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("链表 3: " + printList(head3));
        System.out.println("方法 1 - 栈：" + isPalindromeWithStack(head3));
        System.out.println("方法 2 - 最优解：" + checkPlaindromeNumber2(head3));
        System.out.println();

        // 测试用例 4：空链表
        Node head4 = null;
        System.out.println("链表 4 (空): " + printList(head4));
        System.out.println("方法 1 - 栈：" + isPalindromeWithStack(head4));
        System.out.println("方法 2 - 最优解：" + checkPlaindromeNumber2(head4));
        System.out.println();

        // 测试用例 5：单个节点
        Node head5 = buildList(new int[] { 9 });
        System.out.println("链表 5: " + printList(head5));
        System.out.println("方法 1 - 栈：" + isPalindromeWithStack(head5));
        System.out.println("方法 2 - 最优解：" + checkPlaindromeNumber2(head5)); // checkPlaindromeNumber(head);
        checkPlaindromeNumber2(head1);
    }

    private static boolean isPalindromeWithStack(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        Node current = head;
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop.value != current.value) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    private static boolean checkPlaindromeNumber2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;
        // double skip、 so next！= null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secoundHalf = reverseList2(slow);

        Node half = secoundHalf;
        Node first = head;
        boolean isPlaindrome = true;
        // end status
        while (half != null) {
            if (half.value != first.value) {
                isPlaindrome = false;
                break;
            }
            first = first.next;
            half = half.next;
        }
        // 还原
        reverseList2(secoundHalf);
        return isPlaindrome;
    }

    private static Node reverseList2(Node secoundHalf) {
        Node prev = null;
        Node current = secoundHalf;
        while (current != null) {
            Node next = current.next;
            // 下一个变成上一个
            current.next = prev;
            // 上一个变更current
            prev = current;
            // new current
            current = next;
        }
        // 最新的head；
        return prev;
    }

    /**
     * 构建链表
     */
    private static Node buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * 打印链表
     */
    private static String printList(Node head) {
        if (head == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }
}

class Node {
    int value;
    Node next;
    Node rand;

    public Node(int value) {
        this.value = value;
    }
}