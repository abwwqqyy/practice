package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC388LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int n = arr.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0); //dummy length
        int res = 0;
        for(int i = 0; i < n; i++){
            String cur = arr[i];
            int numTab = cur.lastIndexOf("\t") + 1;
            int level = numTab + 1;// level of indentation starting at 1.
            while(level < stack.size()){
                stack.pop();
            }
            int curLen = stack.peek() + cur.length() - numTab + 1; //add '/'
            stack.push(curLen);
            if(cur.contains(".")){
                res = Math.max(res, curLen - 1); // remove last '/'
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")); // 20
    }
}
// time O(n) space O(n)
