package leetcode.array.twopointer.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution76.java, v 0.1 2019‐05‐23 1:51 AM enyi.lr Exp $$
 * v2 2019‐10‐31
 */
public class S_76_MinimumWindowSubstring {

    public static void main(String[] args) {
        S_76_MinimumWindowSubstring solution76 = new S_76_MinimumWindowSubstring();
        String s = solution76.minWindow2("ADOBECODEBANC", "ABC");
        System.out.println(s);



    }

    public String minWindow2(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (t.equals(s)) {
            return t;
        }
        String result = s + t + "aaaa";
        Map<Character, Integer> characterFrequency = getCharacterFrequency(t);
        int[] windowFrequency = new int[256];
        // user windowFrequency[l,r] to reserve
        int left = 0;
        int right = -1;
        char[] chars = s.toCharArray();
        while (right < s.length() && left < s.length()) {
            if (satisfiedResult(windowFrequency, characterFrequency)) {
                if ((right - left + 1) < result.length()) {
                    StringBuilder res = new StringBuilder();
                    for (int j = left; j <= right; j++) {
                        res.append(chars[j]);
                    }
                    result = res.toString();
                }
                windowFrequency[chars[left]]--;
                left++;
            } else {
                right++;
                if (right < s.length()) {
                    windowFrequency[chars[right]]++;
                } else {
                    break;
                }
            }
        }
        if (result.length() == (s.length() + t.length() + 4)) {
            return "";
        } else {
            return result;
        }

    }

    private boolean satisfiedRe(int[] windowFrequency, int[] characterFrequencyArray, String t) {
        for (char c : t.toCharArray()) {
            if (characterFrequencyArray[c] > windowFrequency[c]){
                return false;
            }
        }
        return true;
    }

    private int[] getCharacterFrequencyArray(String t) {
        int[] frequency = new int[256];
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            frequency[aChar]++;
        }
        return frequency;
    }

    private boolean satisfiedResult(int[] windowFrequency, Map<Character, Integer> characterFrequency) {
        for (Character key : characterFrequency.keySet()) {
            if (windowFrequency[key] < characterFrequency.get(key)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharacterFrequency(String t) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            int count = characterFrequency.getOrDefault(c, 0);
            count++;
            characterFrequency.put(c, count);
        }
        return characterFrequency;
    }

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



}