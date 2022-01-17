package QW;

public class LC902NumbersAtMostNGivenDigitSet {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;//initialize for the case dp[len - 1]

        for(int i = len - 1; i >= 0; i--){
            int cur = s.charAt(i) - '0';
            for(String si : digits){ // fix the first digit, and count the rest
                if(Integer.valueOf(si) < cur){ //smaller than cur digit
                    dp[i] += Math.pow(digits.length, len - i - 1);
                }else if(Integer.valueOf(si) == cur){
                    dp[i] += dp[i + 1];
                }
            }
        }
        for(int i = 1; i < len; i++){
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String[] digits = new String[]{"1","3","5","7"};
        System.out.println(atMostNGivenDigitSet(digits, 100)); //20
        String[] digits2 = new String[] {"1","4","9"};
        System.out.println(atMostNGivenDigitSet(digits2,1000000000));//29523
    }
}
// time O(logn) space O(logn)
