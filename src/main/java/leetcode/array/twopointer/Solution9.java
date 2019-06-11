package leetcode.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution9.java, v 0.1 2019‐05‐27 11:17 PM enyi.lr Exp $$
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        char[] chars = (x + "").toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}