package QW;

public class LC256PaintHouse {
    public static int minCost(int[][] costs) {
        int m = costs.length;
        int[] prev = new int[3];
        for(int i = 1; i <= m; i++){
            int[] cur = new int[3];
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    cur[j] = Math.min(prev[1], prev[2]) + costs[i - 1][j];
                }else if(j == 1){
                    cur[j] = Math.min(prev[0], prev[2]) + costs[i - 1][j];
                }else{
                    cur[j] = Math.min(prev[0], prev[1]) + costs[i - 1][j];
                }
            }
            prev = cur;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs)); // 10
    }
}
// time O(m) space O(1)
