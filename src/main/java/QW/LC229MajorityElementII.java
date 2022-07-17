package QW;

import java.util.ArrayList;
import java.util.List;

public class LC229MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int n =nums.length;
        int c1 = 0;
        int c2 = 0;
        Integer val1 = null;
        Integer val2 = null;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(val1 != null && val1 == nums[i]){
                c1++;
            }else if(val2 != null && val2 == nums[i]){
                c2++;
            }else if(c1 == 0){
                val1 = nums[i];
                c1++;
            }else if(c2 == 0){
                val2 = nums[i];
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i : nums){
            if(val1 != null && i == val1) c1++;
            if(val2 != null && i == val2) c2++;
        }
        if(c1 > n/3) res.add(val1);
        if(c2 > n/3) res.add(val2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,1};
        System.out.println(majorityElement(nums)); //[2,3]
    }
}
// time O(n) space O(1)
