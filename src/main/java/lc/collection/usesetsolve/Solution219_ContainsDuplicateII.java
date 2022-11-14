package lc.collection.usesetsolve;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr  how to deal with problem using set and map
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$
 * v2
 */
public class Solution219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // time complicity O(n)
    // space complicity O(k)
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // sliding window size <= k
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // time complexity O(n^2)
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])!=null ){
                if (i - map.get(nums[i]) <= k){
                    return true;
                } else {
                    map.put(nums[i],i);
                }
            } else {
                map.put(nums[i],i);
            }
        }
        return false;
    }

}