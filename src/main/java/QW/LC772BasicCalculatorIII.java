package QW;

import java.util.Deque;
import java.util.LinkedList;

public class LC772BasicCalculatorIII {
    public static int calculate(String s) {
        int n = s.length();
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>(); // operators and ()
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                nums.push(num);
            }else if(cur == '('){
                ops.push(cur);
            }else if(cur == ')'){
                while(ops.peek() != '('){
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop(); // pop out '('
            }else{ // + - * /
                while(!ops.isEmpty() && evalPrev(cur, ops.peek())){
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(cur);
            }

        }
//        System.out.println(nums);
//        System.out.println(ops);
        while (!ops.isEmpty()) {
            nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int eval(char op, int num1, int num2){
        switch(op){
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
        }
        return 0;
    }

    private static boolean evalPrev(char op, char prev){
        if(prev == '(' || prev == ')') return false;
        if((prev == '+' || prev == '-') && (op == '*' || op == '/')) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); // 21
    }
}
// time O(n) space O(n)
