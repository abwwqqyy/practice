package QW;

public class LC2256MinimumAverageDifference {
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = nums[0];
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            preSum[i] = preSum[i - 1] + nums[i];
            sum += nums[i];
        }
        int res = -1;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(i == n - 1){
                if(min > preSum[i] / n){
                    min = preSum[i] / n;
                    res = i;
                }
                continue;
            }
            long cur = Math.abs(preSum[i] / (i + 1) - (sum - preSum[i]) / (n - i - 1));
            if(min > cur){
                min = cur;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,3,9,5,3};
        System.out.println(minimumAverageDifference(nums)); // 3
    }
}
// time O(n) space O(n)
