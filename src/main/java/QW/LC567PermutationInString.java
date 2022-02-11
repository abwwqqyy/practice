package QW;

public class LC567PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2)
            return false;
        int[] b1 = new int[26];
        int[] b2 = new int[26];
        for(int i = 0; i < l1; i++){
            b1[s1.charAt(i) - 'a']++;
            b2[s2.charAt(i) - 'a']++;
        }
        if(isSame(b1, b2)){
            return true;
        }
        for(int i = l1; i < l2; i++){
            b2[s2.charAt(i - l1) - 'a']--;
            b2[s2.charAt(i) - 'a']++;
            if(isSame(b1, b2)){
                return true;
            }
        }
        return false;

    }
    private static boolean isSame(int[] b1, int[] b2){
        for(int i = 0; i < 26; i++){
            if(b1[i] != b2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "iasdfbac"));// ture
        System.out.println(checkInclusion("ab", "iasdbfac")); //false
    }
}
// time O(l1 + 26 * (l2 - l1)) space O(1)
