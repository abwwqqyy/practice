package QW;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC818RaceCar {
    public static int racecar(int target) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>(); //pos, speed pair
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        q.offer(new int[]{0, 1});
        visited.add(new Pair(0, 1));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                // "A"
                int nextPos = cur[0] + cur[1];
                int nextSpeed = 2 * cur[1];
                if(!visited.contains(new Pair(nextPos, nextSpeed)) && Math.abs(target - nextPos) < target){
                    q.offer(new int[]{nextPos, nextSpeed});
                    visited.add(new Pair(nextPos,nextSpeed));
                }
                if(nextPos == target) return res + 1;
                // "R"
                nextPos = cur[0];
                nextSpeed = cur[1] > 0 ? -1 : 1;
                if(!visited.contains(new Pair(nextPos, nextSpeed)) && Math.abs(target - nextPos) < target){
                    q.offer(new int[]{nextPos, nextSpeed});
                    visited.add(new Pair(nextPos,nextSpeed));
                }
            }
            res ++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(racecar(6));// 5
    }
}
// time O(tlogt) space O(t)
