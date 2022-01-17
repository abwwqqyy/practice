package QW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC290WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if(pattern.length() != sArr.length){
            return false;
        }
        Map<Character, String> m = new HashMap<>();
        Set<String> appeared = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++){
            char cur = pattern.charAt(i);
            if(!m.containsKey(cur)){
                if(appeared.contains(sArr[i])){
                    return false;
                }
                m.put(cur, sArr[i]);
            }else{
                if(!m.get(cur).equals(sArr[i])){
                    // System.out.println(cur + " : " + sArr[i]);
                    return false;
                }
            }
            appeared.add(sArr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        String pattern2 = "aaaa";
        System.out.println(wordPattern(pattern1,s1));// true
        System.out.println(wordPattern(pattern2,s1));// false
    }
}
// time O(n) space O(n)
