package QW;

public class LC1567MaximumLengthOfSubarrayWithPositiveProduct {
    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        int res = 0;
        int pos = 0;
        int neg = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                int temp = pos;
                pos = neg == 0 ? 0 : neg + 1;
                neg = temp + 1;
            }else if(nums[i] > 0){
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            }else{
                pos = 0;
                neg = 0;
            }
            res = Math.max(res, pos);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,-2,-3,-4};
        System.out.println(getMaxLen(nums));//3
    }
}
// time O(n) space O(1)
