package QW;

import java.util.ArrayList;
import java.util.List;

public class LC1291SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();
        int small = String.valueOf(low).length();//lower length
        int large = String.valueOf(high).length();
        for(int i = small; i <= large; i++){// num length
            for(int j = 0; j < 10 - i; j++){// num start and end
                int val = Integer.parseInt(s.substring(j, j + i));
                if(val >= low && val <= high){
                    res.add(val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100,300));//[123, 234]
        System.out.println(sequentialDigits(1000,13000));//[1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }
}