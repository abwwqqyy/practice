package QW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1048LongestStringChain {
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> m = new HashMap<>();
        int res = 1;
        for(String s : words){
            int curLen = 1;
            for(int i = 0; i < s.length(); i++){
                StringBuilder cur = new StringBuilder(s);
                cur.deleteCharAt(i);
                int prevLen = m.getOrDefault(cur.toString(), 0);
                curLen = Math.max(curLen, prevLen + 1);
                // cur.insert(i, s.charAt(i));
            }
            m.put(s, curLen);
            res = Math.max(res, curLen);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words)); // 4
    }
}
// time O(nlogn + nL^2) space O(n)
