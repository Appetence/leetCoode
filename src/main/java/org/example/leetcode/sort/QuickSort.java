package org.example.leetcode.sort;

import org.example.leetcode.common.BaseArray;

import java.util.Stack;

/**
 * @program: Leetcode
 * @description: 给定一个数组，小于最后一个元素的左边 等于最后一个元素的中间，大于最后一个元素的右边
 * @author: liuhao
 * @date: 2023-07-07 17:16
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 5, 89, 4, 3, 0, 2, 1, 5};
        BaseArray.each(arr);
        partition(arr);
        BaseArray.each(arr);

    }

    private static void partition(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        process(arr, 0, arr.length - 1);
        quiksort(arr, 0, arr.length - 1);
//        pJob(arr, 0, arr.length - 1);

    }

    /**
     * 非递归实现
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static void quiksort(int[] arr, int left, int right) {
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(left, right));
        while (!stack.isEmpty()) {
            // 限制上下限
            Job pop = stack.pop();
            // 新的上下限
            Job job = process3(arr, pop.left, pop.right);
            if (job.left > pop.left) {

                stack.push(new Job(pop.left, job.left - 1));
            }
            if (job.right  < pop.right) {
                stack.push(new Job(job.right + 1, pop.right));
            }
        }
    }

    private static void process2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int leftL = left - 1;
        int moreIndex = right;
        int item = left;
        while (item < moreIndex) {
            if (arr[item] < arr[right]) {
                swap(arr, item++, ++leftL);
            } else if (arr[item] > arr[right]) {
                swap(arr, item, --moreIndex);
            } else {
                item++;
            }
        }
        swap(arr, item, right);
        BaseArray.each(arr);
        Job job = new Job(leftL + 1, item);
        if (job.left > 0 && job.left + 1 <= right) {
            process2(arr, left, job.left - 1);
        }
        if (job.right > 0 && job.right + 1 <= right) {
            process2(arr, job.right + 1, right - 1);
        }

    }

    private static void pJob(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        Job job = process3(arr, left, right);
/*        if (left < job.left && job.left > -1) {
            pJob(arr, left, job.left - 1);
        }
        if (right > job.right && job.right > -1) {
            pJob(arr, job.right + 1, right);

        }*/
        if (left < job.left) {
            pJob(arr, left, job.left - 1);
        }
        if (right > job.right ) {
            pJob(arr, job.right + 1, right);

        }
    }

    private static Job process3(int[] arr, int left, int right) {
/*        if (left >= right) {
            return new Job(-1, -1);
        }*/
        int leftL = left - 1;
        int moreIndex = right;
        int item = left;
        while (item < moreIndex) {
            if (arr[item] < arr[right]) {
                swap(arr, item++, ++leftL);
            } else if (arr[item] > arr[right]) {
                swap(arr, item, --moreIndex);
            } else {
                item++;
            }
        }
        swap(arr, item, right);
        BaseArray.each(arr);
        return new Job(leftL + 1, item);

    }


    private static void process(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int itemIndex = left;
        // 小于指定节点元素index
        int itemIndexL = left - 1;
        int lestIndex = right;
        int moreR = lestIndex;
        while (itemIndex < moreR) {
            // 当前节点小于最后一个节点
            if (arr[itemIndex] < arr[lestIndex]) {
                // 当前节点左元素  与 当前节点交换  当前节点后移一位
                swap(arr, ++itemIndexL, itemIndex++);
            } else if (arr[itemIndex] > arr[lestIndex]) {
                // 当前节点 与 大于区间元素交换 ，大于区间元素前移一位
                swap(arr, --moreR, itemIndex);
            } else {
                itemIndex++;
            }
        }
        // 当前节点和最后一个元素交换
        swap(arr, itemIndex, lestIndex);


    }

    private static void swap(int[] arr, int left, int right) {
        int item = arr[left];
        arr[left] = arr[right];
        arr[right] = item;
    }
}

class Job {
    public int left;

    public int right;

    public Job(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Job{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}