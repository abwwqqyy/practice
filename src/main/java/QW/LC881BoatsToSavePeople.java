package QW;

import java.util.Arrays;

public class LC881BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if(n == 1) return 1;
        Arrays.sort(people);
        int l = 0;
        int r = n - 1;
        int cur = people[r];
        int count = 1;
        int res = 0;
        while(l < r){
            cur += people[l];
            count++;
            if(cur > limit || count > 2){// at most two people
                r --;
                res ++;
                cur = people[r];
                count = 1;
            }else{
                l++;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] people = new int[]{3,2,2,1};
        System.out.println(numRescueBoats(people, 3));//3
    }
}
// time O(nlogn) space O(1)
