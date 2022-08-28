package QW;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        else if(n == 1) return 1;
        int[][] dirs = new int[][]{{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] d : dirs){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1 || visited[x][y]){
                        continue;
                    }
                    if(x == n - 1 && y == n - 1){
                        return res + 1;
                    }
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid)); //4
    }
}
// time O(n*n) space O(n*n)
