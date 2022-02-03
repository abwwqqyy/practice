package QW;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.util.HashMap;
import java.util.Map;

public class LC4544SumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer,Integer> m1 = new HashMap<>(); // for nums1,2
        Map<Integer,Integer> m2 = new HashMap<>(); // for nums3,4
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num1 = nums1[i] + nums2[j];
                int num2 = nums3[i] + nums4[j];
                int c1 = m1.getOrDefault(num1, 0);
                m1.put(num1, c1 + 1);
                int c2 = m2.getOrDefault(num2, 0);
                m2.put(num2, c2 + 1);
            }
        }
        for(int i : m1.keySet()){
            if(m2.containsKey(-i)){
                res += m1.get(i) * m2.get(-i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2}, nums2 = new int[]{-2,-1}, nums3 = new int[]{-1,2}, nums4 = new int[]{0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));//2
    }
}
// time O(n^2) space O(n^2)
