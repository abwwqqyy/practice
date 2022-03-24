package QW;

public class LC1663SmallestStringWithAGivenNumericValue {
    public static String getSmallestString(int n, int k) {
        int m = k - n; //values can be distributed
        StringBuilder res = new StringBuilder();
        int numZ = m / 25;
        int residue = m % 25;
        for(int i = 0; i < n; i++){
            if(i < n - 1 - numZ){
                res.append('a');
            }else if(i == n - 1 - numZ){
                res.append((char)('a' + residue));
            }else{
                res.append('z');
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3,27));//aay
        System.out.println(getSmallestString(5,73));//aaszz
    }
}
