package QW;

import java.util.Arrays;

public class LC2268MinimumNumberOfKeypresses {
    public static int minimumKeypresses(String s) {
        int n = s.length();
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']--;
        }
        Arrays.sort(count);
        int res = 0;
        for(int i = 0; i < 26; i++){
            if(i < 9){
                res += count[i];
            }else if(i < 18){
                res += 2 * count[i];
            }else{
                res += 3 * count[i];
            }
        }
        return -res;
    }

    public static void main(String[] args) {
        System.out.println(minimumKeypresses("abcdefghijkl")); // 15
    }
}
// time O(n) space O(1)
