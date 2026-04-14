/**
75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
package LeetCode;

import java.util.Arrays;

public class LC_75_SortColors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[] { 2, 0, 2, 1, 1, 0 })));
    }

    public static int[] sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        // use 3 pointers, mid for scanning and keep moving ahead,
        // low for replacing element with mid whene mid encounters 0
        // high for replacing element with mid whene mid encounters 2
        while (mid <= high) {
            if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;// once replaced, high should be decremented
                // here we are not moving mid++ because we still dont know what new number came
                // in
            } else if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
                // once low is replaced move both pointers
            } else {
                mid++;
            }
        }
        return nums;
    }
}
