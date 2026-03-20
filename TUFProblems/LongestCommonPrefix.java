package TUFProblems;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        
        System.out.println(longestCommonPrefix(new String[]{"flowers" , "flow" , "fly", "flight"}));
    }
    
    public static String longestCommonPrefix(String[] str) {
        
        //The approach here is to take first word as prefix and check if next workds startWith this prefix or not, if not then reduce the prefix by 1 character and check again.
        String prefix = str[0];
        for(int i = 1; i < str.length; i++){
            while(!str[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
}
