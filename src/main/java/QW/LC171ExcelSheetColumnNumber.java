package QW;

public class LC171ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        int base = 1;
        for(int i = n - 1; i >= 0; i--){
            char cur = columnTitle.charAt(i);
            res += (cur - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        String title1 = "A";
        String title2 = "AB";
        String title3 = "ZY";
        System.out.println(titleToNumber(title1));//1
        System.out.println(titleToNumber(title2));//28
        System.out.println(titleToNumber(title3));//701
    }
}
//time O(n) space O(1)
