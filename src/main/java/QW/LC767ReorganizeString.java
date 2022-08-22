package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC767ReorganizeString {
    public static String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            count[cur - 'a']++;
        }
        Queue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(int i = 0; i < 26; i++){
            if(count[i] > n / 2 + 1) return "";
            pq.offer(new Pair((char) (i+'a'), count[i]));
        }
        StringBuilder res = new StringBuilder();
        int idx = 0;
        char prev = ' ';
        // System.out.println(pq);
        while(idx < n){
            Pair<Character, Integer> cur = pq.poll();
            char c = cur.getKey();
            int left = cur.getValue();
            if(c != prev){
                if(left < 1) return "";
                res.append(c);
                pq.offer(new Pair(c, --left));
                prev = c;
            }else{
                if(pq.isEmpty()){
                    return "";
                }else{
                    Pair<Character, Integer> next = pq.poll();
                    char nextC = next.getKey();
                    int nextLeft = next.getValue();
                    if(nextLeft < 1) return "";
                    res.append(nextC);
                    // System.out.println(nextC);
                    pq.offer(new Pair(nextC, --nextLeft));
                    pq.offer(cur);
                    prev = nextC;
                }
            }
            idx++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("abba"));//abab
    }
}
// time O(n) space O(1)
