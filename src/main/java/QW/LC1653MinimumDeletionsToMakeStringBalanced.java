package QW;

public class LC1653MinimumDeletionsToMakeStringBalanced {
    public static int minimumDeletions(String s) {
        int n = s.length();
        int res = 0;
        int countb = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'){
                res = Math.min(res + 1, countb); // delete this 'a' or not
            }else{
                countb++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab")); // 2
    }
}
// time O(n) space O(1)
