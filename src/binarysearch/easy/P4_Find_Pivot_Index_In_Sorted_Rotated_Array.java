package binarysearch.easy;

import java.util.Arrays;

/**
 *
 * Find Pivot Element in a rotated sorted array
 *
 * TC: O(log(N))
 * SC: O(1)
 *
 */
public class P4_Find_Pivot_Index_In_Sorted_Rotated_Array {

  public static void main(String[] args) {
    int[] nums = { 7, 9, 11, 12, 2, 3 };
    int pivot = pivotIndex(nums);
    System.out.println(
      "Pivot index in " + Arrays.toString(nums) + " is : " + pivot
    );
  }

  private static int pivotIndex(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[0] && nums[mid] > nums[nums.length - 1]) {
        start = mid + 1;
      } else if (nums[mid] < nums[0] && nums[mid] < nums[nums.length - 1]) {
        end = mid;
      }
    }
    return start;
  }
}
