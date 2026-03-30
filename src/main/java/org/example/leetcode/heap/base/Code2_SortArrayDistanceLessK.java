package org.example.leetcode.heap.base;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.example.leetcode.common.BaseArray;

public class Code2_SortArrayDistanceLessK {
    public static void main(String[] args) {
        int[] baseArr = BaseArray.baseArr();
        System.out.println(Arrays.toString(baseArr));
        distanceLessK(baseArr, 3);
        System.out.println(Arrays.toString(baseArr));

    }

    private static void distanceLessK(int[] baseArr, int distance) {

        if (baseArr == null || baseArr.length < 2) {
            return;
        }
        // 限制指定长度
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        int index = 0;

        for (; index < Math.min(distance, baseArr.length); index++) {
            priority.add(baseArr[index]);
        }

        int i = 0;
        for (; index < baseArr.length; index++) {
            priority.add(baseArr[index]);
            baseArr[i] = priority.poll();
        }
        while (!priority.isEmpty()) {
            baseArr[i++] = priority.poll();
        }

    }
}
