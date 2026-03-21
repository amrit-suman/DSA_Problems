package TUFProblems;

public class IsomorphicString {

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
