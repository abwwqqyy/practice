package QW;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC632SmallestRangeCoveringElementsFromKLists {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int left = 0;
        int right = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            minHeap.offer(new int[]{i, 0});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }

        while(minHeap.size() == n){
            int[] cur = minHeap.poll();
            int row = cur[0];
            int col = cur[1];
            int curNum = nums.get(row).get(col);
            if(right - left > curMax - curNum){
                right = curMax;
                left = curNum;
            }
            if(col + 1 < nums.get(row).size()){
                minHeap.offer(new int[]{row, col + 1});
                curMax = Math.max(curMax, nums.get(row).get(col + 1));
            }
        }
        return new int[]{left, right};
    }
}
// time O(nm logn) space O(n)
