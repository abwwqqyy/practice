package QW;

import java.util.ArrayList;
import java.util.List;

public class LC296BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);
        return getDistance1D(rows) + getDistance1D(cols);

    }
    // calculate distance in 1D
    private static int getDistance1D(List<Integer> pos){
        int l = 0;
        int r = pos.size() - 1;
        int res = 0;
        while(l < r){
            res += pos.get(r) - pos.get(l);
            l++;
            r--;
        }
        return res;
    }
    // get rows and cols in order
    private static List<Integer> getRows(int[][] grid){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res.add(i);
                }
            }
        }
        return res;
    }
    private static List<Integer> getCols(int[][] grid){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 1){
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(minTotalDistance(grid)); // 6
    }
}
// time O(mn) space O(mn)
