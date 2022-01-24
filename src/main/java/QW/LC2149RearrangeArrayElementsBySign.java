package QW;

import java.util.Arrays;

public class LC2149RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int i = 0;
        int j = 0;
        for(int c = 0; c < n; c++){
            if(nums[c] > 0){
                pos[i] = nums[c];
                i++;
            }else{
                neg[j] = nums[c];
                j++;
            }
        }
        int[] res = new int[n];
        for(int c = 0; c < n/2; c++){
            res[2 * c] = pos[c];
            res[2 * c + 1] = neg[c];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));//[3, -2, 1, -5, 2, -4]
    }
}
// time O(n) space O(n)
