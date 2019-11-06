package leetcode.collection.usemapsolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution49.java, v 0.1 2019‐05‐30 1:28 PM enyi.lr Exp $$ v2
 */
public class Solution49 {

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution49.groupAnagrams2(strs);
        System.out.println(lists);

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<List<Integer>, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            List<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 < chars.length; i1++) {
                list.add((int) chars[i1]);
            }
            Collections.sort(list);
            List<Integer> indics = index.getOrDefault(list, new ArrayList<>());
            indics.add(i);
            index.put(list, indics);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> list : index.keySet()) {
            List<Integer> indics = index.get(list);
            List<String> res = new ArrayList<>();
            for (Integer indic : indics) {
                res.add(strs[indic]);
            }
            result.add(res);
        }
        return result;
    }

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

}