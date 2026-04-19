/**
 * You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26


 * */
package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class GFG_Longest_Substring_With_K_Uniques {

    public static void main(String[] args) {
        // Test case: find longest substring with exactly 3 distinct characters
        System.out.println(longestKSubstr("aabacbebebe", 3)); // Expected output: 7 ("cbebebe")
    }

    public static int longestKSubstr(String s, int k) {
        // Use sliding window with HashMap to track character frequencies in current
        // window
        int low = 0, high = 0; // low: left window boundary, high: right window boundary
        int len = s.length(); // Store string length to avoid repeated method calls
        int max = -1; // Track maximum substring length found (initialize to -1 for "no valid
                      // substring" case)
        Map<Character, Integer> m = new HashMap<>(); // Store character frequencies in current window

        while (high < len) { // Expand window: move high pointer through entire string from left to right
            char c = s.charAt(high); // Get character at high pointer
            m.put(c, m.getOrDefault(c, 0) + 1); // Add/increment character frequency in HashMap

            while (m.size() > k) { // Contract window: if distinct characters exceed k, shrink from left
                char left = s.charAt(low); // Get character at low pointer to remove
                m.put(left, m.get(left) - 1); // Decrement frequency of left character
                if (m.get(left) == 0) { // If frequency becomes 0, remove character from map
                    m.remove(left); // Remove character entry to reduce distinct character count
                }
                low++; // Move low pointer right to shrink window from left side
            }

            if (m.size() == k) { // If current window has exactly k distinct characters
                max = Math.max(max, high - low + 1); // Update max with current window length if larger
            }

            high++; // Move high pointer right to expand window and add next character
        }

        return max; // Return maximum substring length found (or -1 if no valid substring
    }
}
