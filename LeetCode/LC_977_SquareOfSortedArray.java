package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_977_SquareOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
    }

    public static int[] sortedSquares(int[] nums) {

        int len = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative array
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                neg.add(nums[i]);
            } else if (nums[i] >= 0) {
                pos.add(nums[i]);
            }
        }

        // run if input has only positive numbers, straightforward
        if (neg.size() == 0) {
            int[] res = new int[len];
            for (int j = 0; j < len; j++) {
                res[j] = nums[j] * nums[j];
            }
            return res;
        }
        // run if input has only negative numbers
        // sqaure the negative array and square it because it is in descending order
        else if (pos.size() == 0) {
            int k = 0;
            int[] res = new int[len];
            for (int j = len - 1; j >= 0; j--) {
                res[k] = nums[j] * nums[j];
                k++;
            }
            return res;
        } else {
            // run if input has both type of numbers
            int i = 0, j = 0, idx = 0;
            int n1 = neg.size();
            int n2 = pos.size();
            int res[] = new int[n1 + n2];

            for (i = 0; i < n1; i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }
            // sqaure the negative array and square it because it is in descending order
            Collections.reverse(neg);

            for (i = 0; i < n2; i++) {
                pos.set(i, pos.get(i) * pos.get(i));
            }

            // now apply merge on both sorted array using 2 pointers
            i = 0;
            while (i < n1 && j < n2) {
                if (neg.get(i) <= pos.get(j)) {
                    res[idx++] = neg.get(i++);
                } else {
                    res[idx++] = pos.get(j++);
                }
            }
            while (i < n1) {
                res[idx++] = neg.get(i++);
            }
            while (j < n2) {
                res[idx++] = pos.get(j++);
            }
            return res;
        }
    }
}
