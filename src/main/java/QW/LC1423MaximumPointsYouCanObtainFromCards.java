package QW;

public class LC1423MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = l + n - k - 1;
        int sum = 0;
        int windowSum = 0;
        for(int i : cardPoints){
            sum += i;
        }
        for(int i = 0; i <= r; i++){
            windowSum += cardPoints[i];
        }
        int curSum = windowSum;
        r++;
        while(r < n){
            curSum += cardPoints[r] - cardPoints[l];
            // System.out.println(curSum);
            windowSum = Math.min(windowSum, curSum);
            l++;
            r++;
        }
        return sum - windowSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints, 3));//12
    }
}
// time O(n) space O(1)
