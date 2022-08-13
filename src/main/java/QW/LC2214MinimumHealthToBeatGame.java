package QW;

public class LC2214MinimumHealthToBeatGame {
    public static long minimumHealth(int[] damage, int armor) {
        int n = damage.length;
        int max = 0;
        long res = 1;
        for(int i : damage){
            res += i;
            max = Math.max(max, i);
        }
        if(max <= armor){
            res -= max;
        }else{
            res -= armor;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] damage = new int[]{2,3,7,4};
        System.out.println(minimumHealth(damage, 4)); // 13
    }
}
// time O(n) space O(1)
