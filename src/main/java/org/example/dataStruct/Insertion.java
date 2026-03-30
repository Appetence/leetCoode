package org.example.dataStruct;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("Before: " + Arrays.toString(arr));
        // insertionSort(arr);
        // insertBinery(arr);
        c_insertBinary(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    private static void c_insertBinary(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            // 0 , i - 1
            int pos = c_binaryUperBound(arr, key, 0, i - 1);

            if (pos < i) {
                System.arraycopy(arr, pos, arr, pos + 1, i - pos);
                arr[pos] = key;
            }

        }
    }

    private static int c_binaryUperBound(int[] arr, int key, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) >>> 1;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static void insertBinery(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            // 找到插入位置（上界），保持稳定性
            int pos = binaryUperBound(arr, key, 0, i - 1);
            // 表示已经没有
            if (pos < i) {
                // 快速移动
                System.arraycopy(arr, pos, arr, pos + 1, i - pos);
                arr[pos] = key;
            }
        }
    }

    private static int binaryUperBound(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // 返回第一个 > key 的位置（也即上界）
        return low;
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                // point offset
                arr[j + 1] = arr[j];
                j = j--;
            }
            arr[j + 1] = key;
        }
    }
}