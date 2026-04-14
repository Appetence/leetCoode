package org.example.leetcode.linked;

import org.example.leetcode.linked.base.Node;

/**
 * two no loop linked
 * 
 * find intersection node;
 */
public class FindIntersectionNodeByNoLoop {
    public static void main(String[] args) {
        // 创建交点节点
        Node<Integer> intersect = new Node<>(4);
        intersect.next = new Node<>(5);

        // 链表1: 1 -> 2 -> 3 -> 4 -> 5
        Node<Integer> head1 = new Node<>(1);
        head1.next = new Node<>(2);
        head1.next.next = new Node<>(3);
        head1.next.next.next = intersect;  // 连接到交点

        // 链表2: 6 -> 4 -> 5
        Node<Integer> head2 = new Node<>(6);
        head2.next = intersect;  // 连接到交点

        Node<Integer> result = findIntersectionNode(head1, head2);
        if (result != null) {
            System.out.println("交点值: " + result.data);  // 应输出 4
        } else {
            System.out.println("无交点");
        }

        // 测试无交点情况
        Node<Integer> noIntersect1 = new Node<>(1);
        noIntersect1.next = new Node<>(2);

        Node<Integer> noIntersect2 = new Node<>(3);
        noIntersect2.next = new Node<>(4);

        Node<Integer> noResult = findIntersectionNode(noIntersect1, noIntersect2);
        if (noResult != null) {
            System.out.println("交点值: " + noResult.data);
        } else {
            System.out.println("无交点");  // 应输出此
        }
    }

    private static Node findIntersectionNode(Node<Integer> node, Node<Integer> node2) {
        if (node == null || node2 == null) {
            return null;
        }
        int len1 = 0;
        Node<Integer> cur1 = node;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }

        int len2 = 0;
        Node<Integer> cur2 = node2;
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }

        // 对齐：让长的链表先走差值步
        cur1 = node;
        cur2 = node2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                cur1 = cur1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                cur2 = cur2.next;
            }
        }

        // 同时遍历，找第一个相同节点
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {  // 引用相等
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;  // 无交点
    }

}
