package QW;

public class LC333LargestBSTSubtree {
    // return array for each node:
//     [0] --> min
//     [1] --> max
//     [2] --> largest BST in its subtree(inclusive)

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        int[] res = dfs(root);
        return res[2];
    }
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // so parent must be BST
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if(root.val > left[1] && root.val < right[0]){
            return new int[]{Math.min(left[0], root.val), Math.max(root.val, right[1]), left[2] + right[2] + 1};
        }

        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}; // so parent must not be BST and store current max subtree
    }
}
// time O(n) space O(h)
