package QW;

public class LC161OneEditDistance {
    public static boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        int count = 1;
        if(ns == nt){
            for(int i = 0; i < ns; i++){
                if(s.charAt(i) != t.charAt(i)){
                    count--;
                    if(count < 0) return false;
                }
            }
        }else if(ns == nt + 1){
            int j = 0;
            for(int i = 0; i < nt; i++, j++){
                if(s.charAt(j) != t.charAt(i)){
                    count--;
                    i--;
                    if(count < 0) return false;
                }
            }
            if(count == 1) return true;
        }else if(nt == ns + 1){
            int j = 0;
            for(int i = 0; i < ns; i++, j++){
                if(s.charAt(i) != t.charAt(j)){
                    count--;
                    i--;
                    if(count < 0) return false;
                }
            }
            if(count == 1) return true;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab","acb")); // true
    }
}
// time O(n) space O(1)
