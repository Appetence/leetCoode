package org.example.dataStruct.quick;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("Before: " + java.util.Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After:  " + java.util.Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (arr == null || arr.length < 2 || end <= begin) {
            return;
        }
        while (begin < end) {
            if (end - begin + 1 <= 16) {
                insertionSort(arr, begin, end);
                return;
            }

            int mid = medianOfThree(arr, begin, end);
            swap(arr, mid, end);

            int pivotIndex = partition(arr, begin, end);

            int leftSize = pivotIndex - begin;
            int rightSize = end - pivotIndex;

            if (leftSize < rightSize) {
                quickSort(arr, begin, pivotIndex - 1);
            } else {
                quickSort(arr, pivotIndex + 1, end);
            }
        }
    }

    private static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            int pivot = arr[i];
            int j;
            for (j = i - 1; j >= begin && arr[j] > pivot; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = pivot;
        }
    }

    private static int medianOfThree(int[] arr, int begin, int end) {
        int mid = begin + ((end - begin) >>> 1);
        if (arr[begin] > arr[mid]) {
            swap(arr, begin, mid);
        }
        if (arr[begin] > arr[end]) {
            swap(arr, begin, end);
        }
        if (arr[mid] > arr[end]) {
            swap(arr, mid, end);
        }
        return mid;
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int idx = begin;
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, idx++, j);
            }
        }
        // keep area upper bound
        swap(arr, idx, end);
        return idx;
    }

    private static void swap(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
