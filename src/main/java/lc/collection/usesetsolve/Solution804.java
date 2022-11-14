package lc.collection.usesetsolve;

import java.util.TreeSet;

/**
 * @author enyi.lr
 * @date 2019/10/21 11:27 PM
 * @description ${DESCRIPTION}
 * v2
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word : words) {
            StringBuilder trans = new StringBuilder();
            for (char c : word.toCharArray()) {
                int re = c;
                trans.append(codes[c - 97]);
            }
            treeSet.add(trans.toString());
        }
        return treeSet.size();
    }

    public static void main(String[] args) {
        Solution804 solution804 = new Solution804();
        String[] words = {"ab", "cd"};
        System.out.println(solution804.uniqueMorseRepresentations(words));
    }
}
