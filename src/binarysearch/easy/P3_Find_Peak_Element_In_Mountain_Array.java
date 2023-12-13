package binarysearch.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * GeeksForGeeks: Bitonic Point
 * CodingNinjas : Find Peak Element
 *
 * Link:
 *
 * https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1
 * https://www.codingninjas.com/studio/problems/find-peak-element_1081482
 *
 * TC: O(log(N))
 * SC: O(1)
 *
 */
public class P3_Find_Peak_Element_In_Mountain_Array {

  public static void main(String[] args) {
    Integer[] nums = { 1, 8, 1, 5, 3 };
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(nums));
    int peakIndex = findPeakElement(arr);
    System.out.println(
        "Peak element in " + arr + " is found at index : " + peakIndex);
  }

  public static int findPeakElement(ArrayList<Integer> arr) {
    int n = arr.size();
    if (n == 1) {
      return 0;
    }
    if (arr.get(0) > arr.get(1)) {
      return 0;
    }
    if (arr.get(n - 1) > arr.get(n - 2)) {
      return n - 1;
    }
    int start = 1;
    int end = n - 2;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
        return mid;
      } else if (arr.get(mid) > arr.get(mid - 1)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
