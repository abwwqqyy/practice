package QW;

public class LC1151MinimumSwapsToGroupAll1sTogether {
    public static int minSwaps(int[] data) {
        int n = data.length;
        int count1 = 0;
        for(int i : data){
            if(i == 1){
                count1++;
            }
        }
        int res = n;
        int window0 = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            if(r < count1){
                if(data[r] == 0) window0++;
                if(r == count1 - 1) res = window0;
                continue;
            }
            if(data[r] == 0){
                window0++;
            }
            if(data[l] == 0){
                window0--;
            }
            l++;
            // System.out.println(l + "  " + r + "  "+window0);
            res = Math.min(res, window0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,0,0,1,1};
        System.out.println(minSwaps(data)); // 1
    }
}
// time O(n) space O(1)
