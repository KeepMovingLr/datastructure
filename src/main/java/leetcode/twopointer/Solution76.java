package leetcode.twopointer;


import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution76.java, v 0.1 2019‐05‐23 1:51 AM enyi.lr Exp $$
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (t.equals(s)) {
            return t;
        }
        char[] chars1 = t.toCharArray();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : chars1) {
            Integer orDefault = characterIntegerMap.getOrDefault(c, 0);
            orDefault = orDefault + 1;
            characterIntegerMap.put(c, orDefault);
        }

        char[] chars = s.toCharArray();
        int l = 0;
        int r = -1;
        StringBuilder stringBuilder = new StringBuilder();
        String current = s + t;
        // use [l,r] to save the sub
        //List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        while (l < chars.length) {
            if (!satisfied(map, characterIntegerMap)) {
                if (r + 1 < chars.length) {
                    r++;
                    if (map.containsKey(chars[r])) {
                        Integer count = map.get(chars[r]);
                        if (count != 0) {
                            count++;
                            map.put(chars[r], count);
                        }
                    } else {
                        map.put(chars[r], 1);
                    }
                    stringBuilder.append(chars[r]);
                } else {
                    break;
                }

            } else {
                if (stringBuilder.length() < current.length()) {
                    current = stringBuilder.toString();
                }
                if (map.containsKey(chars[l])) {
                    int count = map.get(chars[l]);
                    count--;
                    if (count == 0) {
                        map.remove(chars[l]);
                    } else {
                        map.put(chars[l], count);
                    }
                }
                stringBuilder.delete(0, 1);
                l++;
            }
        }
        if ((s + t).equals(current)) {
            return "";
        } else {
            return current;
        }
    }

    public boolean satisfied(Map<Character, Integer> characters, Map<Character, Integer> character2) {
        for (char c : character2.keySet()) {
            if (!characters.containsKey(c)) {
                return false;
            } else {
                if (characters.get(c) < character2.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("a", "aa");
        System.out.println(s);



    }

}