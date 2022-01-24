package QW;

public class LC520DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 1) return true;
        if(Character.isUpperCase(word.charAt(0))){ // first capital
            boolean flag = Character.isUpperCase(word.charAt(1)); // the second char
            for(int i = 2; i < n; i++){
                if(Character.isUpperCase(word.charAt(i)) != flag) {// if later not the same as the second char
                    return false;
                }
            }
        }else{ // all lower case
            for(int i = 1; i < n; i++){
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("flaG")); // false
        System.out.println(detectCapitalUse("Flag")); // true
        System.out.println(detectCapitalUse("FLAG")); // true
    }
}
// time O(n) space O(1)
