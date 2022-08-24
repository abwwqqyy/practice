package QW;

import java.util.ArrayList;
import java.util.List;

public class LC2100FindGoodDaysToRobTheBank {
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[][] dp = new int[n][2];

        for(int i = 1; i < n; i++){
            if(security[i] <= security[i - 1]){
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(security[i] <= security[i + 1]){
                dp[i][1] = dp[i + 1][1] + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dp[i][0] >= time && dp[i][1] >= time){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] security = new int[]{5,3,3,3,5,6,2};
        System.out.println(goodDaysToRobBank(security, 2)); // [2,3]
    }
}
// time O(n) space O(n)
