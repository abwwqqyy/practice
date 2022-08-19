package QW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2055PlatesBetweenCandles {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        int n = s.length();
        int[] numCandles = new int[n];
        List<Integer> numPlates = new ArrayList<>(); // index = num of candles
        numPlates.add(0);
        int candles = 0;
        int plates = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '|'){
                candles++;
                numPlates.add(plates);
            }else{
                plates++;
            }
            numCandles[i] = candles;
        }
        for(int i = 0; i < m; i++){
            int[] q = queries[i];
            int left = numCandles[q[0]];
            int right = numCandles[q[1]];
            // System.out.println(left +"  " + right);
            if(s.charAt(q[0]) != '|'){
                left += 1;
            }
            // System.out.println(s.charAt(q[0]) + "  " + s.charAt(q[1]));
            if(left >= right){
                res[i] = 0;
            }else{
                res[i] = numPlates.get(right) - numPlates.get(left);
            }
        }
        // System.out.println(Arrays.toString(numCandles));
        // System.out.println(numPlates);
        return res;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*" ,queries))); //[9,0,0,0,0]
    }
}
// time O(n) space O(n)
