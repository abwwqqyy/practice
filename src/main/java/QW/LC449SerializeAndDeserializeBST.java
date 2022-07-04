package QW;

import java.util.LinkedList;
import java.util.Queue;

public class LC449SerializeAndDeserializeBST {
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val);
        sb.append(',');
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preorder(root, res);
        if(res.length() > 0){
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    private TreeNode construct(Queue<Integer> q, int low, int high){
        if(q.isEmpty()) return null;
        int val = q.peek();
        if(val < low || val > high) return null;
        q.poll();
        TreeNode cur = new TreeNode(val);
        cur.left = construct(q, low, val);
        cur.right = construct(q, val, high);
        return cur;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<Integer> q = new LinkedList<>();
        for(String s : data.split(",")){
            q.offer(Integer.parseInt(s));
        }
        return construct(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
// time O(n) space O(n)
