package QW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC2246LongestPathWithDifferentAdjacentCharacters {
    private static int max = 1;
    public static int longestPath(int[] parent, String s) {
        int n = s.length();
        ArrayList[] graph;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            graph[parent[i]].add(i);
        }
        dfs(graph, s, 0);

        // System.out.println(Arrays.toString(graph));
        return max;
    }
    private static int dfs(ArrayList[] graph, String s, int node){
        ArrayList<Integer> next = graph[node];
        if(next.size() == 0) return 1;
        char cur = s.charAt(node);
        List<Integer> lens = new ArrayList<>();
        for(int i : next){
            char nextC = s.charAt(i);
            if(cur == nextC){
                dfs(graph, s, i);
            }else{
                lens.add(dfs(graph, s, i) + 1);
            }

        }
        if(lens.size() == 1){
            max = Math.max(max, lens.get(0));
        }else if(lens.size() > 1){
            Collections.sort(lens, Collections.reverseOrder()); // could be reduced to O(n)
            max = Math.max(max, lens.get(1) + lens.get(0) - 1);
        }
        return lens.size() == 0 ? 1 : lens.get(0);
    }

    public static void main(String[] args) {
        int[] parent = new int[]{-1,0,0,1,1,2};
        System.out.println(longestPath(parent,"abacbe")); // 3
    }
}
// time O(nlogn) space O(n)
