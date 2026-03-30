package org.example.leetcode.linked.buildLinked;

/**
 * 复制含有随机指针节点的链表
 * 
 * 
 * rand指针式单链表节点结构中新增的指针
 * rand 可能指向链表中的任意一个节点，也可能指向null
 * 给顶一个由Node 节点类型构成的无环单链表的头节点head
 * 实现一个函数完成这个链表的复制，并返回复制的新链表的头节点
 * 
 * 时间复杂度 O(N) 空间复杂度 O(1)
 */
public class Code3_Linked_Copy {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 设置随机指针
        node1.rand = node3; // 1 -> 3
        node2.rand = node1; // 2 -> 1
        node3.rand = node4; // 3 -> 4
        node4.rand = null; // 4 -> null
        Node copy = printRandLinkedList(node1);
        printLinkedListWithRand(copy);
    }

    private static Node printRandLinkedList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node curCopy = new Node(cur.value);
            cur.next = curCopy;
            curCopy.next = next;
            cur = next;
        }

        // 1 -> 1' -> 2 -> 2'
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            Node curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        // split
        Node res = head.next;
        cur = head;
        while (cur != null) {
            // 为为啥不做空判断
            next = cur.next.next;
            Node curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;

    }

    /**
     * 打印链表（包含 rand 指针）
     * 格式：value:randValue
     */
    private static void printLinkedListWithRand(Node head) {
        Node current = head;
        int index = 0;
        while (current != null) {
            String randInfo = (current.rand != null) ? String.valueOf(current.rand.value) : "null";
            System.out.print("Node" + index + "(" + current.value + ":" + randInfo + ")");
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
            index++;
        }
        System.out.println();
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
