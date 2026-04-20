package org.example.leetcode.linked.loop;

import org.example.leetcode.common.Node;

/**
 * 两个有环链表，获取第一个相交节点
 */
public class Code1_LoopLinked {

    public static void main(String[] args) {
        getIntersectionNode(new Node<>(), new Node<>());
    }

    private static Node getIntersectionNode(Node node, Node node2) {
        // 获取 loop
        Node first = getLoopNode(node);
        Node second = getLoopNode(node2);
        // 是否存在loop
        if (first != null && second != null) {
            return bothNode(node, first, node2, second);
        } else {
            return noLoop(node, node2);
        }
        // no loop
    }

    private static Node bothNode(Node node, Node loop, Node node2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 同一 入环节点
        if (loop == loop2) {
            int len = 0;
            cur1 = node;
            while (cur1.next != loop) {
                len++;
                cur1 = cur1.next;

            }
            cur2 = node2;
            while (cur2.next != loop2) {
                len--;
                cur2 = cur2.next;

            }
            cur1 = len > 0 ? node : node2;
            cur2 = cur1 == node ? node2 : node;

            len = Math.abs(len);
            while (len > 0) {
                cur1 = cur1.next;
                len--;

            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;

            }
            return cur1;
        } else {
            // 入 loop node is not equals
            cur1 = loop.next;
            while (cur1 != loop) {
                if (cur1 == loop2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;

        }

    }

    private static Node noLoop(Node node, Node node2) {
        int len = 0;

        Node cur1 = node;
        while (cur1.next != null) {
            len++;
            cur1 = cur1.next;
        }
        int len2 = 0;
        Node cur2 = node2;
        while (cur2.next != null) {
            len2++;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        int diff = len - len2;
        cur1 = diff > 0 ? node : node2;
        cur2 = cur1 == node ? node2 : node;

        diff = Math.abs(diff);
        while (diff > 0) {
            diff--;
            cur1 = cur1.next;
        }

        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private static Node getLoopNode(Node node) {
        if (node == null || node.next == null) {
            return null;
        }
        // double point skip first step
        Node slow = node;
        Node fast = node;

        // 第一次相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // first intersection
            if (slow == fast) {
                break;
            }
        }
        //TODO 无环时， fast 到null  slow 在链表中间位置，直接结束
        if (fast == null || fast.next == null) {
            return null;
        }
        // 实际相遇节点
        fast = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
