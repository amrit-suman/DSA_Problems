package TUFProblems;

public class RotateStrings {

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
