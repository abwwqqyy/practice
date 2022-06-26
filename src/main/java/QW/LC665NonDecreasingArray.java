package QW;

public class LC665NonDecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2) return true;
        int count = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                count++;
                if(i < 2 || nums[i - 2] <= nums[i]){
                    // nums[i - 1] = nums[i]; // don't have to do this
                }else{
                    nums[i] = nums[i - 1];
                }
            }
            if(count > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,3};
        System.out.println(checkPossibility(nums)); // false
    }
}
