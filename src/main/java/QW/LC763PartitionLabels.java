package QW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC763PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> m = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            m.put(s.charAt(i), i);//store the last occurrence
        }
        int prev = 0;
        int curSeg = m.get(s.charAt(0));
        for(int i = 0; i < n; i++){
            curSeg = Math.max(curSeg, m.get(s.charAt(i)));// extend segement
            if(i == curSeg){
                res.add(i - prev + 1);
                // System.out.println(i + " " + prev + " " + s.charAt(i));
                prev = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));//[9,7,8]
    }
}
// time O(N) space O(1)
