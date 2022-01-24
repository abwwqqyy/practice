package QW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2150FindAllLonelyNumbersInTheArray {
    public static List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < n; i++){
            if(m.get(nums[i]) == 1 && !m.containsKey(nums[i] - 1) && !m.containsKey(nums[i] + 1)){
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{10,6,5,8};
        int[] nums2 = new int[]{1,3,5,3};
        System.out.println(findLonely(nums1));//[10,8]
        System.out.println(findLonely(nums2));//[1,5]
    }
}
// time O(n) space O(n)
