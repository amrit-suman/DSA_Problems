/** 
 * 205. Isomorphic Strings
Solved
Easy
Topics
premium lock icon
Companies
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.


Example 1:
Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "f11", t = "b23"
Output: false
Explanation:
The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.
Example 3:
Input: s = "paper", t = "title"
Output: true

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
*/
package LeetCode;

public class LC_205_IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("egg","add"));
    }
    public static boolean isIsomorphic(String s, String t) {

        //If a map is required for each alphabet character, always use int array with  ASCII charaters;
        //This algo works because it checks ithe current set of both characters were seen last at the same index;
        int[] m = new int[128];
        int[] n = new int[128];

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(m[charS] != n[charT]){
                return false;
            }
            m[charS] = i + 1;
            n[charT] = i + 1;
        }
        return true;
        //Below code also works but takes more space
        /*if(s.length() != t.length()) return false;
        
        Map<Character, Character> m = new HashMap<>();
        Set<Character> mySet = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(m.containsKey(charS)){
                if(m.get(charS) != charT){
                    return false;
                }
            }else{
                if(mySet.contains(charT)){
                    return false;
                }
                mySet.add(charT);
                m.put(charS, charT);
            }
        }
        return true;*/
    }
}
