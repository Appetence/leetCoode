package org.example.dataStruct;

public class Bubble {

    public static void main(String[] args) {
        int[] arr3 = { 64, 34, 25, 12, 22, 11, 90 };
        int left = 0;
        int right = arr3.length - 1;

        bubbleSort(arr3, left, right);
        printArray(arr3);
    }

    private static void bubbleSort(int[] arr, int left, int right) {
        while (left < right) {
            // 从左到右依次交换
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            // 最大值已经放到最右边 下次循环缩小范围
            right--;
            // 
            for (int j = right; j > left; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            // 最小值已经放到最左边 下次循环时候缩小范围
            left++;

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
