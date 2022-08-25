package QW;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2163MinimumDifferenceInSumsAfterRemovalOfElements {
    public static long minimumDifference(int[] nums) {
        int n = nums.length;
        int m = n / 3;
        long[] dp = new long[m * 2];
        long pre_sum = 0L;
        long suf_sum = 0L;
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 2 * m; i++){
            maxHeap.offer(nums[i]);
            pre_sum += nums[i];
            if(maxHeap.size() > m){
                pre_sum -= maxHeap.poll();
            }
            dp[i] = pre_sum;
        }
        long res = Long.MAX_VALUE;
        for(int i = n - 1; i >= m; i--){
            minHeap.offer(nums[i]);
            suf_sum += nums[i];
            if(minHeap.size() > m){
                suf_sum -= minHeap.poll();
            }
            // System.out.println(suf_sum);
            if(i <= 2 * m){
                res = Math.min(res, dp[i - 1] - suf_sum);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,9,5,8,1,3};
        System.out.println(minimumDifference(nums)); // 1
    }
}
// time O(nlogn) space O(n)
