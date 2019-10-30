package leetcode.array.twopointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution3.java, v 0.1 2019‐05‐23 1:43 AM enyi.lr Exp $$
 * v2
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring4("abcabcbb"));

    }

    // good approach, very very good
    public int lengthOfLongestSubstring4(String s) {
        // use
        int[] frequency = new int[256];
        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        int longestLength = 0;
        int length = chars.length;
        // use [l,r] to reserve the un repeated string
        while (l < length) {
            if (r + 1 < length && frequency[chars[r + 1]] == 0) {
                r++;
                frequency[chars[r]]++;
            } else {
                frequency[chars[l]]--;
                l++;
            }
            longestLength = getMax(longestLength, r - l + 1);
        }
        return longestLength;
    }


    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring3(s);
    }

    // new method: use map and sliding window to solve the problem
    public int lengthOfLongestSubstring3(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        int longestLength = 0;
        int length = chars.length;
        Map<Character, Integer> frencuencyMap = new HashMap<>();
        // use [l,r] to reserve the un repeated string
        while (l < length && r + 1 < length) {
            Integer index = frencuencyMap.get(chars[r + 1]);
            if (index != null && index>=l) {
                l = index;
                l++;
                r++;
            } else {
                r++;
                longestLength = getMax(longestLength, r - l + 1);
            }
            frencuencyMap.put(chars[r], r);
        }
        return longestLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        int longestLength = 0;
        int length = chars.length;
        // use [l,r] to reserve the un repeated string
        while (l < length && r + 1 < length) {
            int index = containsIndex(chars, l, r, chars[r + 1]);
            if (index == -1) {
                r++;
            } else {
                l = index + 1;
                r++;
            }
            longestLength = getMax(longestLength, r - l + 1);

        }
        return longestLength;
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