package QW;

import java.util.Arrays;

public class LC322CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;
        int INIT = 10001;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INIT);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == INIT ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins, 11)); // 3
    }
}
// time O(amount * n) space O(amount)
