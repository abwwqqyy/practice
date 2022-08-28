package QW;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC353DesignSnakeGame {
    private Map<String, int[]> dirs;
    Deque<int[]> snake;
    private boolean[][] body;
    private int len;
    private int[] pos;
    private int[][] ground;
    private int foodIdx;
    private int[][] food;
    public LC353DesignSnakeGame(int width, int height, int[][] food) {
        dirs = new HashMap<>();
        dirs.put("U", new int[]{-1,0});
        dirs.put("D", new int[]{1,0});
        dirs.put("L", new int[]{0,-1});
        dirs.put("R", new int[]{0,1});
        snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0,0});
        body = new boolean[height][width];
        body[0][0] = true;
        len = 0;
        pos = new int[]{0,0};
        ground = new int[height][width];
        ground[food[0][0]][food[0][1]] = 1;
        foodIdx = 0;
        this.food = food;
    }

    public int move(String direction) {
        int[] dir = dirs.get(direction);
        int x = dir[0] + pos[0];
        int y = dir[1] + pos[1];
        int[] tail = snake.pollLast();
        body[tail[0]][tail[1]] = false;
        if(x < 0 || y < 0 || x >= ground.length || y >= ground[0].length || body[x][y]){
            return -1;
        }
        pos[0] = x;
        pos[1] = y;
        if(ground[x][y] == 1){
            snake.offerFirst(new int[]{x,y});
            body[x][y] = true;
            ground[food[foodIdx][0]][food[foodIdx][1]] = 0;
            if(++foodIdx < food.length){
                ground[food[foodIdx][0]][food[foodIdx][1]] = 1;
            }
            len++;
            snake.offerLast(tail);
            body[tail[0]][tail[1]] = true;
        }else{
            snake.offerFirst(new int[]{x,y});
            body[x][y] = true;
        }
        // System.out.println(x + "  " + y);
        return len;
    }
}
