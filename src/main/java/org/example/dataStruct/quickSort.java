package org.example.dataStruct;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = { 12, 1, 13, 55, 12, 9, 8 };
        quickSort(arr);
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (arr.length <= 16) {
            insertSort(arr, 0, arr.length - 1);
        }
    }

    private static void insertSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        for (int i = left + 1; i <= right; i++) {
            int ans = arr[i];
            int j = i - 1;
            // j = left 左边界
            while (j >= left && arr[j] > ans) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = ans;
        }
    }

    private static void insertSort2(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2 || right <= left)
            return;
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int low = left;
            int hight = i - 1;
            while (low <= hight) {
                int mid = low + ((hight - low) >>> 1);
                if (arr[mid] <= key) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
            int insertPos = low;
            //有多少大于当前结点的元素
            int numMoved = hight - insertPos + 1;
            if (numMoved > 0) {
                System.arraycopy(arr, insertPos, arr, insertPos + 1, numMoved);
                arr[insertPos] = key;
            }
        }
    }
}
