package QW;

import java.util.ArrayList;
import java.util.List;

public class LC545BoundaryOfBinaryTree {
    // split into left bound, right bound and leaf
    private List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        lBound(root.left);
        leaf(root.left);
        leaf(root.right);
        rBound(root.right);
        return res;
    }
    private void lBound(TreeNode root){
        if(root == null || root.left == null && root.right == null){
            return;
        }
        res.add(root.val);
        if(root.left == null){
            lBound(root.right);
        }else{
            lBound(root.left);
        }
    }

    private void rBound(TreeNode root){
        if(root == null || root.left == null && root.right == null){
            return;
        }
        if(root.right == null){
            rBound(root.left);
        }else{
            rBound(root.right);
        }
        res.add(root.val);
    }
    private void leaf(TreeNode root){
        if(root == null ){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        leaf(root.left);
        leaf(root.right);
    }

}
// time O(n) space O(n)
