package QW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private static void dfs(int[] candidates, int target, int curSum, List<Integer> cur, List<List<Integer>> res){
        if(curSum > target) return;
        if(curSum == target){
            res.add(new ArrayList<>(cur));
        }
        for(int i = 0; i < candidates.length; i++){
            if(cur.size() == 0 || candidates[i] >= cur.get(cur.size() - 1)){
                cur.add(candidates[i]);
                dfs(candidates, target, curSum + candidates[i], cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,7};
        System.out.println(combinationSum(candidates, 7)); //[[2, 2, 3], [7]]
    }
}
