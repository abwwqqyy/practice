package QW;

import java.util.HashMap;
import java.util.Map;

public class LC560SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();// (prefixSum, occurrence)
        m.put(0, 1); // one occurrence of a subarray sum 0
        int prefixSum = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            if(m.containsKey(prefixSum - k)){
                res += m.get(prefixSum - k);
            }
            m.put(prefixSum, m.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,4,7,2,-3,1,4,2};
        System.out.println(subarraySum(nums1, 7));//4
        int[] nums2 = new int[]{2,2,2};
        System.out.println(subarraySum(nums2, 4));//2
    }
}
// time O(n) space O(n)
