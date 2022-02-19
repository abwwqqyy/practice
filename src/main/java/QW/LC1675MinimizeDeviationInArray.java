package QW;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1675MinimizeDeviationInArray {
    // can only decrease even nums and increase odd nums, so double every odd nums then lower bound is fixed, then halve the largest to see the upper bound
    public static int minimumDeviation(int[] nums) {
        int n = nums.length;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int min = nums[0] * 2;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 != 0){
                nums[i] *= 2;
            }
            maxHeap.offer(nums[i]);
            min = Math.min(min, nums[i]);
        }
        // System.out.println(Arrays.toString(nums));
        while(maxHeap.peek() % 2 == 0){
            int cur = maxHeap.poll();
            res = Math.min(res, cur - min);
            maxHeap.offer(cur / 2);
            min = Math.min(min, cur / 2);
        }
        res = Math.min(res, maxHeap.peek() - min);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(minimumDeviation(nums));//1
    }
}
