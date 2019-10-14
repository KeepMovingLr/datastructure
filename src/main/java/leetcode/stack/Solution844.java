/**
 * Alipay.com Inc. Copyright (c) 2004‐2019 All Rights Reserved.
 */
package leetcode.stack;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution844.java, v 0.1 2019‐10‐14 6:50 PM enyi.lr Exp $$
 *
 * v2
 */
public class Solution844 {

    public boolean backspaceCompare(String S, String T) {
        char[] firstChars = S.toCharArray();
        char[] secondChars = T.toCharArray();
        Stack<Character> firstStack = new Stack<>();
        Stack<Character> secondStack = new Stack<>();
        for (char firstChar : firstChars) {
            if (firstChar == '#') {
                if (!firstStack.isEmpty()) {
                    firstStack.pop();
                }
            } else {
                firstStack.push(firstChar);
            }
        }

        for (char secondChar : secondChars) {
            if (secondChar == '#') {
                if (!secondStack.isEmpty()) {
                    secondStack.pop();
                }
            } else {
                secondStack.push(secondChar);
            }
        }
        if (firstStack.size() != secondStack.size()) {
            return false;
        }
        for (int i = 0; i < firstStack.size(); i++) {
            if (firstStack.pop() != secondStack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        Solution844 solution844 = new Solution844();
        System.out.println("test:" + solution844.backspaceCompare(s, t));

    }

}