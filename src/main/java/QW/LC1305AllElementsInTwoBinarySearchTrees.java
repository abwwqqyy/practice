package QW;

import java.util.ArrayList;
import java.util.List;

public class LC1305AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(root1, res1);
        inorder(root2, res2);
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < res1.size() + res2.size(); i++){
            if(c1 == res1.size() || c2 == res2.size()) break;
            int cur1 = res1.get(c1);
            int cur2 = res2.get(c2);
            if(cur1 < cur2){
                res.add(cur1);
                c1++;
            }else{
                res.add(cur2);
                c2++;
            }
        }
        if(c1 == res1.size()){
            while(c2 < res2.size()){
                res.add(res2.get(c2));
                c2++;
            }
        }else{
            while(c1 < res1.size()){
                res.add(res1.get(c1));
                c1++;
            }
        }
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
// time O(n + m) space O(m + n)
