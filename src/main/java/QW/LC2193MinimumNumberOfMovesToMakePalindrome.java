package QW;

public class LC2193MinimumNumberOfMovesToMakePalindrome {
    public static int minMovesToMakePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return count(sb);
    }
    private static int count(StringBuilder sb){
        if(sb.length() <= 2){
            return 0;
        }
        int l = 0;
        char lc = sb.charAt(l);
        int r = sb.length() - 1;
        char rc = sb.charAt(r);
        while(r > 0){
            if(sb.charAt(l) == rc){
                sb.deleteCharAt(l);
                sb.deleteCharAt(sb.length() - 1);
                break;
            }else if(sb.charAt(r) == lc){
                sb.deleteCharAt(r);
                sb.deleteCharAt(0);
                break;
            }
            l ++;
            r --;
        }
        return l - 0 + count(sb);
    }

    public static void main(String[] args) {
        System.out.println(minMovesToMakePalindrome("aabbc")); // 4
    }
}
// time O(n^2) space O(n)
