package binarysearch.medium;

import java.util.Arrays;

/**
 * 
 * CodingNinjas: Search In Rotated Sorted Array
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/search-in-rotated-sorted-array_630450
 * 
 * TC: O(log(N))
 * SC: O(1)
 * 
 */
public class P1_Search_In_Sorted_Rotated_Array {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        int key = 3;
        int searchIndex = search(arr, key);
        System.out.println("In array " + Arrays.toString(arr) + ", " + key + " is found at index : " + searchIndex);
    }

    private static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] >= arr[start]) {
                // check if left half is sorted
                if (key >= arr[start] && key <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right half is sorted
                if (key >= arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
