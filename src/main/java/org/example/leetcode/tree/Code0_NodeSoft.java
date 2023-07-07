package org.example.leetcode.tree;

import org.example.leetcode.common.Node;

/**
 * @program: Leetcode
 * @description: 单链表排序
 * @author: liuhao
 * @date: 2023-06-12 19:50
 */
public class Code0_NodeSoft {
    public static void main(String[] args) {
        // 单链表 从小到大排序
        Node node = Node.buildNode(10);
//        Node treeNode = softNode(node);
    }

/*    private static Node softNode(Node<Integer> node) {
        // 从头节点开始，依次向后遍历 两两比较，冒泡排序
        if (node == null) {
            return node;
        }
        // 递归排序 从前往后
        Node<Integer> temp = node;
        while (temp.hasNext()) {
            Node<Integer> next = node.next;
            if (next.data < temp.data) {
                // 前边大 后边小 交换
                Integer data = next.data;
                next.data = temp.data;
                temp.data = data;
            }
            temp = next;
        }


        // 冒泡排序

        // 插入排序

        // 选择排序
    }*/
}
