package QW;

public class LC165CompareVersionNumber {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        // System.out.println(l1 +" : " + l2);
        int n = Math.min(l1,l2);
        for(int i = 0; i < n; i++){
            int c1 = Integer.parseInt(v1[i]);
            int c2 = Integer.parseInt(v2[i]);
            // System.out.println(c1 +" " + c2);
            if(c1 != c2) return c1 - c2 > 0 ? 1 : -1;
        }
        if(l1 == n){
            while(n < l2){
                if(Integer.parseInt(v2[n]) > 0) return -1;
                n++;
            }
        }else{
            while(n < l1){
                if(Integer.parseInt(v1[n]) > 0) return 1;
                n++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));//0
        System.out.println(compareVersion("1.01.10","1.1"));//1
    }
}
