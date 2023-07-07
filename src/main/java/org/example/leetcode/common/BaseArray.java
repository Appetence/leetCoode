package org.example.leetcode.common;

/**
 * @program: Leetcode
 * @description:
 * @author: liuhao
 * @date: 2023-07-07 15:06
 */
public class BaseArray {
    public static int[] baseArr() {
        return new int[]{9, 3, 4, 1, 2, 5, 6, 0, 1, 0, 1, 23, 22, 566, 1};
//        return new int[]{9, 1, 3, 1};
    }
    public  static void each(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(">>");
    }
}
