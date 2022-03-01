package QW;

import java.util.Arrays;

public class LC338CountingBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 1; x <= n; ++x) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[x] = ans[x >> 1] + (x & 1);
        }
        return ans;
    }

    // x & (x + 1) always removes the least significant bit
    // public int[] countBits(int num) {
    //     int[] ans = new int[num + 1];
    //     for (int x = 1; x <= num; ++x) {
    //         ans[x] = ans[x & (x - 1)] + 1;
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5))); //[0,1,1,2,1,2]
    }
}
//time O(n) space O(1)
