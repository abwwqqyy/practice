package QW;

import java.util.HashSet;
import java.util.Set;

public class LC1012NumbersWithRepeatedDigits {
//  Case 1 :  n = 3 4 6 5
// 	pivot index i = 0 should < 3                                                <==> {1, 2}
// 					1 X X X - 2 X X X    ==>  2 * 9 * 8 * 7
//     pivot index i = 1 should < 4  and not take values of previous indices       <==> {0, 1, 2}
// 					3 0 X X - 3 3 X X    ==>  1 * 3 * 8 * 7
// 	pivot index i = 2 should < 6  and not take values of previous indices       <==> {0, 1, 2, 5}
// 					3 4 0 X - 3 4 5 X    ==>  1 * 1 * 4 * 7
//     pivot index i = 3 should < 5  and not take values of previous indices       <==> {0, 1, 2}
// 					3 4 6 0 - 3 4 6 5    ==>  1 * 1 * 1 * 3

// Case 2 :  n = 3 3 5 3
// 	pivot index i = 0 should < 3                                                <==> {1, 2}
// 					1 X X X - 2 X X X    ==>  2 * 9 * 8 * 7
// 	pivot index i = 1 should < 3  and not take values of previous indices       <==> {0, 1, 2}
// 					3 0 X X - 3 2 X X    ==>  1 * 3 * 8 * 7
// 	pivot index i = 2  and after should not be consider
// 					3 3 X X              ==>  0  the number will contain repeated digits

    public static int numDupDigitsAtMostN(int n) {
        int res = 0;
        String str = String.valueOf(n);
        int len = str.length();
        // count num with digits < len
        for(int i = 1; i < len; i++){
            res += countNumLen(i);
        }
        // = len
        Set<Integer> seen = new HashSet<>();
        int i = 0;
        while(i < len){
            int digit = str.charAt(i) - '0';
            int pivot = getPivot(seen, digit, i);
            for(int j = 1 + i; j < len; j++){
                pivot *= (10 - j);
            }
            res += pivot;
            if(seen.contains(digit)) break; // already same, no more unique ones
            seen.add(digit);
            i++;
        }
        if(i == len) res++; // n itself
        return n - res;
    }
    private static int getPivot(Set<Integer> seen, int digit, int index){ //num of not seen number less than digit
        int res = 0;
        int start = 0;
        if(index == 0) start = 1;
        for(int i = start; i < digit; i++){
            if(!seen.contains(i)) res++;
        }
        return res;
    }
    private static int countNumLen(int i){ // 9*9*8*7*6*5.....
        int res = 9;
        for(int j = 1; j < i; j++){
            res *= (10 - j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numDupDigitsAtMostN(1234));//431
    }
}
// time O(logn) space O(1)
