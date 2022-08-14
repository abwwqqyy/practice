package QW;

public class LC357CountNumbersWithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int curNum = 9;
        int res = 10;
        int uniqueLeft = 9;
        for(int i = 2; i <= n; i++){
            curNum = curNum * uniqueLeft;
            res += curNum;
            uniqueLeft --;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3)); // 739
    }
}
