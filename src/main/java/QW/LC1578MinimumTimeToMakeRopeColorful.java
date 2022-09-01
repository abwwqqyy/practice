package QW;

public class LC1578MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int sum = neededTime[0];
        int max = neededTime[0];
        int res = 0;
        for(int i = 1; i < n; i++){
            int effort = neededTime[i];
            char cur = colors.charAt(i);
            if(cur == colors.charAt(i - 1)){
                sum += effort;
                max = Math.max(max, effort);
            }else{
                res += sum - max;
                sum = effort;
                max = effort;
            }
        }
        res += sum - max;
        return res;
    }

    public static void main(String[] args) {
        int[] time = new int[]{1,2,3,4,5};
        System.out.println(minCost("aabaa", time));// 5
    }
}
// time O(n) space O(1)
