package binarysearch.medium;

/**
 * 
 * Find an element in an infinite sorted array
 * 
 * TC: O(log(N))
 * SC: O(1)
 * 
 */
public class P2_Search_Element_In_Infinite_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i * 2;
        }
        int target = 50000;
        int index = binarySearch(arr, target);
        System.out.println("In infinite sorted array, " + target + " is found at index : " + index);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[end] < target) {
            start = end;
            end = end * 2;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
