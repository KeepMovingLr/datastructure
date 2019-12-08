package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: S_17_LetterCombinationsofaPhoneNumber.java, v 0.1 2019‐12‐07 4:40 PM enyi.lr Exp $$
 */
public class S_17_LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<List<String>> combinations = getCombinations(digits, map);
        for (List<String> combination : combinations) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : combination) {
                stringBuilder.append(s);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public List<List<String>> getCombinations(String digits, Map<String, String> map) {
        List<List<String>> result = new ArrayList<>();
        if (digits.length() == 1) {
            String s = map.get(digits);
            for (char c : s.toCharArray()) {
                List<String> one = new ArrayList<>();
                one.add(String.valueOf(c));
                result.add(one);
            }
            return result;
        }
        // combine
        List<List<String>> combinations = getCombinations(digits.substring(digits.length() - 1), map);
        List<List<String>> combinations1 = getCombinations(digits.substring(0, digits.length() - 1), map);
        for (List<String> combination : combinations) {
            for (List<String> list : combinations1) {
                List<String> one = new ArrayList<>();
                one.addAll(list);
                one.addAll(combination);
                result.add(one);
            }
        }
        return result;
    }

}