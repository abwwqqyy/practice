package QW;

public class LC538ConvertBSTToGreaterTree {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
// time O(n) space O(n)
