package org.example.dataStruct;

public class Selection {
    public static void main(String[] args) {
        
        int[] arr = {64, 25, 12, 22, 11};
        
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        
        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        
    }
    
}
