package QW;

import java.util.*;

public class LC1615MaximalNetworkRank {
    public static int maximalNetworkRank(int n, int[][] roads) {
        if(n == 1 || roads == null || roads.length == 0) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] r : roads){
            Set<Integer> set1 = graph.getOrDefault(r[0], new HashSet<>());
            Set<Integer> set2 = graph.getOrDefault(r[1], new HashSet<>());
            set1.add(r[1]);
            set2.add(r[0]);
            graph.put(r[0], set1);
            graph.put(r[1], set2);
        }
        int max = -1;
        int maxI = -1;
        int second = -1;
        List<Integer> secondL = new ArrayList<>();
        // get max
        for(int i : graph.keySet()){
            int num = graph.get(i).size();
            if(num > max){
                max = num;
                maxI = i;
            }
        }
        // get second list
        for(int i : graph.keySet()){
            int num = graph.get(i).size();
            if(i == maxI) continue;
            if(num > second){
                second = num;
                secondL.clear();
                secondL.add(i);
            }else if(num == second){
                secondL.add(i);
            }
        }
        boolean connected = true;
        if(max != second){
            for(int i : secondL){
                if(!graph.get(maxI).contains(i)) connected = false;
            }
        }else{ // if max == second
            secondL.add(maxI);
            for(int i = 0; i < secondL.size() - 1; i++){
                for(int j = i + 1; j < secondL.size(); j++){
                    if(!graph.get(secondL.get(i)).contains(secondL.get(j))) connected = false;
                }
            }
        }
        // System.out.println(maxI + " " + secondL);
        int res = max + second;
        if(connected) res -= 1;
        return res;
    }

    public static void main(String[] args) {
        int[][] roads = new int[][]{{7,5},{5,9},{5,10},{6,4},{4,9}};
        System.out.println(maximalNetworkRank(11, roads)); //5
    }
}
// time O(V^2 + E) space O(V + E)
