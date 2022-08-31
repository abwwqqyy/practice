package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC1405LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int prev = -1;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        pq.offer(new int[]{0, a});
        pq.offer(new int[]{1, b});
        pq.offer(new int[]{2, c});
        int same = 0;
        for(int i = 0; i < a + b + c; i++){
            while(!pq.isEmpty() && pq.peek()[1] <= 0){
                pq.poll();
            }
            if(pq.isEmpty()){
                break;
            }
            if(same < 2){
                int[] cur = pq.poll();
                if(prev != cur[0]){
                    same = 1;
                }else{
                    same++;
                }
                res.append((char)(cur[0] + 'a'));
                prev = cur[0];
                if(cur[1] > 0){
                    pq.offer(new int[]{cur[0], cur[1] - 1});
                }
            }else{
                int[] cur = pq.poll();
                if(cur[0] == prev){
                    while(!pq.isEmpty() && pq.peek()[1] <= 0){
                        pq.poll();
                    }
                    if(pq.isEmpty()){
                        break;
                    }
                    int[] next = pq.poll();
                    same = 1;
                    res.append((char)(next[0] + 'a'));
                    prev = next[0];
                    if(next[1] > 0){
                        pq.offer(new int[]{next[0], next[1] - 1});
                    }
                    pq.offer(cur);
                }else{
                    same = 1;
                    res.append((char)(cur[0] + 'a'));
                    prev = cur[0];
                    if(cur[1] > 0){
                        pq.offer(new int[]{cur[0], cur[1] - 1});
                    }
                }

            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7)); //ccaccbcc
    }
}
// time O(n) space O(n)
