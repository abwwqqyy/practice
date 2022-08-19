package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();
        int res = 1;
        int l = 0;
        int r = 0;
        for(r = 0; r < n; r++){
            while(!minq.isEmpty() && nums[minq.peekLast()] >= nums[r]) minq.pollLast();
            while(!maxq.isEmpty() && nums[maxq.peekLast()] <= nums[r]) maxq.pollLast();
            minq.offerLast(r);
            maxq.offerLast(r);
            while(nums[maxq.peekFirst()] - nums[minq.peekFirst()] > limit){
                if(minq.peekFirst() == l) minq.pollFirst();
                if(maxq.peekFirst() == l) maxq.pollFirst();
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,4,7,2};
        System.out.println(longestSubarray(nums, 5)); //4
    }
}
// time O(n) space O(n)
