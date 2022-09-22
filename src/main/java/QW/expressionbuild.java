package QW;


import java.io.*;
import java.util.*;

public class expressionbuild {

    /**
     * Possible types of values.
     */
    public enum ValueType {
        STRING, INTEGER
    }

    /**
     * Represents a parsed value token.
     */
    public static class Value {
        public Value(final String value) { m_value = value; }
        public Value(final Integer value) { m_value = value; }

        /**
         * Returns the type of the value
         */
        public ValueType type() {
            if(m_value instanceof String) return ValueType.STRING;
            else if(m_value instanceof Integer) return ValueType.INTEGER;
            else throw new RuntimeException();
        }

        /**
         * Accessors based on type. Throws an exception if wrong acessor is used.
         */
        public String asString() { return (String)m_value; }
        public int asInteger() { return ((Integer)m_value).intValue(); }

        private final Object m_value;
    }

    /**
     * Possible types of tokens
     */
    public enum TokenType {
        FUNCTION_NAME,
        VALUE,
        CHAR
    }

    /**
     * Represents a single parsed token
     */
    public static class Token {
        public Token(final String functionName) { m_obj = functionName; }
        public Token(final Value value) { m_obj = value; }
        public Token(final Character chr) { m_obj = chr; }

        /**
         * Returns the type of the token
         */
        public TokenType type() {
            if(m_obj instanceof String) return TokenType.FUNCTION_NAME;
            else if(m_obj instanceof Value) return TokenType.VALUE;
            else if(m_obj instanceof Character) return TokenType.CHAR;
            else throw new RuntimeException();
        }

        /**
         * Accessors based on type. Throws an exception if wrong acessor is used.
         */
        public String asFunction() { return (String)m_obj; }
        public Value asValue() { return (Value)m_obj; }
        public char asChar() { return ((Character)m_obj).charValue(); }

        private final Object m_obj;
    }

    /**
     * The result of consuming a token
     */
    public static class ConsumeResult {
        public ConsumeResult(final Token t, final String r) { token = t; remainingString = r;}
        public Token token;             //the token parsed
        public String remainingString;  //the remaining string after the parsed token was removed from the front
    }

    /**
     * consumeNextToken():
     *
     *   Given an input string, parses off and returns the next token in a left-to-right fashion.
     *
     *   @arg    s    A string of all remaining text to parse
     *
     *   @return A ConsumeResult containing the token and the remaining un-parsed string.
     *
     *   NOTE! You may need to modify this function for the base or complications!
     *
     */
    ConsumeResult consumeNextToken(final String s) {
        Token r = null;
        int tokenLen = 0;

        final char c0 = s.charAt(0);
        if (c0 == ')' || c0 == '(' || s.charAt(0) == ',') {
            // parse a syntax token
            r = new Token(c0);
            ++tokenLen;
        } else if (s.charAt(0) == '"') {
            //parse a string
            int i = 1;
            for (; i < s.length(); ++i) {
                if (s.charAt(i) == '"')
                    break;
            }
            r = new Token(new Value(s.substring(1, i)));
            tokenLen = i + 1;
        } else if (c0 >= '0' && c0 <= '9') {
            //parse an integer
            int i = 0;
            for (; i < s.length(); ++i) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9')
                    break;
            }
            r = new Token(new Value(Integer.parseInt(s.substring(0, i))));
            tokenLen = i;
        } else {
            //parse a function name
            int i = 0;
            for (; i < s.length(); ++i) {
                if (s.charAt(i) == '(')
                    break;
            }
            r = new Token(s.substring(0, i));
            tokenLen = i;
        }

        //return the token, and the remainder of the string starting at the first char after the token
        return new ConsumeResult(r, s.substring(tokenLen));
    }

    /**
     *
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * YOUR CODE STARTS HERE!
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     */
    public static int add(int a, int b){
        return a+b;

    }
    public static int sub(int a, int b){
        return a-b;

    }
    public static int len(String x){
        return x.length();


    }

    public static String concat(String s, String t){
        StringBuilder a=new StringBuilder();
        a.append(s);
        a.append(t);
        return a.toString();
    }
    public static int parse(String s){


        return Integer.parseInt(s);
    }





    public static void main(String[] args) {
//      Scanner scanner = new Scanner(System.in);
//          String myString = scanner.next();
        String myString = "add()";
        expressionbuild exp = new expressionbuild();
        ConsumeResult res = exp.consumeNextToken(myString);
        String wd = res.token.asFunction();

        System.out.println(res.token.type() == TokenType.FUNCTION_NAME);
        System.out.println(res.token.type() == TokenType.CHAR);
        System.out.println(res.token.type() == TokenType.VALUE);

        System.out.println(wd);

        /* Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}