package QW;

import java.util.*;

public class LC1834SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        Queue<int[]> sorted = new PriorityQueue<>((a,b) -> a[1] == b[1] ? (a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]) : a[1] - b[1]); // idx, enque time, duration
        for(int i = 0; i < n; i++){
            sorted.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        int time = 0;
        List<Integer> res = new ArrayList<>();
        while(!sorted.isEmpty()){
            while(!sorted.isEmpty() && sorted.peek()[1] <= time){
                pq.offer(sorted.poll());
            }
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                time += cur[2];
                res.add(cur[0]);
            }else{
                time = sorted.peek()[1];
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }
        int[] ret = new int[n];
        for(int i = 0; i < n; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] tasks = new int[][]{{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(tasks))); //[0,2,3,1]
    }
}
// time O(nlogn) space O(n)
