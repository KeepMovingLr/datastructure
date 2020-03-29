package leetcode.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Calculator.java, v 0.1 2019‐12‐15 8:31 PM enyi.lr Exp $$
 */
public class Calculator {
    public int calculate(String input) {
        Set<String> highOperator = new HashSet<>();
        Set<String> lowOperator = new HashSet<>();
        highOperator.add("*");
        highOperator.add("/");
        lowOperator.add("+");
        lowOperator.add("-");
        char[] inputs = input.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < inputs.length; i++) {
            String checked = String.valueOf(inputs[i]);
            if (stack.isEmpty()) {
                stack.push(checked);
            } else {
                if (lowOperator.contains(checked)) {
                    stack.push(checked);
                } else if (highOperator.contains(checked)) {
                    String leftValue = stack.pop();
                    String rightValue = String.valueOf(inputs[i + 1]);
                    int result = 0;
                    if (checked.equals("*")) {
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                    } else {
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                    }
                    stack.push(String.valueOf(result));
                    i++;
                } else {
                    stack.push(checked);
                }
            }
        }
        Stack<String> stack2 = new Stack<>();
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        System.out.println(list);
        Stack<String> stack3 = new Stack<>();
        for (String s : list) {
            if (stack3.isEmpty()) {
                stack3.push(s);
            }
            if (lowOperator.contains(stack3.peek())) {
                String operator = stack3.pop();
                String leftValue = stack3.pop();
                // operate
                if (operator.equals("+")) {
                    stack3.push(String.valueOf(Integer.parseInt(leftValue) + Integer.parseInt(s)));
                } else {
                    stack3.push(String.valueOf(Integer.parseInt(leftValue) - Integer.parseInt(s)));
                }
            } else {
                stack3.push(s);
            }

        }
        return Integer.parseInt(stack3.pop());
    }

    public static void main(String[] args) {
        String a = "1+2*3-4";
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(a));
    }
}