package QW;

public class LC285InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}
// time O(n) space O(1)
