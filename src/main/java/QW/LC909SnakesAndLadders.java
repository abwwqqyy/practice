package QW;

import java.util.LinkedList;
import java.util.Queue;

public class LC909SnakesAndLadders {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int num = n * n;
        int i = 1;
        int step = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int size = q.size();

            // System.out.println(q);
            while(size-- > 0){
                int cur = q.poll();

                for(int j = 1; j <= 6; j++){
                    int next = cur + j;
                    if(next > num){
                        continue;
                    }
                    int x = transfer(next, num, n)[0];
                    int y = transfer(next, num, n)[1];
                    // System.out.println(next + " x: " + x + " y: " + y);
                    int curVal = board[x][y];
                    if(curVal == 0){
                        continue;
                    }
                    if(curVal > 0){
                        next = curVal;
                        // System.out.println(next +" ,x= " + x +" y= "+y +" "+board[x][y]);
                    }
                    if(num == next){
                        return step;
                    }
                    board[x][y] = 0; // mark as visited
                    q.offer(next);
                }
            }
            step++;
        }

        return -1;
    }
    private static int[] transfer(int pos, int num, int n){
        int r = (pos - 1) / n;
        int c = (pos - 1) % n;
        int row =  n - 1 - r;
        int col = r % 2 == 0 ? c : n - 1 - c;
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board)); //4
    }
}
// time O(mn) space O(mn)
