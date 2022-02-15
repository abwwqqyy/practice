package QW;

public class LC136SingleNumber {
    public static int singleNumber(int[] nums) {
        int mask = 0;
        for(int i : nums){
            mask ^= i; // XOR self = 0
        }
        return mask;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,1,2};
        System.out.println(singleNumber(nums));//3
    }
}
// time O(n) space O(1)
