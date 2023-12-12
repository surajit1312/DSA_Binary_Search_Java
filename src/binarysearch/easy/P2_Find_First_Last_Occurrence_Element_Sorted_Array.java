package binarysearch.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * CodingNinjas: First and Last Position of an Element In Sorted Array
 *
 * Link: https://www.codingninjas.com/studio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 *
 * TC: O(log(N))
 * SC: O(1)
 *
 */
public class P2_Find_First_Last_Occurrence_Element_Sorted_Array {

  public static void main(String[] args) {
    Integer[] nums = { 0, 0, 1, 1, 2, 2, 2, 2 };
    ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(nums));
    int n = 8;
    int k = 2;
    int[] occurrence = firstAndLastPosition(arr, n, k);
    System.out.println(
      "First and Last occurrence of " +
      k +
      " in " +
      arr +
      " is : " +
      Arrays.toString(occurrence)
    );
  }

  public static int[] firstAndLastPosition(
    ArrayList<Integer> arr,
    int n,
    int k
  ) {
    int[] result = { -1, -1 };

    int start = 0;
    int end = n - 1;
    int firstIndex = -1;
    int lastIndex = -1;

    // find first occurrence
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr.get(mid) == k) {
        firstIndex = mid;
        end = mid - 1;
      } else if (arr.get(mid) > k) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    // find last occurrence (only if firstIndex != -1 which means if firstIndex == -1 then k is never present in array)
    if (firstIndex != -1) {
      start = 0;
      end = n - 1;

      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr.get(mid) == k) {
          lastIndex = mid;
          start = mid + 1;
        } else if (arr.get(mid) > k) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }

      result[0] = firstIndex;
      result[1] = lastIndex;
    }
    return result;
  }
}
