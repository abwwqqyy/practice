package QW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC472ConcatenatedWords {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String w : words){
            set.add(w);
        }
        for(String w : words){
            set.remove(w);
            int m = w.length();
            boolean[] dp = new boolean[m + 1];
            dp[0] = true;
            for(int i = 1; i <= m; i++){
                for(int j = i; j <= m; j++){
                    if(dp[j]) continue;
                    if(dp[i - 1] && set.contains(w.substring(i - 1, j))){
                        dp[j] = true;
                    }
                }
            }
            set.add(w);
            if(dp[m]) res.add(w);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));// ["catsdogcats","dogcatsdog","ratcatdogcat"]
    }
}
// time O(n*m^3) space O(m)
