package lc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution387.java, v 0.1 2019‐11‐21 12:41 PM enyi.lr Exp $$ v2
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequency[c - 'a'] == 1) {
                return i;
            }

        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

}