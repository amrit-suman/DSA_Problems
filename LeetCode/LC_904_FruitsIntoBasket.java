/**
 * 904. Fruit Into Baskets
 * You can pick at most 2 different types of fruits and collect the maximum number of fruits.
 * Use sliding window to find longest subarray with at most 2 distinct elements.
 */
package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_904_FruitsIntoBasket {

    public static void main(String[] args) {
        // Test case: find maximum fruits when picking at most 2 types from [1,2,3,2,2]
        System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 })); // Expected output: 4 ([2,3,2,2])
    }

    public static int totalFruit(int[] fruits) {
        // Use sliding window with HashMap to track fruit types and their counts in
        // current window
        int low = 0, high = 0, len = fruits.length, max = -1; // low: left window boundary, high: right boundary, max:
                                                              // track maximum fruits collected
        Map<Integer, Integer> m = new HashMap<>(); // Store fruit type and its frequency in current window

        while (high < len) { // Expand window: move high pointer through entire array from left to right
            Integer num = (Integer) fruits[high]; // Get fruit type at high pointer
            m.put(num, m.getOrDefault(num, 0) + 1); // Add/increment fruit type frequency in HashMap

            while (m.size() > 2) { // Contract window: if more than 2 fruit types, shrink from left
                Integer left = (Integer) fruits[low]; // Get fruit type at low pointer to remove
                m.put(left, m.get(left) - 1); // Decrement frequency of left fruit type
                if (m.get(left) == 0) { // If frequency becomes 0, remove fruit type from map
                    m.remove(left); // Remove fruit type entry to reduce distinct type count
                }
                low++; // Move low pointer right to shrink window from left side
            }

            if (m.size() <= 2) { // If current window has at most 2 distinct fruit types
                max = Math.max(max, high - low + 1); // Update max with current window length if larger
            }

            high++; // Move high pointer right to expand window and add next fruit
        }

        return max; // Return maximum fruits collected (or -1 if array
    }
}
