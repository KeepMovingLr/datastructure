package lc.collection.usemapsolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution350.java, v 0.1 2019‐05‐23 2:02 AM enyi.lr Exp $$ v2 2019‐10‐23
 */
public class Solution350 {

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            Integer count = map1.getOrDefault(i, 0);
            count++;
            map1.put(i, count);
        }
        for (int i : nums2) {
            Integer count = map2.getOrDefault(i, 0);
            count++;
            map2.put(i, count);
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Integer key1 : map1.keySet()) {
            if (map2.containsKey(key1)) {
                Integer count1 = map1.get(key1);
                Integer count2 = map2.get(key1);
                if (count1 < count2) {
                    resultMap.put(key1, count1);
                } else {
                    resultMap.put(key1, count2);
                }
            }
        }
        int total = 0;
        for (Integer resultKey : resultMap.keySet()) {
            total = total + resultMap.get(resultKey);
        }
        int[] result = new int[total];
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : resultMap.entrySet()) {
            Integer repeatedTimes = integerIntegerEntry.getValue();
            for (int i = 0; i < repeatedTimes; i++) {
                list.add(integerIntegerEntry.getKey());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer orDefault = map1.getOrDefault(nums1[i], 0);
            orDefault++;
            map1.put(nums1[i], orDefault);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i])) {
                Integer count = map1.get(nums2[i]);
                if (count > 0) {
                    Integer orDefault = resultMap.getOrDefault(nums2[i], 0);
                    orDefault++;
                    resultMap.put(nums2[i], orDefault);
                    count--;
                    map1.put(nums2[i], count);
                }
            }
        }
        int total = 0;
        for (Integer key : resultMap.keySet()) {
            total = total + resultMap.get(key);
        }
        int[] result = new int[total];
        int j = 0;
        for (Integer key : resultMap.keySet()) {
            for (int i = 0; i < resultMap.get(key); i++) {
                result[j] = key;
                j++;
            }

        }
        return result;
    }

}