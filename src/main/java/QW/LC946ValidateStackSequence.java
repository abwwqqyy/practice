package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC946ValidateStackSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i < n; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }
        return idx == n;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped1 = new int[]{4,5,3,2,1};
        int[] popped2 = new int[]{4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, popped1));//true
        System.out.println(validateStackSequences(pushed,popped2));//false
    }
}
// time O(N) space O(N)
