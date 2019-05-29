package leetcode.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution350.java, v 0.1 2019‐05‐23 2:02 AM enyi.lr Exp $$
 */
public class Solution350 {
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