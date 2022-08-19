package QW;

import java.util.HashSet;
import java.util.Set;

public class LC1044LongestDuplicateSubstring {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        long[] pow = new long[n + 1];
        pow[0] = 1;
        long[] hash = new long[n + 1];
        int prime = 31;
        for(int i = 0; i < n; i++){
            pow[i + 1] = prime * pow[i];
            hash[i + 1] = hash[i] * prime + s.charAt(i) - 'a';
        }

        int l = 1;
        int r = n;
        int len = 0;
        int start = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            int pos = check(s, mid, pow, hash);
            if(pos > 0) {
                len = mid;
                start = pos;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        // System.out.println(start + " " + len);
        // System.out.println(check(s, 3, pow, hash));

        if(start != -1){
            return s.substring(start, start + len);
        }
        return "";
    }
    private static int check(String s, int len, long[] pow, long[] hash){ // rolling hash
        int n = s.length();
        Set<Long> seen = new HashSet<>();
        for(int i = 1; i + len - 1 <= n; i++){
            int j = i + len - 1;
            long cur = hash[j] - hash[i - 1] * pow[len];
            // System.out.println(cur);
            if(seen.contains(cur)) return i - 1;
            seen.add(cur);
        }
        // System.out.println(seen);

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); //ana
    }
}
// time O(nlogn) space O(n)
