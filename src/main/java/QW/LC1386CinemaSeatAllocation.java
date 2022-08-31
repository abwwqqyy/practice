package QW;

import java.util.HashMap;
import java.util.Map;

public class LC1386CinemaSeatAllocation {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> seats = new HashMap<>();
        for(int[] seat : reservedSeats){
            int row = seat[0];
            int col = seat[1];
            int cur = seats.getOrDefault(row, 0);
            seats.put(row, cur | (1 << col));
        }
        int res = (n - seats.size()) * 2; // empty
        for(int i : seats.keySet()){
            int count = 0;
            int cur = seats.get(i);
            if((cur & 60) == 0) count ++; // 2345
            if((cur & 960) == 0) count ++; // 6789
            if((cur & 240) == 0 && (count == 0)) count++; // 4567
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] reservedSeats = new int[][]{{2,1},{1,8},{2,6}};
        System.out.println(maxNumberOfFamilies(2, reservedSeats)); //2
    }
}
// time O(n) space O(n)
