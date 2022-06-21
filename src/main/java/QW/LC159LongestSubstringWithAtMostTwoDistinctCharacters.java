package QW;

import java.util.HashMap;
import java.util.Map;

public class LC159LongestSubstringWithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n == 1 || n == 2) return n;
        int l = 0;
        int r = 1;
        Map<Character, Integer> window = new HashMap<>();
        window.put(s.charAt(0), 1);
        int res = 2;
        int curLen = 2;
        while(r < n){
            char cur = s.charAt(r);
            int curSize = window.keySet().size();
            if(curSize < 2){
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                r++;
                curLen = r - l;
            }else if(curSize == 2){
                if(window.containsKey(cur)){
                    window.put(cur, window.getOrDefault(cur, 0) + 1);
                    r++;
                    curLen = r - l;
                }else{
                    int lNum = window.get(s.charAt(l));
                    if(lNum == 1){
                        window.remove(s.charAt(l));
                    }else{
                        window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                    }
                    // System.out.println(" l = " + l);
                    // System.out.println(window);
                    l++;
                }
            }
            // System.out.println(l + " : " + r);
            res = Math.max(res, curLen);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eceba";
        String s2 = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));//3
        System.out.println(lengthOfLongestSubstringTwoDistinct(s2));//5
    }
}
// time O(n) space O(1)
