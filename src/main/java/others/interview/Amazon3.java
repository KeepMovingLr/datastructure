package others.interview;

import jdk.internal.joptsimple.internal.Strings;

/**
 * Amazon is developing a string matching library. <br>
 * You are to develop a service that finds the longest substring that matches a given regex.<br>
 * More formally, you are given two strings, a text string text, and a regex expression regex. <br>
 * The string regex contains exactly one wildcard character(*). A wildcard character (*) matches any sequence of zero or more lowercase English characters.
 * <br> A regex matches some string if it is possible to replace the wildcard character with some sequence of characters such that the regex expression becomes equal to the string.
 * <br> No other character can be changed. For example, regex
 * "abc*bed" matches "alcbed", "abcefgbed" and
 * "abccbcd" whereas it does not match the strings
 * "abebd", "abzbed", "abed". <br>
 * Return the length of the longest substring of text that matches the expression regex. Return -1 if there is no such substring.<br>
 * Note: A substring is a contiguous sequence of characters within a string<br>
 * Example <br>
 * Given text = "hackerrank", regex = "ack*r" <br>
 * The following substrings match regex <br>
 * • "acker", we can replace * with "e" <br>
 * and regex becomes equal to "acker". length = 5 <br>
 * • "ackerr", we can replace * with "er" <br>
 * and regex becomes equal to "ackerr". length = 6 <br>
 * Return the length of the longest matching substring, 6. <br>
 * <p>
 * Function Description <br>
 * Complete the function getLongestMatch in the editor below. <br>
 * getLongestMatch has the following parameters: <br>
 * text: a string regex: a string <br>
 * Returns <br>
 * int: the length of the longest substring of text that matches regex or -1 if there is none <br>
 * Constraints <br>
 * • 1 < | text |, | regex| < 10^6 <br>
 * • text contains lowercase English Letters only. <br>
 * • regex contains lowercase English letters and exactly one wildcard(*) character. <br>
 */
public class Amazon3 {
    public static int getLongestMatch(String text, String regex) {
        String[] res = regex.split("\\*");
        if (res[0] != "" && res[1] != "") {

        }

        return -1;
    }

    public static void main(String[] args) {
        getLongestMatch("abcdef", "*af");
    }
}
