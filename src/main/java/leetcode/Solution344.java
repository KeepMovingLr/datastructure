package leetcode;

/**
 * @author enyi.lr
 * @version $Id: Solution344.java, v 0.1 2019‐05‐20 12:11 AM enyi.lr Exp $$
 */
public class Solution344 {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int toIndex = (s.length - 1) / 2;
        for (int i = 0; i <= toIndex; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public void reverseString2(char[] s) {
        if (s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}