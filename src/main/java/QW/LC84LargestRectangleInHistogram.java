package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC84LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int maxA = 0;
        int i = 0;
        while(i < n){
            //System.out.println(i);
            while(i < n && !stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int idx = stack.pop();
                int width = stack.isEmpty()? i : i - stack.peek() - 1; // look at previous pos in the stack and multiply by the height popped
                int area = heights[idx] * width;
                maxA = Math.max(maxA, area);
                //System.out.println(maxA);
            }
            stack.push(i);
            i++;
        }
        //System.out.println(stack.peek());
        while(!stack.isEmpty()){
            int idx = stack.pop();
            int width = stack.isEmpty()? i : i - stack.peek() - 1; // look at previous pos in the stack and multiply by the height popped
            int area = heights[idx] * width;
            maxA = Math.max(maxA, area);
            //System.out.println(maxA);
        }
        return maxA;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights)); // 10
    }
}
// time O(n) space O(n)
