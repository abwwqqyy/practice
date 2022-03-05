package QW;

import java.util.*;

public class LC740DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        int maxNum = nums[0];
        for(int i = 0; i < n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + nums[i]);
            maxNum = Math.max(maxNum, nums[i]); // get the largest element
        }
        List<Integer> element = new ArrayList<>(m.keySet());
        Collections.sort(element);

        int prevTwo = 0;
        int prev = m.get(element.get(0));// initialize

        for(int i = 1; i < element.size(); i++){
            int cur = element.get(i);
            int temp = prev; // store it
            if(cur == element.get(i - 1) + 1){
                prev = Math.max(prev, prevTwo + m.get(cur)); //prev also serves as cur max profit
            }else{
                prev += m.get(cur);
            }
            prevTwo = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 5, 4, 3, 5, 3};
        System.out.println(deleteAndEarn(nums));//21
    }
}
//time O(nlogn) space O(n)
