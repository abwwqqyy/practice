package QW;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List< List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }

    private static void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(cur));
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));// [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] nums2 = new int[]{0};
        System.out.println(subsets(nums2));// [[],[0]]
    }
}
//time O(N*2^N) total 2^N subsets, each needs N
//space O(N)
