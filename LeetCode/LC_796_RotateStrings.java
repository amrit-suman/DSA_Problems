/**
 * 796. Rotate String
Solved
Easy
Topics
premium lock icon
Companies
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 */

package LeetCode;

public class LC_796_RotateStrings {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("xx", "x"));
        System.out.println(rotateString("x", "xx"));
    }

    public static boolean rotateString(String s, String goal) {
        
        //the idea is here is to double the main string to get all possibilities after all number of rotations, master stroke
        //if the strings are not equal then they can never match
        //s = x, goal = xx and s = xx, goal = x
        if(goal.length() != s.length()) return false;
        String newS = s + s;
        if(newS.contains(goal)) return true;
        return false;
    }
}
