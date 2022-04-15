package QW;

public class LC669TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;
        while(root != null){
            if(root.val < low){
                root = root.right;
            }else if(root.val > high){
                root = root.left;
            }else{
                traverse(root.left, root, low, high);
                traverse(root.right, root, low, high);
                break;
            }
        }
        return root;
    }
    private void traverse(TreeNode root, TreeNode parent, int low, int high){
        if(root == null) return;
        TreeNode newParent = root;
        if(root.val < low){
            parent.left = root.right;
            newParent = parent;
            traverse(root.right, newParent, low, high);
        }else if(root.val > high){
            parent.right = root.left;
            newParent = parent;
            traverse(root.left, newParent, low, high);
        }else{
            traverse(root.left, newParent, low, high);
            traverse(root.right, newParent, low, high);
        }
    }
}
