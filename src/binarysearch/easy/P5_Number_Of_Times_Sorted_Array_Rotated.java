package binarysearch.easy;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Number of times sorted array is rotated
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/rotation_7449070
 * 
 * TC: O(log(N))
 * SC: O(1)
 * 
 */
public class P5_Number_Of_Times_Sorted_Array_Rotated {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1 };
        int rotations = findKRotation(arr);
        System.out.println("Sorted array " + Arrays.toString(arr) + " has been rotated " + rotations + " times.");
    }

    public static int findKRotation(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int minimum = Integer.MAX_VALUE;
        int minIndex = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // find the sorted part and pick the minimum
            if (arr[mid] >= arr[start]) {
                // left half is sorted
                if (minimum > arr[start]) {
                    minimum = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
            } else {
                // right half is sorted
                if (minimum > arr[mid]) {
                    minimum = arr[mid];
                    minIndex = mid;
                }
                end = mid - 1;
            }
        }
        return minIndex;
    }
}
