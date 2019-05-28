package leetcode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr  todo  can not solved
 * @version $Id: Solution483.java, v 0.1 2019‐05‐23 1:49 AM enyi.lr Exp $$
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        // use [l,r] presents the sliding window
        int l = 0;
        int r = p.length() - 1;
        char[] chars = s.toCharArray();
        while (l < s.length() && r < s.length()) {
            if (isSnagrams(s, l, r, p)) {
                indices.add(l);
            }
            l++;
            r++;
        }
        return indices;
    }

    public boolean isSnagrams(String s, int l, int r, String p) {
        if (s.equals(p)){
            return true;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = l; i <= r; i++) {
            if (characterIntegerMap.containsKey(chars[i])) {
                Integer num = characterIntegerMap.get(chars[i]);
                num++;
                characterIntegerMap.put(chars[i], num);
            } else {
                characterIntegerMap.put(chars[i], 1);
            }
        }
        char[] chars1 = p.toCharArray();
        for (char c : chars1) {
            if (!characterIntegerMap.containsKey(c)) {
                return false;
            } else {
                Integer num = characterIntegerMap.get(c);
                num--;
                characterIntegerMap.put(c, num);
            }

        }
        // if all map's value != 0, true else false
        Set<Character> keys = characterIntegerMap.keySet();
        for (Character key : keys) {
            if (characterIntegerMap.get(key) != 0) {
                return false;
            }

        }
        return true;
    }



    public boolean isSnagrams(char[] a, int l, int r, String p) {
        int length = p.length();
        if (r - l + 1 != length) {
            return false;
        } else {
            Map<Character, Integer> characterIntegerMap = new HashMap<>();
            for (int i = l; i <= r; i++) {
                if (characterIntegerMap.containsKey(a[i])) {
                    Integer num = characterIntegerMap.get(a[i]);
                    num++;
                    characterIntegerMap.put(a[i], num);
                } else {
                    characterIntegerMap.put(a[i], 1);
                }
            }
            char[] chars1 = p.toCharArray();
            for (char c : chars1) {
                if (!characterIntegerMap.containsKey(c)) {
                    return false;
                } else {
                    Integer num = characterIntegerMap.get(c);
                    num--;
                    characterIntegerMap.put(c, num);
                }

            }
            // if all map's value != 0, true else false
            Set<Character> keys = characterIntegerMap.keySet();
            for (Character key : keys) {
                if (characterIntegerMap.get(key) != 0) {
                    return false;
                }

            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("abab", "ab");
        List<Integer> anagrams2 = solution438.findAnagrams("cbaebabacd", "abc");
        List<Integer> anagrams3 = solution438.findAnagrams("baa", "aa");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }

    }
}