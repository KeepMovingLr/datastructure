package leetcode.collection.usemapsolve;

import array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution49.java, v 0.1 2019‐05‐30 1:28 PM enyi.lr Exp $$
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, String> indexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (indexMap.containsKey(key)) {
                String a = indexMap.get(key);
                a = a + i + "_";
                indexMap.put(key, a);
            } else {
                indexMap.put(key, i + "_");
            }

        }
        Set<String> keySet = indexMap.keySet();
        for (String s : keySet) {
            String[] s1 = indexMap.get(s).split("_");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s1.length; i++) {
                list.add(strs[Integer.parseInt(s1[i])]);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String abc = "bad";
        char[] chars = abc.toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        System.out.println(s);

    }

}