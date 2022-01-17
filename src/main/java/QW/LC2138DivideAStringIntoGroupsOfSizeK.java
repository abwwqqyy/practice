package QW;

import java.util.Arrays;

public class LC2138DivideAStringIntoGroupsOfSizeK {
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = n / k;
        int remain = n % k;
        if(remain != 0){
            size += 1;
        }
        String[] res = new String[size];
        for(int i = 0; i < size - 1; i++){
            res[i] = s.substring(i * k, i * k + k);
        }
        if(remain == 0){
            res[size - 1] = s.substring(n - k, n);
        }else{
            String temp = s.substring((size - 1) * k, n);
            for(int i = 0; i < size * k - n; i++){
                temp += fill;
            }
            res[size - 1] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        char fill = 'x';
        String s1 = "abcdefghi";
        System.out.println(Arrays.toString(divideString(s1, 3, fill))); //["abc","def","ghi"]
        String s2 = "abcdefghij";
        System.out.println(Arrays.toString(divideString(s2,3,fill))); //["abc","def","ghi", "jxx"]
    }
}
