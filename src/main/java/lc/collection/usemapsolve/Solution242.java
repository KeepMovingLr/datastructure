package lc.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution242.java, v 0.1 2019‐05‐29 7:42 PM enyi.lr Exp $$
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            Integer count = map1.getOrDefault(chars1[i], 0);
            count++;
            map1.put(chars1[i], count);
        }
        for (int i = 0; i < chars2.length; i++) {
            Integer count = map2.getOrDefault(chars2[i], 0);
            count++;
            map2.put(chars2[i], count);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Character key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map2.get(key).intValue() != map1.get(key).intValue()) {
                    return false;
                }
            } else {
                return false;
            }

        }
        return true;
    }

}