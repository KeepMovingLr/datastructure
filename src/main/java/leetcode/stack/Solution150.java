package leetcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution150.java, v 0.1 2019‐06‐27 6:00 PM enyi.lr Exp $$
 * v2
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Set<String> operator = new HashSet<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operator.contains(tokens[i])) {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int result;
                if ("+".equals(tokens[i])) {
                    result = left + right;
                } else if ("-".equals(tokens[i])) {
                    result = left - right;
                } else if ("*".equals(tokens[i])) {
                    result = left * right;
                } else {
                    result = left / right;
                }
                stack.push(result + "");
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }

}