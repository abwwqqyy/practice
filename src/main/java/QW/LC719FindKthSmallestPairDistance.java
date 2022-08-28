package QW;

import java.util.Arrays;

public class LC719FindKthSmallestPairDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n - 1] - nums[0];
        while(low < high){
            int mid = (low + high) / 2;
            int count = 0;
            int l = 0;
            for(int r = 0; r < n; r++){
                while(l < r && nums[r] - nums[l] > mid) l++;
                count += r - l;
            }
            if(count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,6,1};
        System.out.println(smallestDistancePair(nums, 3)); // 5
    }
}
// time O(nlogn + wlogn) space O(1)
