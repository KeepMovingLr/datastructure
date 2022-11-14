package lc.stack;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution394.java, v 0.1 2019‐05‐17 8:45 PM enyi.lr Exp $$
 * <p>
 * v2 2019‐10‐14 1:00 PM
 */
public class Solution394 {

    /**
     * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     *
     * @return
     */
    public String decodeString2(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != ']') {
                stack.push(aChar);
            } else {
                String rep = "";
                Character peek = stack.peek();
                while (!Character.isDigit(peek) && peek != '[' && !stack.isEmpty()) {
                    rep = stack.pop() + rep;
                    if (!stack.isEmpty()) {
                        peek = stack.peek();
                    }
                }
                if (peek == '[') {
                    stack.pop();
                }
                String repeatTimesString = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    repeatTimesString = stack.pop() + repeatTimesString;
                }
                String resultString = "";
                for (int i = 0; i < Integer.parseInt(repeatTimesString); i++) {
                    resultString = rep + resultString;
                }

                // re push to stack
                char[] chars1 = resultString.toCharArray();
                for (char c : chars1) {
                    stack.push(c);
                }

            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        //System.out.println(solution394.decodeString("3[a2[c]]"));
        System.out.println(solution394.decodeString2("3[a2[c]]"));
        System.out.println(solution394.decodeString("3[a]2[bc]"));
        System.out.println(solution394.decodeString2("3[a]2[bc]"));
        System.out.println(solution394.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution394.decodeString2("2[abc]3[cd]ef"));
        System.out.println();
        System.out.println(solution394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(solution394.decodeString2("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(solution394.decodeString("100[leetcode]"));
        System.out.println(solution394.decodeString2("100[leetcode]"));
        System.out.println(solution394.decodeString("3[a2[c]]"));
        System.out.println(solution394.decodeString2("3[a2[c]]"));
        System.out.println(solution394.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution394.decodeString2("2[abc]3[cd]ef"));
        System.out.println(solution394.decodeString("3[a]2[bc]"));
        System.out.println(solution394.decodeString2("3[a]2[bc]"));
    }

    /**
     * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != ']') {
                stack.push(aChar);
            } else {
                if (aChar == ']') {
                    String temp = "";
                    String loopTimesString = "";
                    Character peek = stack.peek();
                    while (!Character.isDigit(peek) && peek != '[' && !stack.isEmpty()) {
                        Character pop = stack.pop();
                        temp = pop + temp;
                        if (!stack.isEmpty()) {
                            peek = stack.peek();
                        }
                    }
                    if (peek == '[') {
                        stack.pop();
                        peek = stack.peek();
                    }
                    while (Character.isDigit(peek) && !stack.isEmpty()) {
                        Character pop = stack.pop();
                        loopTimesString = pop + loopTimesString;
                        if (!stack.isEmpty()) {
                            peek = stack.peek();
                        }
                    }
                    int loopTimes = Integer.parseInt(loopTimesString);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < loopTimes; i++) {
                        builder.append(temp);
                    }
                    // builder pop to stack
                    String s1 = builder.toString();
                    char[] chars1 = s1.toCharArray();
                    for (char c : chars1) {
                        stack.push(c);
                    }

                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

}