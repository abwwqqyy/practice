package QW;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC272ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deq = new LinkedList<>();
        inorder(root, target, k, deq);
        return new ArrayList<>(deq);
    }
    private void inorder(TreeNode root, double target, int k, Deque<Integer> deq){
        if(root == null) return;
        inorder(root.left, target, k, deq);
        if(deq.size() == k){
            if(Math.abs(deq.peekFirst() - target) > Math.abs(target - root.val)){
                deq.removeFirst();
                deq.addLast(root.val);
            }else{
                return;
            }
        }else{
            deq.addLast(root.val);
        }
        inorder(root.right, target, k, deq);
    }
}
// time O(n) space O(k)
