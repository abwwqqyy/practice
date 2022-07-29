package QW;

import java.util.HashMap;
import java.util.Map;

public class LC523ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return false;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(nums[0] % k, 0);
        m.put(0, -1);// override all
        for(int i = 1; i < n; i++){
            nums[i] = nums[i - 1] + nums[i];
            int mod = nums[i] % k;
            if(m.containsKey(mod)){
                int dif = i - m.get(mod);
                if(dif >= 2) {
                    return true;
                }
            }else{
                m.put(mod, i);
            }
            // System.out.println(m);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23,2,4,6,7};
        System.out.println(checkSubarraySum(nums, 6)); // true
        System.out.println(checkSubarraySum(nums, 19)); // false
    }
}
// time O(n) space O(k)
