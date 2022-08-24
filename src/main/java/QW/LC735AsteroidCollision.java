package QW;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC735AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int cur = asteroids[i];
            int large = cur;
            while(!stack.isEmpty() && stack.peek() > 0 && cur < 0){
                int top = stack.pop();
                if(Math.abs(top) < Math.abs(cur)){
                    large = cur;
                }else if(Math.abs(top) > Math.abs(cur)){
                    large = top;
                    break;
                }else{
                    large = 0;
                    break;
                }
            }
            if(large != 0){
                stack.push(large);
            }
        }
        int m = stack.size();
        int[] res = new int[m];
        for(int i = m - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-1,2};
        System.out.println(Arrays.toString(asteroidCollision(nums))); // [1,2]
    }
}
// time O(n) space O(n)
