package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC907SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        int MOD = (int)1e9 + 7;
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        int k = 0;

        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && arr[stack.peekLast()] > (i == n ? Integer.MIN_VALUE : arr[i])){
                j = stack.pollLast(); // j is curMin
                k = stack.isEmpty() ? -1 : stack.peekLast();
                res += (long) arr[j] * (i - j) * (j - k);
            }
            stack.offerLast(i);
        }
        return (int) (res%MOD);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,9,7,8,3,4,6,1};
        System.out.println(sumSubarrayMins(arr)); //117
    }
}
// time O(n) space O(n)

//The number of subarray we have for the array A with length n is (n + 1)*n/2
//
//              curMin
//                |
// Array: 2 9 7 8 3 4 6 1
// index: 0 1 2 3 4 5 6 7
//          |   |     |
//          --m----n--
//
// num of subarrays with curMin = (m + n - 1)(m + n)/2 - m(m - 1)/2 - n(n - 1)/2 = mn
