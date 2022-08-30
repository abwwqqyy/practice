package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC1705MaximumNumberOfEatenApples {
    public static int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);// num, rot time pair
        int res = 0;
        for(int i = 0; i < n; i++){
            if(apples[i] != 0){
                pq.offer(new int[]{apples[i], days[i] + i});
            }
            while(!pq.isEmpty() && pq.peek()[1] <= i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                res ++;
                pq.peek()[0]--;
                if(pq.peek()[0] == 0) pq.poll();
            }
        }
        int day = n;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] > day){
                int num = Math.min(cur[1] - day, cur[0]);
                res += num;
                day += num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] apples = new int[]{1,2,3,5,2};
        int[] days = new int[]{3,2,1,4,2};
        System.out.println(eatenApples(apples, days)); // 7
    }
}
// time O(nlogn) space O(n)
