package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC871MinimumNumberOfRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        if(startFuel >= target) return 0;
        if(stations == null || stations.length == 0 || startFuel < stations[0][0]) return -1;
        int[][] range = new int[n][3];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int pos = startFuel;
        int index = 0;
        int stop = 1;
        while(pos < target){
            while(index < n){
                if(stations[index][0] <= pos){
                    pq.offer(stations[index]);
                }else{
                    break;
                }
                index++;
            }
            if(pq.isEmpty()) break;
            int[] next = pq.poll();
            // System.out.println(pos + "  " + next[1] + "  " + index);
            pos += next[1];
            if(pos >= target){
                return stop;
            }

            stop++;
        }
        if(pos < target) return -1;
        return stop;
    }

    public static void main(String[] args) {
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        System.out.println(minRefuelStops(100,10,stations));//2
    }
}
// time O(nlogn) space O(n)
