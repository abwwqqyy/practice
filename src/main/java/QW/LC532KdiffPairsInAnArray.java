package QW;

import java.util.HashMap;
import java.util.Map;

public class LC532KdiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        //putting num and their counts
        for(int i = 0; i < n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for(int i : m.keySet()){
            int count = m.get(i);
            if(k != 0 && m.containsKey(i + k)){// find larger ones
                res++;
            }else if(k == 0 && count > 1){// itself
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        System.out.println(findPairs(nums1, 1)); //4
        int[] nums2 = new int[]{1,2,5,3,2,3};
        System.out.println(findPairs(nums2, 0));//2
    }
}
// time O(n) space O(n)
