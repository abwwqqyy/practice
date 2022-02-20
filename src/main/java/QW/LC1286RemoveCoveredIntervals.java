package QW;

import java.util.Arrays;
import java.util.Comparator;

public class LC1286RemoveCoveredIntervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }else{
                    return a[0] - b[0];
                }
            }

        });
        // System.out.println(Arrays.deepToString(intervals));
        int removed = 0;

        for(int i = 0; i < n; i++){
            int[] cur = intervals[i];
            int j = i + 1;
            while(j < n){
                int[] compare = intervals[j];
                if(cur[1] >= compare[1]){
                    // System.out.println(cur[1]+" : "+compare[1]);
                    removed ++;
                    j++;
                }else{
                    break;
                }
            }
            if(j != i + 1){
                i = j - 1;
            }
        }
        return n - removed;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {1,4},{3,6},{2,8},{1,5}};
        System.out.println(removeCoveredIntervals(intervals));//2
    }
}
// time O(nlogn) space O(1) or O(logn) by sort
