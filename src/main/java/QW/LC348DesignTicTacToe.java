package QW;

import java.util.HashMap;
import java.util.Map;

public class LC348DesignTicTacToe {
    Map<String, Integer> rows;
    Map<String, Integer> cols;
    int[][] diag;// i for diag and offdiag, j for XO, val for num on diags
    boolean cross;
    int size;
    public LC348DesignTicTacToe(int n) {
        rows = new HashMap<>();
        cols = new HashMap<>();
        diag = new int[2][2];
        size = n;
    }

    public int move(int row, int col, int person) {
        int player = person == 1 ? 0 : 1;
        putCount(player, row, rows);
        putCount(player, col, cols);
        int rCount = getCount(player, row, rows);
        int cCount = getCount(player, col, cols);
        if(row == col){
            diag[player][0] ++;
        }
        if(row + col == size - 1){
            diag[player][1] ++;
        }
        // System.out.println(rows + "  " + cols + "  " + Arrays.deepToString(diag));
        if(rCount == size || cCount == size || diag[player][0] == size || diag[player][1] == size){
            return person;
        }
        return 0;
    }
    private int getCount(int player, int pos, Map<String, Integer> map){
        String key = String.valueOf(player) + "," + String.valueOf(pos);
        return map.getOrDefault(key, 0);
    }
    private void putCount(int player, int pos, Map<String, Integer> map){
        String key = String.valueOf(player) + "," + String.valueOf(pos);
        int curCount = map.getOrDefault(key, 0);
        map.put(key, curCount + 1);
    }
}
// time O(1) space O(n)
