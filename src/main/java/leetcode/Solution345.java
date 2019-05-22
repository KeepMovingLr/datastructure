package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution344.java, v 0.1 2019‐05‐20 12:11 AM enyi.lr Exp $$
 */
public class Solution345 {

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (!vowels.contains(chars[i]) && i < j) {
                i++;
            }
            while (!vowels.contains(chars[j]) && i < j) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            if (i < chars.length) {
                i++;
            }
            if (j > 0) {
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "aA";
        System.out.println(reverseVowels(input));
    }
}