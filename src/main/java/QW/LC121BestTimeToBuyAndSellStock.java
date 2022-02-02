package QW;

public class LC121BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int res = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > min){
                res = Math.max(res, prices[i] - min);
            }else{
                min = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices1 = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,5,4,3,1};
        System.out.println(maxProfit(prices1));//5
        System.out.println(maxProfit(prices2));//0
    }
}
// time O(n) space O(1)
