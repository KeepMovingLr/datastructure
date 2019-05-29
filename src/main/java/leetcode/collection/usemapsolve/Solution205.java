package leetcode.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution205.java, v 0.1 2019‐05‐29 8:27 PM enyi.lr Exp $$
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i])) {
                Character character = map.get(chars1[i]);
                if (!character.equals(chars2[i])) {
                    return false;
                }
            } else {
                for (Character c : map.keySet()) {
                    if (map.get(c).equals(chars2[i])) {
                        return false;
                    }
                }
                map.put(chars1[i], chars2[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("paper", "title"));

    }
}