package QW;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1209RemoveAllAdjacentDuplicatesInStringII {
    public static String removeDuplicates(String s, int k) {
        int n = s.length();
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair(cur, 1));
                continue;
            }
            char prev = stack.peek().getKey();
            count = stack.peek().getValue();
            if(prev == cur){
                stack.push(new Pair(cur, ++count));
                if(count == k){
                    for(int j = 0; j < k; j++){
                        stack.pop();
                    }
                }
            }else{
                stack.push(new Pair(cur, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop().getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // aa
    }
}
// time O(n) space O(n)
