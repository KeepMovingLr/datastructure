package lc.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution290.java, v 0.1 2019‐05‐29 8:26 PM enyi.lr Exp $$
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (chars.length != strings.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                String mapResult = map.get(chars[i]);
                if (!mapResult.equals(strings[i])) {
                    return false;
                }
            } else {
                // check if there is already a key - value
                for (Character key : map.keySet()) {
                    if (map.get(key).equals(strings[i])) {
                        return false;
                    }
                }
                map.put(chars[i], strings[i]);
            }
        }
        return true;
    }

}