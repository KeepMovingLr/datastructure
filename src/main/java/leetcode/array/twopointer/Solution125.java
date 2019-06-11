package leetcode.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution125.java, v 0.1 2019‐05‐22 12:12 AM enyi.lr Exp $$
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        StringBuilder need = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                need.append(chars[i]);
            }
        }
        String needChecked = need.toString().toLowerCase();
        char[] chars1 = needChecked.toCharArray();
        int i = 0;
        int j = chars1.length - 1;
        while (i < j) {
            if (chars1[i] != chars1[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}