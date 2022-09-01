package QW;

public class LC1775EqualSumArraysWithMinimumNumberOfOperations {
    public static int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] c1 = new int[7];
        int[] c2 = new int[7];
        int sum1 = 0;
        int sum2 = 0;
        for(int i : nums1){
            c1[i]++;
            sum1 += i;
        }
        for(int i : nums2){
            c2[i]++;
            sum2 += i;
        }
        int res = 0;
        if(sum2 == sum1) return res;
        if(sum2 > sum1){ // sum1 > sum2
            int temp = sum1;
            sum1 = sum2;
            sum2 = temp;
            int[] c3 = c1;
            c1 = c2;
            c2 = c3;
        }
        // System.out.println(sum1 +"  " + sum2);
        for(int i = 1; i <= 6; i++){
            while(c1[7 - i]-- > 0){
                sum1 -= 6 - i;
                res++;
                if(sum1 <= sum2) return res;
            }
            while(c2[i]-- > 0){
                sum2 += 6 - i;
                res++;
                if(sum1 <= sum2) return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6};
        int[] nums2 = new int[]{1,1,2,2,2,2};
        System.out.println(minOperations(nums1, nums2)); // 3
    }
}
// time O(n) space O(1)
