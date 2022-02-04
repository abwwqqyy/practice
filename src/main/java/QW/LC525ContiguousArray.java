package QW;

import java.util.HashMap;
import java.util.Map;

public class LC525ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        Map<Integer, Integer> prefix = new HashMap<>(); //1 for +1 and 0 for -1
        prefix.put(0, -1);// begining sum 0 and index -1, record the first time of new sum
        int count = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            count = count + (nums[i] == 1 ? 1 : -1);
            if(prefix.containsKey(count)){
                res = Math.max(res, i - prefix.get(count));
            }else{
                prefix.put(count, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,0,1,1,1,0,0};
        System.out.println(findMaxLength(nums));//8
    }
}
// time O(n) space O(n)
