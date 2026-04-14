
/*
15. 3Sum
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15_3Sum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        int i = 0, left, right, len = nums.length;
        Arrays.sort(nums);

        for (i = 0; i < len - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue; // if next and prev element is same, then skip the loop and consider next
                          // emelent only as the sum would remain same for that triplet and we can avoid
                          // duplicate also like this.

            left = i + 1;
            right = len - 1;
            if (nums[i] > 0)
                break; // Early exit: smallest possible sum is already > 0

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // if next element is same for left pointer, then it will add duplicat in the
                                // list, hence skip.
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // if next element is same for right pointer, then it will add duplicat in the
                                 // list, hence skip.
                    left++; // if no duplicate then increment left pointer
                    right--; // if no duplicate then decrement right pointer
                } else if (sum < 0) {
                    left++; // Need a larger value
                } else {
                    right--; // Need a smaller value
                }
            }
        }
        return res;
    }
}
