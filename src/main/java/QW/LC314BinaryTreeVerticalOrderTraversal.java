package QW;

import java.util.*;

public class LC314BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        q.offer(root);
        p.offer(0);
        int minInd = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int curInd = p.poll();
            List<Integer> curList = map.getOrDefault(curInd, new ArrayList<>());
            curList.add(cur.val);
            map.put(curInd, curList);
            if(cur.left != null){
                p.offer(curInd - 1);
                q.offer(cur.left);
                minInd = Math.min(minInd, curInd - 1);
            }
            if(cur.right != null){
                p.offer(curInd + 1);
                q.offer(cur.right);
            }
        }
        // System.out.println(map);
        while(true){
            List<Integer> resList = map.get(minInd);
            if(resList == null) break;
            res.add(resList);
            minInd ++;
        }
        return res;
    }
}
// time O(n) space O(n)
