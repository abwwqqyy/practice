package QW;

public class LC688KnightProbabilityInChessboard {
    public static double knightProbability(int n, int k, int row, int col) {
        double[][] prev = new double[n][n]; // probability at pos
        prev[row][col] = 1.0;
        int[][] dirs = new int[][]{{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
        for(int m = 0; m < k; m++){
            double[][] cur = new double[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(Double.compare(prev[i][j], 0) == 0){
                        continue;
                    }
                    for(int[] d : dirs){
                        int x = d[0] + i;
                        int y = d[1] + j;
                        if(x < 0 || y < 0 || x >= n || y >= n){
                            continue;
                        }
                        cur[x][y] += prev[i][j] / 8.0;
                    }
                }
            }
            prev = cur;
        }
        double res = 0.0;
        for(double[] i : prev){
            for(double j : i){
                res += j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3,2,0,0)); // 0.0625
    }
}
// time O(n^2*k) space O(n^2)
