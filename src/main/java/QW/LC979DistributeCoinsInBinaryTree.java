package QW;

public class LC979DistributeCoinsInBinaryTree {
    private static int res = 0;
    public static int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    private static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int require = Math.abs(left) + Math.abs(right);
        res += require;
        return left + right + root.val - 1;
    }
}
