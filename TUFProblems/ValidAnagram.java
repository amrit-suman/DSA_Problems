package TUFProblems;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(anagramStrings("anagram", "nagaram"));
        System.out.println(anagramStrings("dog", "cat"));
    }

    public static boolean anagramStrings(String s, String t) {

        if (s.length() != t.length())
            return false;
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;

        // Below Code also works but takes more space and more iterations
        // if(s.length() != t.length()) {
        // return false;
        // }

        // Map<Character, Integer> map = new HashMap<>();

        // for(char c : s.toCharArray()){
        // map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        // for(char c : t.toCharArray()){
        // map.put(c, map.getOrDefault(c, 0) - 1);
        // }
        // for(int num : map.values()){
        // if(num != 0){
        // return false;
        // }
        // }
        // return true;

        // Below Code also works but takes more space
        // if(s.length() != t.length()) return false;
        // Map<Character, Integer> sMap = new HashMap<>();
        // Map<Character, Integer> tMap = new HashMap<>();
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();

        // for(int i = 0; i < s.length(); i++){
        // sMap.merge(sArr[i], 1, (a, b) -> a + b);
        // tMap.merge(tArr[i], 1, (a, b) -> a + b);
        // }
        // for(int i = 0; i < s.length(); i++){
        // if(!sMap.containsKey(tArr[i]) || !tMap.containsKey(sArr[i])) return false;
        // if((int)sMap.get(tArr[i]) != (int)tMap.get(tArr[i])) return false;
        // if((int)tMap.get(sArr[i]) != (int)tMap.get(sArr[i])) return false;
        // }
        // return true;
    }
}
