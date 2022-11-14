package lc.collection.usemapsolve;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution451.java, v 0.1 2019‐05‐29 8:29 PM enyi.lr Exp $$
 */
public class Solution451 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.getOrDefault(chars[i], 0);
            count++;
            map.put(chars[i], count);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue().intValue() > o2.getValue().intValue()) {
                    return -1;
                } else if (o1.getValue().intValue() == o2.getValue().intValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Map<Character, Integer> resultMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> mapEntry : list) {
            resultMap.put(mapEntry.getKey(), mapEntry.getValue());
        }
        StringBuilder result = new StringBuilder();
        for (Character key : resultMap.keySet()) {
            Integer integer = resultMap.get(key);
            for (Integer i = 0; i < integer; i++) {
                result.append(key);
            }
        }
        return result.toString();
    }

}