package org.example.leetcode.max;

public class ArrayMax {
    public static void main(String[] args) {
        // simple test case
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int idx = getMax(arr);
        System.out.println("Max value=" + arr[idx] + " at index=" + idx);
        // call optimized linear version as comparison
        int linearIdx = linearMaxIndex(arr);
        System.out.println("(linear scan) Max value=" + arr[linearIdx] + " at index=" + linearIdx);
    }

    /**
     * Return the index of the largest element using divide-and-conquer recursion.
     * @param arr input array (must be non-empty)
     * @return index of maximum
     */
    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array must not be null or empty");
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int begin, int end) {

        if (begin == end) {
            return begin;
        }
        int mid = begin + ((end - begin) >> 1);
        int leftMax = process(arr, begin, mid);
        int rightMax = process(arr, mid + 1, end);
        // the call to Math.max here does nothing (it returns the larger index, not value)
        // we can simply compare values and return the proper index.
        if (arr[leftMax] > arr[rightMax]) {
            return leftMax;
        } else {
            return rightMax;
        }
    }

    /**
     * A simple linear scan that is easier to understand and has less overhead.
     * This is the recommended optimization for finding the max in an array.
     */
    public static int linearMaxIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array must not be null or empty");
        }
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                idx = i;
            }
        }
        return idx;
    }

}
