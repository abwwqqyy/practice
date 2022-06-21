package QW;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.util.*;

public class LC317ShortestDistanceFromAllBuildings {
    public static int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n]; // keep distance
        int[][] visited = new int[m][n];// value equals to num of buildings reachable - 1
        List<int[]> buildings = new ArrayList<>();
        int[][] dir = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
        for(int i = 0; i < m; i ++){
            Arrays.fill(visited[i], -1);// initialize to -1
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    buildings.add(new int[]{i, j});// add buildings
                }
            }
        }
        for(int i = 0; i < buildings.size(); i++){
            Queue<int[]> q = new LinkedList<>();
            q.add(buildings.get(i));
            int curDis = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int j = 0; j < size; j++){
                    int[] cur = q.poll();
                    for(int[] d : dir){
                        int x = cur[0] + d[0];
                        int y = cur[1] + d[1];
                        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 0 || visited[x][y] != i - 1){
                            continue;
                        }
                        visited[x][y] = i;
                        dis[x][y] += curDis + 1;
                        q.add(new int[]{x, y});
                    }
                }
                curDis++;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] != buildings.size() - 1){ // skip undesired spaces
                    continue;
                }
                res = Math.min(res, dis[i][j]);
            }
        }
        // System.out.println(Arrays.deepToString(visited));
        // System.out.println(Arrays.deepToString(dis));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(shortestDistance(grid)); // 7
    }
}
// time O(m^2*n^2) space O(mn)
