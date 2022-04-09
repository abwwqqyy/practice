package QW;

import java.util.*;

public class LC347TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : nums){
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i : m.keySet()){
            minHeap.offer(new int[]{i, m.get(i)});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            res[idx] = cur[0];
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,4};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));//[1,2] or [2,1]
    }
}
// time O(nlogn) space O(k)
