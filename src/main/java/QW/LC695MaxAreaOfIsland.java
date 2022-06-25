package QW;

import java.util.LinkedList;
import java.util.Queue;

public class LC695MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] dirs = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int curSize = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] d : dirs){
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];
                            if(x < 0 || y < 0 || x>= m || y >= n || grid[x][y] != 1){
                                continue;
                            }
                            q.offer(new int[]{x, y});
                            grid[x][y] = 0;
                            curSize ++;
                        }
                    }
                    res = Math.max(curSize, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid)); // 6
    }
}

