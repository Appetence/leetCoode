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
    }

    private static Node softNode(Node<Integer> node) {
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
        return null;

    }
    // 选择排序：两两比较，谁大谁向右，最后交换；做不到稳定

    // 冒泡排序：两两比较，马上交换 谁大谁往右 相等时候不交换（稳定） 相等时交换（不稳定）

    // 插入排序：从后往前依次比较，发现自己小酒交换 相等时候不交换（稳定） 相等时交换（不稳定）

    // 快速排序：选定基准点，分而治之; 做不到稳定，partition做不到

    // 归并：可以做到稳定

    // 堆排序：不关注稳定性

    // 桶排序：

    // 计数排序

    // 基数排序：从小到大，按位依次比较


    // 稳定性：同样的值，在不改变数组原始状态下就是稳定的
}
