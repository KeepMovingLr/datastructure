package lc.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: S_227_BasicCalculatorII.java, v 0.1 2020‐01‐18 12:10 AM enyi.lr Exp $$
 */
public class S_227_BasicCalculatorII {
    public int calculate(String s) {
        String expression = s.replace(" ", "");
        Set<String> highPriorityOperator = new HashSet<>();
        highPriorityOperator.add("*");
        highPriorityOperator.add("/");
        Set<String> lowPriorityOperator = new HashSet<>();
        lowPriorityOperator.add("+");
        lowPriorityOperator.add("-");
        char[] chars = expression.toCharArray();
        List<String> expressionList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                builder.append(aChar);
            } else {
                expressionList.add(builder.toString());
                builder = new StringBuilder();
                expressionList.add(String.valueOf(aChar));
            }
        }
        expressionList.add(builder.toString());
        Stack<String> stack = new Stack<>();
        for (String s1 : expressionList) {
            if (!stack.isEmpty()) {
                if (highPriorityOperator.contains(stack.peek())) {
                    // pop 2 elements
                    String operator1 = stack.pop();
                    String num2 = stack.pop();
                    int result = cal(Integer.parseInt(num2), Integer.parseInt(s1), operator1.charAt(0));
                    stack.push(String.valueOf(result));
                } else {
                    stack.push(s1);
                }
            } else {
                stack.push(s1);
            }
        }
        Stack<String> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        stack = stack2;
        while (!stack.isEmpty() && stack.size() >= 3) {
            String left = stack.pop();
            String op = stack.pop();
            String right = stack.pop();
            int result = cal(Integer.valueOf(left), Integer.valueOf(right), op.charAt(0));
            stack.push(String.valueOf(result));
        }
        return Integer.valueOf(stack.pop());
    }

    private int cal(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        S_227_BasicCalculatorII basicCalculatorII = new S_227_BasicCalculatorII();
        int calculate = basicCalculatorII.calculate("1-1+1");
        System.out.println(calculate);

    }
}