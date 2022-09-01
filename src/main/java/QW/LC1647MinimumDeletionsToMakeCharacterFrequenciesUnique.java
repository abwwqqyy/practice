package QW;

public class LC1647MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static int minDeletions(String s) {
        int n = s.length();
        int[] bucket = new int[26];
        for(char c : s.toCharArray()){
            bucket[c - 'a'] ++;
        }
        int[] count = new int[n + 1];
        for(int i : bucket){
            if(i != 0){
                count[i] ++;
            }
        }
        int res = 0;
        for(int i = n; i > 0; i--){
            int num = count[i];
            if(num > 1){
                res += num - 1;
                count[i - 1] += num - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc")); // 2
    }
}
// time O(n) space O(n)
