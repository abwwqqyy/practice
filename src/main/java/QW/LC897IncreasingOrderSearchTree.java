package QW;

public class LC897IncreasingOrderSearchTree {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode();
        cur = res;
        inorder(root);
        return res.right;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        root.left = null;// reset
        cur.right = root;
        cur = root;
        // System.out.println(cur.val);
        inorder(root.right);
    }
}
