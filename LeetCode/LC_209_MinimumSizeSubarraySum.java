/**
 * 209. Minimum Size Subarray Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
package LeetCode;

public class LC_209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        // Test case: find minimum subarray length with sum >= 7 from [2,3,1,2,4,3]
        System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })); // Expected output: 2
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // Use sliding window technique with two pointers to find minimum subarray
        int low = 0, high = 0, len = nums.length; // low: left window boundary, high: right window boundary, len: array
                                                  // size
        int res = Integer.MAX_VALUE; // Store minimum subarray length found (initialize to max to track smaller
                                     // values)
        int sum = 0; // Track cumulative sum of current window

        while (high < len) { // Expand window: move high pointer to include elements from left to right
            sum = sum + nums[high]; // Add new element at high pointer to window sum

            while (sum >= target) { // Contract window: when sum meets target, try to minimize window size
                res = Math.min(res, high - low + 1); // Update result if current window length is smaller than previous
                                                     // minimum
                sum = sum - nums[low]; // Remove leftmost element (at low pointer) from window sum
                low++; // Move low pointer right to shrink window from left side
            }

            high++; // Move high pointer right to expand window and add next element
        }

        // Return 0 if no valid subarray found (res still equals MAX_VALUE), otherwise
        // return minimum length
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
