package lc.backtracking;

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
        Map<String, String> dic = new HashMap<>();
        dic.put("2", "abc");
        dic.put("3", "def");
        dic.put("4", "ghi");
        dic.put("5", "jkl");
        dic.put("6", "mno");
        dic.put("7", "pqrs");
        dic.put("8", "tuv");
        dic.put("9", "wxyz");
        List<List<String>> combinations = getCombinations(digits, dic);
        for (List<String> combination : combinations) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : combination) {
                stringBuilder.append(s);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public List<List<String>> getCombinations(String digits, Map<String, String> dic) {
        List<List<String>> result = new ArrayList<>();
        if (digits.length() == 1) {
            String s = dic.get(digits);
            for (char c : s.toCharArray()) {
                List<String> one = new ArrayList<>();
                one.add(String.valueOf(c));
                result.add(one);
            }
            return result;
        }
        // combine
        List<List<String>> combinations = getCombinations(digits.substring(digits.length() - 1), dic);
        List<List<String>> combinations1 = getCombinations(digits.substring(0, digits.length() - 1), dic);
        for (List<String> combination : combinations) {
            for (List<String> list : combinations1) {
                List<String> oneAnswer = new ArrayList<>();
                oneAnswer.addAll(list);
                oneAnswer.addAll(combination);
                result.add(oneAnswer);
            }
        }
        return result;
    }

}