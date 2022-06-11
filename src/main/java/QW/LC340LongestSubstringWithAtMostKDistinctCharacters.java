package QW;

import java.util.HashMap;
import java.util.Map;

public class LC340LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(k == 0) return k;
        if(n <= k) return n;
        int l = 0;
        int r = 1;
        Map<Character, Integer> m = new HashMap<>();
        m.put(s.charAt(0), 1);
        int res = 1;
        while(r < n){
            char cur = s.charAt(r);
            int num = m.getOrDefault(cur, 0);
            if(m.keySet().size() < k){
                m.put(cur, num + 1);
                r++;
                res = Math.max(res, r - l);
            }else if(m.keySet().size() > k){
                int num2 = m.getOrDefault(s.charAt(l), 0);
                // System.out.println(l+ " " + r + " "+m.keySet().size() + " " + s.charAt(l)+ " "+ num2);
                // System.out.println(m);
                if(num2 == 1){
                    m.remove(s.charAt(l));
                }else if(num2 > 1){
                    m.put(s.charAt(l), num2 - 1);
                }
                l++;
            }else{
                if(m.containsKey(cur)){
                    m.put(cur, num + 1);
                    r++;
                    res = Math.max(res, r - l);
                }else{
                    int num2 = m.getOrDefault(s.charAt(l), 0);
                    if(num2 == 1){
                        m.remove(s.charAt(l));
                    }else if(num2 > 1){
                        m.put(s.charAt(l), num2 - 1);
                    }
                    l++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));//3
    }
}
