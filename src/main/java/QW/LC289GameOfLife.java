package QW;

import java.util.Arrays;

public class LC289GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                flip(board, i, j);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == -1){
                    board[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }
    private static void flip(int[][] board, int x, int y){
        int count = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(x+i >=0 && x+i < board.length && y+j >=0 && y+j < board[0].length && board[x+i][y+j] > 0){
                    count ++;
                }
            }
        }
        // System.out.println(count);
        if((count < 2 || count > 3) && board[x][y] == 1){// originally 1 now 0
            board[x][y] = 2;
        }else if((count == 3) && board[x][y] == 0){// originally 0 now 1
            board[x][y] = -1;
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);//[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    }
}
// time O(mn) space O(1)
