package leetcode.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution1.java, v 0.1 2019‐06‐06 5:24 PM enyi.lr Exp $$
 * v2
 */
public class Solution1 {

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.get(need) != null) {
                result[0] = map.get(need);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }


    // time complexity is O(n)  space complexity is O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                result[0] = map.get(need);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}