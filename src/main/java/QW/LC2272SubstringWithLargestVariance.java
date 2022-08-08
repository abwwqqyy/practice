package QW;

public class LC2272SubstringWithLargestVariance {
    public static int largestVariance(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            freq[cur - 'a'] ++;
        }
        int res = 0;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j || freq[i] == 0 || freq[j] == 0){
                    continue;
                }
                int count1 = 0;
                int count2 = 0;
                boolean found2 = false;
                for(int k = 0; k < n; k++){ // cal count1 - count2
                    int cur = s.charAt(k) - 'a';
                    if(cur == i) count1++;
                    if(cur == j) count2++;
                    if(count1 < count2){
                        count1 = 0;
                        count2 = 0;
                        found2 = true; // there has been char j
                    }
                    if(count1 > 0 && count2 > 0){
                        res = Math.max(res, count1 - count2);
                    }else if(count1 > 0 && found2){
                        res = Math.max(res, count1 - count2 - 1); // add 1 count to the prev char j
                    }
                    // System.out.println(i + " : " + count1 + " , " + j + " : " + count2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestVariance("abbb")); // 2
        System.out.println(largestVariance("aaab")); // 2
    }
}
// time O(26*26*n) space O(26)
