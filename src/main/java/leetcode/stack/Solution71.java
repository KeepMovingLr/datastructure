package leetcode.stack;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution71.java, v 0.1 2019‐06‐27 10:36 PM enyi.lr Exp $$
 * v2
 */
public class Solution71 {

    public String simplifyPath2(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        Stack<String> temp = new Stack<>();
        for (int i = 1; i < split.length; i++) {
            String needCheck = split[i];
            if (".".equals(needCheck) || "".equals(needCheck)) {
                // do nothing
            } else if ("..".equals(needCheck)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(needCheck);
            }

        }
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        StringBuilder result = new StringBuilder("/");
        while (!temp.isEmpty()) {
            result.append(temp.pop());
            result.append("/");
        }
        if (result.length() == 1) {
            return result.toString();
        }
        return result.substring(0, result.length() - 1);
    }




    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String[] split = path.split("/");
        for (int i = 1; i < split.length; i++) {
            String check = split[i];
            if (".".equals(check)) {
                // do nothing
            } else if ("..".equals(check)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("".equals(check)) {
                // do nothind
            } else {
                stack.push(check);
            }
        }
        while (!stack.isEmpty()) {
            stack2.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
            sb.append("/");
        }
        if (sb.length() == 1) {
            return sb.toString();
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        String s = solution71.simplifyPath("/../");
        System.out.println("result:" + s);

    }

}