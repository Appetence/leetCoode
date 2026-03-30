package org.example.dataStruct.quick;

public class QuickSort_medianOfThree {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.println("Before: " + java.util.Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After:  " + java.util.Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int begin, int end, int[] arrSort) {
        if (end <= begin)
            return;
        // use insertion sort for small ranges
        // if (end - begin <= 16) {
        // insertionSort(arr, begin, end);
        // return;
        // }
        int mid = begin + ((end - begin) >>> 1);
        mergeSort(arr, begin, mid, arrSort);
        mergeSort(arr, mid + 1, end, arrSort);
        // if already ordered, skip merge
        if (arr[mid] <= arr[mid + 1])
            return;
        merge(arr, begin, mid, end, arrSort);
    }

    private static void merge(int[] arr, int begin, int mid, int end, int[] arrSort) {
        int i = begin;
        int j = mid + 1;
        int idx = begin;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                arrSort[idx++] = arr[i++];
            } else {
                arrSort[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            arrSort[idx++] = arr[i++];
        }
        while (j <= end) {
            arrSort[idx++] = arr[j++];
        }
        for (int k = begin; k <= end; k++) {
            arr[k] = arrSort[k];
        }
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ---- QuickSort implementation ----
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        while (lo < hi) {
            // cutoff to insertion sort for small partitions
            // if (hi - lo <= 16) {
            // insertionSort(arr, lo, hi);
            // break;
            // }
            // 较大的移动到最末尾
            int pivotIndex = medianOfThree(arr, lo, hi);
            swap(arr, pivotIndex, hi); // move pivot to end
            int p = partition(arr, lo, hi);
            // recurse on smaller side first to limit stack depth
            if (p - lo < hi - p) {
                quickSort(arr, lo, p - 1);
                lo = p + 1;
            } else {
                quickSort(arr, p + 1, hi);
                hi = p - 1;
            }
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                // 不影响后续的++
                swap(arr, i, j);
                i++;
            }
        }
        // area max value to end
        swap(arr, i, hi);
        return i;
    }

    private static int medianOfThree(int[] arr, int lo, int hi) {
        int mid = lo + ((hi - lo) >>> 1);
        if (arr[lo] > arr[mid])
            swap(arr, lo, mid);
        if (arr[lo] > arr[hi])
            swap(arr, lo, hi);
        if (arr[mid] > arr[hi])
            swap(arr, mid, hi);
        return mid;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
