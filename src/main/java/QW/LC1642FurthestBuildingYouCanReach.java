package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC1642FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if(n == 1) return 1;
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n - 1; i++){
            int dif = heights[i + 1] - heights[i];
            if(dif <= 0) continue;
            minHeap.offer(dif);

            if(minHeap.size() <= ladders){
                // System.out.println("i: " + i);
                continue;
            }
            // System.out.println("j: " + j);
            bricks -= minHeap.poll();;
            if(bricks < 0){
                return i;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        int[] heights = {4,12,2,7,3,18,20,3,19};
        System.out.println(furthestBuilding(heights, 10, 2));// 7
    }
}
// time O(nlogn) space O(n)
