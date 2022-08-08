package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2104SumOfSubarrayRanges {
    //我们考虑每个元素成为了多少个区间的最大值，还有多少个区间的最小值。前者的数量就是该元素在累计求和中被加的次数，后者则是被减的次数
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        Deque<Integer> minStack = new ArrayDeque<Integer>();
        Deque<Integer> maxStack = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++){
            while(!minStack.isEmpty() && nums[minStack.peek()] > nums[i]){
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            while(!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]){
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]){
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);

            while(!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]){
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }
        long res = 0;
        for(int i = 0; i < n; i++){
            res += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            res -= (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(subArrayRanges(nums)); // 3
    }
}
// time O(n) space O(n)
