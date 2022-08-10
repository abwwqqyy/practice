package QW;

import java.util.Arrays;

public class LC828CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static int uniqueLetterString(String s) {
        int n = s.length();
        int[] contribution = new int[26];
        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur, -1);
        int cur = 0; // cur[i] = cur[i - 1] - contribution[s.charAt(i)] + i - lastOccur[s.charAt(i)]
        int res = 0;
        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 'A';
            cur += i - lastOccur[c] - contribution[c];
            contribution[c] = i - lastOccur[c];
            lastOccur[c] = i;
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC")); // 10
        System.out.println(uniqueLetterString("ABCBD")); // 27

    }
}
// time O(n) space O(1)
