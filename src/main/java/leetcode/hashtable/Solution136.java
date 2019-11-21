package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution136.java, v 0.1 2019‐11‐21 7:34 PM enyi.lr Exp $$
 * v2
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (Integer result : set) {
            return result;
        }
        return -1;
    }

}