package QW;

import java.util.LinkedList;
import java.util.Queue;

public class LC1293ShortestPathInAGridWithObstaclesElimination {

    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1 && grid[0][0] == 0) return 0;
        int[][] dirs = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,k});
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] d : dirs){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x == m - 1 && y == n - 1) {
                        return step + 1;
                    }
                    int limit = cur[2];
                    if(x < 0 || y < 0 || x >= m || y >= n ){
                        continue;
                    }
                    if(grid[x][y] == 1){
                        if(limit <= 0) continue;
                        else limit--;
                    }
                    if(visited[x][y][limit]) continue;
                    q.offer(new int[]{x, y, limit});
                    visited[x][y][limit] = true;
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1},{1,1,1},{1,0,0}};
        System.out.println(shortestPath(grid, 1)); // -1
    }
}
// time O(mnk) space O(mnk)