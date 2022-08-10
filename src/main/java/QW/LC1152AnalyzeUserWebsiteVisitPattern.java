package QW;

import java.util.*;

class Pair<T, E>{
    private T key;
    private E val;

    public Pair(){
        this.key = null;
        this.val = null;
    }

    public Pair(T key, E val){
        this.key = key;
        this.val = val;
    }

    public T getKey() {
        return key;
    }

    public E getValue() {
        return val;
    }
}

public class LC1152AnalyzeUserWebsiteVisitPattern {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair<String, Integer>>> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Pair<String, Integer>> list  = m.getOrDefault(username[i], new ArrayList<>());
            list.add(new Pair(website[i], timestamp[i]));
            m.put(username[i], list);
        }
        Map<String, Integer> score = new HashMap<>();
        String res = "";
        for(String s : m.keySet()){
            Set<String> set = new HashSet<>();
            List<Pair<String, Integer>> list = m.get(s);
            Collections.sort(list, (a , b) -> a.getValue() - b.getValue());
            int size = list.size();
            for(int i = 0; i < size - 2; i++){
                for(int j = i + 1; j < size - 1; j++){
                    for(int k = j + 1; k < size; k++){
                        String pattern = list.get(i).getKey() + "," + list.get(j).getKey() + "," + list.get(k).getKey();
                        if(!set.contains(pattern)){
                            score.put(pattern, score.getOrDefault(pattern, 0) + 1);
                            set.add(pattern);
                        }
                        if(res.equals("")){
                            res = pattern;
                        }else if(score.get(res) < score.get(pattern)){
                            res = pattern;
                        }else if(score.get(res).equals(score.get(pattern)) && pattern.compareTo(res) < 0){
                            res = pattern;
                        }
                    }
                }
            }
        }
        // System.out.println(score);
        // System.out.println("a,b,a".compareTo("a,b,c"));
        return Arrays.asList(res.split(","));
    }

    public static void main(String[] args) {
        String[]  username = {"ua","ua","ua","ub","ub","ub"};
        int[] timestamp = {1,2,3,4,5,6};
        String[] website = {"a","b","a","a","b","c"};
        System.out.println(mostVisitedPattern(username, timestamp, website)); // [a,b,a]
    }
}
// time O(n^3) space O(n)
