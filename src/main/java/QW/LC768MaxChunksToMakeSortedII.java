package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC768MaxChunksToMakeSortedII {
    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int large = arr[i];
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                large = Math.max(large, stack.pop());
            }
            stack.push(large);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));//4
    }
}
// time O(n) space O(n)
