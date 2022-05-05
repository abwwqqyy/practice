package QW;

public class LC701InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode child = new TreeNode();
        if(root.val < val){
            child = insertIntoBST(root.right, val);
            root.right = child;
        }else{
            child = insertIntoBST(root.left, val);
            root.left = child;

        }
        return root;
    }
}
