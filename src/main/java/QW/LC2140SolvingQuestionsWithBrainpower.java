package QW;

public class LC2140SolvingQuestionsWithBrainpower {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for(int i = 1; i < n; i++){
            int index = n - i - 1;
            if(questions[index][1] + index + 1 >= n){ //can only be the last one
                dp[index] = Math.max(questions[index][0], dp[index + 1]);
            }else{
                dp[index] = Math.max(questions[index][0] + dp[index + questions[index][1] + 1], dp[index + 1]);
            }
            //System.out.println(index+ " : " +dp[index]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] questions1 = new int[][]{{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions1));//5
        int[][] questions2 = new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints(questions2));//7
    }
}
