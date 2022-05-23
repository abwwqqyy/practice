package QW;

public class LC474OnesAndZeros {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int[] count = getNumber(s);
            for(int i = m; i >= count[0]; i--){
                for(int j = n; j >= count[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    private static int[] getNumber(String s){
        int[] res = new int[2];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                res[0]++;
            }else{
                res[1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs, 5, 3)); // 4
    }
}
// time O(mnl) space O(mn)
