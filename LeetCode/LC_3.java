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
        System.out.println(lengthOfLongestSubstring("abcabde"));
    }

    public static int lengthOfLongestSubstring(String s) { //O(n)
        
        int n = s.length();
        if (n == 0 || n == 1) return n;

        int i = 0, j = 0, longestLen = 0;
        Set<Character> charSet = new HashSet<>();

        while(j < n){
            char ch = s.charAt(j);
            if(!charSet.contains(ch)){
                charSet.add(ch);
                longestLen = Math.max(longestLen, j - i + 1);
                j++;
            }else{
                charSet.remove(s.charAt(i));
                i++;
            }
        }
        return longestLen;
    }

    // public static int lengthOfLongestSubstring(String s) { //O(n^2)
        
    //     int strLen = s.length();
    //     if(strLen == 0 || strLen == 1) return strLen;

    //     int i = 0, j = 0, longestLen = 0;
    //     Set<Character> charSet = new HashSet<>();

    //     while(i < strLen && j < strLen){
    //         if(!charSet.contains(s.charAt(j))){
    //             charSet.add(s.charAt(j));
    //             j++;
    //         }else{
    //             if(j - i > longestLen) {
    //                 longestLen = j - i;
    //             }
    //             charSet.clear();
    //             i++;
    //             j = i;
    //         }
    //     }
    //     if(j - i > longestLen) {
    //         longestLen = j - i;
    //     }
    //     return longestLen;
    // }
}