package QW;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1631PathWithMinimumEffort {
    private static int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dif = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] eachRow : dif){ // initialize reachable matrix
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        }
        dif[0][0] = 0;
        pq.offer(new int[]{0,0,dif[0][0]}); // (x,y,dif)

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            visited[cur[0]][cur[1]] = true;
            if(cur[0] == m - 1 && cur[1] == n - 1){
                return cur[2];
            }
            for(int[] d : dir){
                int nextX = cur[0] + d[0];
                int nextY = cur[1] + d[1];
                if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !visited[nextX][nextY]){
                    int curDif = Math.abs(heights[nextX][nextY] - heights[cur[0]][cur[1]]);
                    int maxDif = Math.max(curDif, dif[cur[0]][cur[1]]);
                    if(dif[nextX][nextY] > maxDif){
                        dif[nextX][nextY] = maxDif;
                        pq.offer(new int[]{nextX,nextY,maxDif});
                        // System.out.println(nextX + " " + nextY + " " + maxDif);
                    }
                }
            }
            // System.out.println(pq.toString());
        }
        return dif[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(minimumEffortPath(heights)); // 1
    }
}
// time O(mn log(mn)) space O(mn)
