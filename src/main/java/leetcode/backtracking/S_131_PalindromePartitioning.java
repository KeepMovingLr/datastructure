package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_131_PalindromePartitioning.java, v 0.1 2019‐12‐09 12:46 PM enyi.lr Exp $$
 */
public class S_131_PalindromePartitioning {

    public static void main(String[] args) {
        S_131_PalindromePartitioning palindromePartitioning = new S_131_PalindromePartitioning();
        List<List<String>> aab = palindromePartitioning.partitionHelper("bb");
        System.out.println(aab);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = partitionHelper(s);
        for (List<String> list : result) {
            Collections.reverse(list);
        }
        return result;
    }

    public List<List<String>> partitionHelper(String s) {
        List<List<String>> result = new ArrayList<>();
        if (null == result) {
            return result;
        }
        // the recursive termination
        if (s.length() == 1) {
            List<String> oneAnswer = new ArrayList<>();
            oneAnswer.add(s);
            result.add(oneAnswer);
            return result;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            String substring = s.substring(0, i);
            if (isPalindrome(substring)) {
                if (substring.length() == s.length()) {
                    List<String> oneAnswer = new ArrayList<>();
                    oneAnswer.add(substring);
                    result.add(oneAnswer);
                } else {
                    List<List<String>> partition = partitionHelper(s.substring(i));
                    for (List<String> list : partition) {
                        list.add(substring);
                    }
                    result.addAll(partition);
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}