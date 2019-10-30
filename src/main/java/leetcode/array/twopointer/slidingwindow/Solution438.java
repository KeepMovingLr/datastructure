package leetcode.array.twopointer.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution483.java, v 0.1 2019‐05‐23 1:49 AM enyi.lr Exp $$
 * v2 2019‐10‐30
 */
public class Solution438 {

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams1 = solution438.findAnagrams3("cbaebabacd", "abc");
        List<Integer> anagrams2 = solution438.findAnagrams3("baa", "aa");
        //System.out.println(anagrams1.toString());
        System.out.println(anagrams1.toString());

    }

    public List<Integer> findAnagrams3(String s, String p) {
        int[] slidWindowFrequency = new int[26];
        int[] count = getFrequency(p);
        List<Integer> indices = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length()< p.length()) {
            return indices;
        }
        int l = 0;
        int r = p.length() - 1;
        char[] sChar = s.toCharArray();
        for (int i = 0; i <= r; i++) {
            slidWindowFrequency[sChar[i] - 'a']++;
        }
        char[] pChar = p.toCharArray();
        int length = sChar.length;

        while (l < length && r < length) {
            boolean isAnagram = isAnagram(slidWindowFrequency, count, pChar);
            if (isAnagram) {
                indices.add(l);
            }
            if (r + 1 == length) {
                break;
            }
            r++;
            slidWindowFrequency[sChar[r] - 'a']++;
            slidWindowFrequency[sChar[l] - 'a']--;
            l++;
        }
        return indices;
    }

    private boolean isAnagram(int[] slidWindowFrequency, int[] count, char[] pChar) {
        for (char c : pChar) {
            if (count[c-'a'] != slidWindowFrequency[c-'a']){
                return false;
            }
        }
        return true;
    }

    private int[] getFrequency(String p) {
        int[] frequency = new int[26];
        for (char c : p.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }

    /*private boolean isAnagram(int[] frequency, char[] pChar) {
        boolean isAnagram = true;
        for (char c : pChar) {
            if (frequency[c - 'a'] == 0) {
                isAnagram = false;
            }
        }
        return isAnagram;
    }*/

    // 	Time Limit Exceeded
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if (p.length() > s.length()) {
            return indices;
        }
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        int left = 0;
        int right = p.length() - 1;
        while (left < s.length() && right < s.length()) {
            // check if sChar[left,right] is anagram
            if (isAnagrams(sChar, left, right, pChar)) {
                indices.add(left);
            }
            left++;
            right++;

        }
        return indices;
    }

    private boolean isAnagrams(char[] sChar, int left, int right, char[] pChar) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            Integer orDefault = characterIntegerMap.getOrDefault(sChar[i], 0);
            orDefault++;
            characterIntegerMap.put(sChar[i], orDefault);
        }
        Map<Character, Integer> cMap = new HashMap<>();
        for (char c : pChar) {
            Integer orDefault = cMap.getOrDefault(c, 0);
            orDefault++;
            cMap.put(c, orDefault);
        }
        for (Character key : cMap.keySet()) {
            if (!characterIntegerMap.containsKey(key) || characterIntegerMap.get(key) != cMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    // 	Time Limit Exceeded
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
        if (s.equals(p)) {
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

}