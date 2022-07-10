package QW;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC973KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        int n = points.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(kClosest(points, 2))); // [[3,3],[-2,4]]
    }
}
// time O(nlogk) space O(k)
