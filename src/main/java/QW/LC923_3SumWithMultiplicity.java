package QW;

import java.util.*;

public class LC923_3SumWithMultiplicity {
    public static int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        int MOD = 1_000_000_007;
        Map<Integer, Long> m = new HashMap<>();//has to be long
        for(int i = 0; i < n; i++){
            m.put(arr[i], m.getOrDefault(arr[i], 0L) + 1);
        }

        List<Integer> unique = new ArrayList<>(m.keySet());
        Collections.sort(unique);
        long count = 0;
        for(int i = 0; i < unique.size(); i++){
            int l = i;
            int r = unique.size() - 1;
            int x = unique.get(i);
            int newTar = target - x;
            while(l <= r){
                int y = unique.get(l);
                int z = unique.get(r);
                if(y + z < newTar){
                    l++;
                }else if(y + z > newTar){
                    r--;
                }else{
                    if(i < l && l < r){//not equal
                        count += m.get(x) * m.get(y) * m.get(z);
                    }else if(i == l && l < r){ // first two equal
                        count += m.get(x) * (m.get(x) - 1) / 2 * m.get(z);
                    }else if(i < l && l == r){//last two equal
                        count += m.get(x) * m.get(y) * (m.get(y) - 1) / 2;
                    }else if(i == l && l == r){// all equal
                        count += m.get(x) * (m.get(x) - 1) * (m.get(x) - 2) / 6;
                    }
                    count %= MOD;
                    l++;
                    r--;
                    // System.out.println("x: " + x + " y: " + y + " z: " + z) ;
                }
            }
        }
        return (int)count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5};
        System.out.println(threeSumMulti(arr, 8)); //20
        int[] arr1 = new int[]{1,1,2,2,2,2};
        System.out.println(threeSumMulti(arr1,5));//12
    }
}
// time O(n^2) space O(n)
