package leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution20.java, v 0.1 2019‐05‐16 11:35 PM enyi.lr Exp $$
 */
public class Solution20 {

    public boolean isValid(String s) {
        Map<String, String> maps = new HashMap<String, String>();
        //maps.put("(", ")");
        maps.put(")", "(");
        //maps.put("{", "}");
        maps.put("}", "{");
        //maps.put("[", "]");
        maps.put("]", "[");
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<String>();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar + "");
            } else {
                String top = stack.peek();
                if (top.equals(maps.get(aChar + ""))) {
                    stack.pop();
                } else {
                    stack.push(aChar + "");
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        List<Character> left = new ArrayList<Character>();
        left.add('(');
        left.add('{');
        left.add('[');
        List<Character> right = new ArrayList<Character>();
        right.add(')');
        right.add('}');
        right.add(']');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char aChar : chars) {
            if (left.contains(aChar)) {
                stack.push(aChar);
            }
            if (right.contains(aChar)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (aChar == ')' && pop != '(') {
                    return false;
                }
                if (aChar == '}' && pop != '{') {
                    return false;
                }
                if (aChar == ']' && pop != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}