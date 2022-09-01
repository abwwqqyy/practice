package QW;

public class LC1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int res = 0;
        for(int i = n - 1; i > 0; i--){
            char c = s.charAt(i);
            if(c == '0'){
                res++;
                if(carry == 1){
                    res++;
                }
            }else{
                if(carry == 0){
                    res += 2;
                    carry = 1;
                }else{
                    res ++;
                }
            }
        }
        if(carry == 1) res += 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101")); //6
    }
}
// time O(n) space O(1)
