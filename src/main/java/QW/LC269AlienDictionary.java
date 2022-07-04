package QW;

import java.util.*;

public class LC269AlienDictionary {
    public static String alienOrder(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        // initialize
        for(String w : words){
            for(char c : w.toCharArray()){
                indeg.put(c, 0);
                adj.put(c, new HashSet<>());
            }
        }
        // get adjlist
        for(int i = 0; i < n - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";
            }
            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(adj.get(w1.charAt(j)).add(w2.charAt(j))){
                        indeg.put(w2.charAt(j), indeg.get(w2.charAt(j)) + 1);
                    }
                    break; // only first dif counts
                }
            }
        }
        // bfs for topo sort
        StringBuilder res = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(Character c : adj.keySet()){
            // System.out.println(c + " : " + adj.get(c).toString());
            if(indeg.get(c) == 0){
                q.offer(c);
            }
        }
        while(!q.isEmpty()){
            char cur = q.poll();
            res.append(cur);
            for(Character c : adj.get(cur)){
                int indegree = indeg.get(c);
                indegree--;
                indeg.put(c, indegree);
                if(indegree == 0){
                    q.offer(c);
                }
            }
        }
        if(res.length() != indeg.size()){// topo order: if cycle then cannot go to everychar
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words)); // "wertf"
    }
}
// time O(len * n) space O(U + min(U^2, n))
