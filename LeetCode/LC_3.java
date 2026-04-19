package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb" 
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LC_3 {

    public static void main(String[] args) {
        // Test case: find longest substring without repeating characters in "abcabde"
        System.out.println(lengthOfLongestSubstring("abcabde")); // Expected output: 4 ("abde")
    }

    public static int lengthOfLongestSubstring(String s) { // O(n) time complexity using sliding window

        int n = s.length(); // Store string length to avoid repeated method calls
        if (n == 0 || n == 1)
            return n; // Base case: empty or single character strings return their length

        int i = 0, j = 0, longestLen = 0; // i: left window boundary, j: right window boundary, longestLen: max length
                                          // found
        Set<Character> charSet = new HashSet<>(); // Store characters in current window to detect duplicates

        while (j < n) { // Expand window: move right pointer through entire string
            char ch = s.charAt(j); // Get character at right pointer
            if (!charSet.contains(ch)) { // If character is not in current window (no duplicate)
                charSet.add(ch); // Add character to set to track it in current window
                longestLen = Math.max(longestLen, j - i + 1); // Update longestLen if current window is larger
                j++; // Move right pointer to expand window
            } else { // If character already exists in window (duplicate found)
                charSet.remove(s.charAt(i)); // Remove leftmost character from set
                i++; // Move left pointer right to shrink window and exclude duplicate
            }
        }
        return longestLen; // Return maximum substring length found without repeating characters
    }

    // public static int lengthOfLongestSubstring(String s) { //O(n^2) Brute force
    // approach

    // int strLen = s.length();
    // if(strLen == 0 || strLen == 1) return strLen;

    // int i = 0, j = 0, longestLen = 0;
    // Set<Character> charSet = new HashSet<>();

    // while(i < strLen && j < strLen){
    // if(!charSet.contains(s.charAt(j))){
    // charSet.add(s.charAt(j));
    // j++;
    // }else{
    // if(j - i > longestLen) {
    // longestLen = j - i;
    // }
    // charSet.clear();
    // i++;
    // j = i;
    // }
    // }
    // if(j - i > longestLen) {
    // longestLen = j - i;
    // }
    // return longestLen;
    // }
}