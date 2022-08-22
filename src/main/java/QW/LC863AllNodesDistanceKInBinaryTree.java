package QW;

import java.util.*;

public class LC863AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, null, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);
        int dist = 0;
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k){
                for(int i = 0; i < size; i++){
                    res.add(q.poll().val);
                }
                break;
            }
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                TreeNode p = parent.get(cur);
                if(p != null && !visited.contains(p.val)){
                    q.offer(p);
                    visited.add(p.val);
                }
                if(cur.left != null && !visited.contains(cur.left.val)){
                    q.offer(cur.left);
                    visited.add(cur.left.val);
                }
                if(cur.right != null && !visited.contains(cur.right.val)){
                    q.offer(cur.right);
                    visited.add(cur.right.val);
                }
            }
            dist++;
        }
        return res;
    }
    private void dfs(TreeNode root, TreeNode p, Map<TreeNode, TreeNode> parent){
        if(root == null){
            return;
        }
        parent.put(root, p);
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }
}
// time O(n) space O(n)
