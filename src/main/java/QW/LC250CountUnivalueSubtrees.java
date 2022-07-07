package QW;

public class LC250CountUnivalueSubtrees {
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // if(root == null) return 0;
        dfs(root);
        return res;
    }
    private boolean dfs(TreeNode root){
        if(root == null) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(left && right){
            if(root.left == null && root.right == null || root.left == null && root.right.val == root.val || root.right == null && root.left.val == root.val || root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val  ){
                res ++;
                return true;
            }
        }
        // System.out.println(res);
        return false;
    }
}
// time O(n) space O(n)
