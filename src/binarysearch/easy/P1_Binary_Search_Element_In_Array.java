/**
 *
 */
package binarysearch.easy;

import java.util.Arrays;

/**
 *
 * GeeksForGeeks: Binary Search
 *
 * Link: https://www.geeksforgeeks.org/problems/binary-search-1587115620/1
 *
 * TC: O(log(n))
 * SC: O(1)
 *
 */
public class P1_Binary_Search_Element_In_Array {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] nums = { 1, 3, 7, 9, 11, 12, 45 };
    int target = 3;
    int result = search(nums, target);
    System.out.println(
      "Index of " + target + " in " + Arrays.toString(nums) + " is : " + result
    );
  }

  private static int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
