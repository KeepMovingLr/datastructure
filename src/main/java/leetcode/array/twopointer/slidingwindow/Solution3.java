package leetcode.array.twopointer.slidingwindow;

/**
 * @author enyi.lr
 * @version $Id: Solution3.java, v 0.1 2019‐05‐23 1:43 AM enyi.lr Exp $$
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring(""));

    }

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring1(s);
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        int length = 0;
        while (l < chars.length && r + 1 < chars.length) {
            int index = containsIndex(chars, l, r, chars[r + 1]);
            if (index == -1) {
                r++;
                length = getMax(length, r - l + 1);
            } else {
                l = index + 1;
            }
        }
        return length;
    }

    private int getMax(int x, int y) {
        if (x >= y) {
            return x;
        } else {
            return y;
        }
    }

    private int containsIndex(char[] a, int l, int r, char b) {
        for (int i = l; i <= r; i++) {
            if (a[i] == b) {
                return i;
            }
        }
        return -1;
    }

    private int getMin(int x, int y) {
        if (x <= y) {
            return x;
        } else {
            return y;
        }
    }

}