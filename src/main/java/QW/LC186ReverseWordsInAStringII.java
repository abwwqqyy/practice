package QW;

public class LC186ReverseWordsInAStringII {
    public static void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' ' ){
                r = i - 1;
                // System.out.println(l + " " + r);
                reverse(s, l, r);
                l = i + 1;
            }
            if(i == s.length - 1){
                r = i;
                reverse(s, l, r);
            }
        }
    }
    private static void reverse(char[] s, int l, int r){
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s); //"blue is sky the"
    }
}
// time O(n) space O(1)
