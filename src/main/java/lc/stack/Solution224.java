package lc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution224.java, v 0.1 2019‐05‐17 10:32 PM enyi.lr Exp $$
 */
public class Solution224 {

    public static void main(String[] args) {
        Solution224 solution224 = new Solution224();
        System.out.println(solution224.calculate("1 + 11"));
        System.out.println(solution224.calculate("1 + 1"));
        System.out.println(solution224.calculate(" 2-1 + 2 "));
        System.out.println(solution224.calculate("(1+(4+5+2)-3)+(6+8)"));

    }

    /**
     * "1 + 1" " 2-1 + 2 " "(1+(4+5+2)-3)+(6+8)"
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        List<String> strings = splitToIndividual(s);
        for (String string : strings) {
            if (!isRightBracket(string)) {
                if (isDigit(string) && !stack.isEmpty()) {
                    if (isOperator(stack.peek())) {
                        String operator = stack.pop();
                        String leftValue = stack.pop();
                        // operate
                        String result = operate(leftValue, operator, string);
                        stack.push(result);
                    } else {
                        stack.push(string);
                    }
                } else {
                    stack.push(string);
                }
            } else { // ')'
                String value = stack.pop();
                stack.pop();
                if (!stack.isEmpty()) {
                    if (isOperator(stack.peek())) {
                        String operator = stack.pop();
                        String leftValue = stack.pop();
                        // operate
                        String result = operate(leftValue, operator, value);
                        stack.push(result);
                    }
                } else {
                    stack.push(value);
                }

            }

        }
        return Integer.parseInt(stack.pop());
    }

    private String operate(String leftValue, String operator, String rightValue) {
        Integer result = null;
        if (isAdd(operator)) {
            result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
        } else {
            result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
        }
        return result + "";
    }

    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isLeftBracket(String s) {
        return "(".equals(s);
    }

    private boolean isRightBracket(String s) {
        return ")".equals(s);
    }

    private boolean isOperator(String s) {
        return ("+".equals(s) || "-".equals(s));
    }

    private boolean isAdd(String operator) {
        return "+".equals(operator);
    }

    private boolean isMinus(String operator) {
        return "-".equals(operator);
    }

    private boolean isBracket(String c) {
        return (c == "[" || c == "]");
    }

    private String clean(String s) {
        return s.replace(" ", "");
    }

    private List<String> splitToIndividual(String s) {
        List<String> resultList = new ArrayList<String>();
        String clean = clean(s);
        char[] chars = clean.toCharArray();
        String tempDigit = "";
        for (int i = 0; i < chars.length; i++) {
            if (!isDigit(chars[i] + "")) {
                resultList.add("" + chars[i]);
            } else {
                int end = i;
                String temp = "";
                while (end < chars.length && isDigit(chars[end] + "")) {
                    temp = temp + chars[end];
                    end++;
                }
                resultList.add(temp);
                i = end - 1;
            }
        }
        return resultList;
    }

}