package QW;

public class LC2139MinimumMovesToReachTargetScore {
    public static int minMoves(int target, int maxDoubles) {
        int count = 0;
        while(maxDoubles > 0){
            if(target == 1){
                break;
            }
            if(target % 2 != 0){
                count++;
                target -= 1;
            }
            target /= 2;
            count ++;
            maxDoubles --;
        }
        if(target > 1){
            count += target - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(19,2));//7
        System.out.println(minMoves(10, 4));//4
    }
}
