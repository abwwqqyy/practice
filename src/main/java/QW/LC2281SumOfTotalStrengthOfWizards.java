package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2281SumOfTotalStrengthOfWizards {
    // https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2062017/C%2B%2B-prefix-%2B-monotonic-stack-O(N)-solution-with-thought-process
    public static int totalStrength(int[] strength) {
        int n = strength.length;
        long res = 0;
        int MOD = (int) 1e9 + 7;
        long[] preSum = new long[n + 2];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = (preSum[i] + strength[i]) % MOD;
        }
        long[] prePreSum = new long[n + 2];
        for(int i = 0; i <= n; i++){
            prePreSum[i + 1] = (prePreSum[i] + preSum[i]) % MOD;
        }
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            while(!s1.isEmpty() && strength[s1.peek()] >= strength[i]){
                s1.pop();
            }
            left[i] = s1.isEmpty() ? -1 : s1.peek();
            s1.push(i);
        }
        for(int i = n - 1; i >= 0; i--){
            while(!s2.isEmpty() && strength[s2.peek()] > strength[i]){
                s2.pop();
            }
            right[i] = s2.isEmpty() ? n : s2.peek();
            s2.push(i);
        }
        // System.out.println(Arrays.toString(prePreSum));
        // System.out.println(Arrays.toString(right));
        for(int i = 0; i < n; i++){
            res += ((prePreSum[right[i] + 1] - prePreSum[i + 1]) % MOD * (i - left[i]) % MOD - (prePreSum[i + 1] - prePreSum[left[i] + 1]) % MOD * (right[i] - i) % MOD) * strength[i] % MOD;
            res %= MOD;
        }
        return (int) (res + MOD) % MOD;
    }

    public static void main(String[] args) {
        int[] strength = new int[]{1,3,1,2};
        System.out.println(totalStrength(strength)); // 44
    }
}
// time O(n) space O(n)
