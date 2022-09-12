package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC1696JumpGameVI {
    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peekFirst()] + nums[i];
            // pop the smaller value
            while (!dq.isEmpty() && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,-1,-100,-1,100};
        System.out.println(maxResult(nums,2));//198
    }
}
// time O(n) space O(n)
