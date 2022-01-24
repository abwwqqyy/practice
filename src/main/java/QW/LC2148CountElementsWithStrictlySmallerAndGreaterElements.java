package QW;

import java.util.HashMap;
import java.util.Map;

public class LC2148CountElementsWithStrictlySmallerAndGreaterElements {
    public static int countElements(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        if(min == max){
            return 0;
        }else{
            return n - map.get(min) - map.get(max);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{11,7,2,15};
        int[] nums2 = new int[]{-3,3,3,90};
        System.out.println(countElements(nums1));//2
        System.out.println(countElements(nums2));//2
    }
}
//time O(n) space O(n)
