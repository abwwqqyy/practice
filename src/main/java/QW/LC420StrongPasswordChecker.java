package QW;

public class LC420StrongPasswordChecker {
    public static int strongPasswordChecker(String password) {
        int n = password.length();
        int a = 1;
        int A = 1;
        int d = 1;
        for(char c : password.toCharArray()){
            if(Character.isLowerCase(c)) a = 0;
            if(Character.isUpperCase(c)) A = 0;
            if(Character.isDigit(c)) d = 0;
        }
        int insertion = a + A + d;
        if(n < 6) return Math.max(insertion, 6 - n);

        int replace = 0;
        int delOne = 0; // delete one char for "aaa" and have the same impact of one replacement
        int delTwo = 0; // delete two chars for "aaaa" and have the same impact of one replacement

        for(int i = 0; i < n; i++){
            int len = 1;
            while(i + len < n && password.charAt(i) == password.charAt(i + len)) len ++;
            if(len > 2){
                replace += len / 3;
                if(len % 3 == 0) delOne += 1;
                if(len % 3 == 1) delTwo += 2;
            }
            i += len - 1;
        }
        // System.out.println(replace + "  " + delOne + "   " + delTwo);
        if(n < 20) return Math.max(replace, insertion);

        int deletion = n - 20;
        replace -= Math.min(deletion, delOne); // delete 1 char
        replace -= Math.min(Math.max(0, deletion - delOne), delTwo) / 2; // delete 2 chars
        replace -= Math.max(0, deletion - delOne - delTwo) / 3; // delete 3 chars

        // System.out.println(n + "  " + replace +"  " + deletion);
        return deletion + Math.max(replace, insertion);
    }

    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("A1234567890aaabbbbccccc")); // 4
    }
}
// time O(n) space O(1)
