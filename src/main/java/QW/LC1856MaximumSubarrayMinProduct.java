package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1856MaximumSubarrayMinProduct {
    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n+1];
        for(int i = 0; i < n; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        long res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                int min = nums[stack.pop()];
                int index = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (preSum[i] - preSum[index+1]) * min);
            }
            stack.push(i);
        }
        // System.out.println(res + "  " + stack);
        while(!stack.isEmpty()){
            int min = nums[stack.pop()];
            int index = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (preSum[n] - preSum[index + 1]) * min);
        }

        // System.out.println(res+ "  " + (Long.MAX_VALUE - res));
        // System.out.println((1e9 + 7) + "   " + 1000000007 + "   " + (1e9 + 7 - 1000000007));

//         System.out.println((int) (9589449447959645L % (1e9 + 7)));
//         System.out.println((int) (9589449447959645L % (int)(1e9 + 7)));

//         System.out.println((int) (9589449447959646L % (1e9 + 7)));
//         System.out.println((int) (9589449447959646L % (int)(1e9 + 7)));

        return (int) (res % (int)(1e9 + 7));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,1,2};
        System.out.println(maxSumMinProduct(nums)); // 18
    }

}
// time O(n) space O(n)
