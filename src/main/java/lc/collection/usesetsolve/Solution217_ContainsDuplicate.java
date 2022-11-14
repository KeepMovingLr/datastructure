package lc.collection.usesetsolve;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr  how to deal with problem using set and map
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$
 * v2
 */
public class Solution217_ContainsDuplicate {

    // time complexity O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                return true;
            } else {
                integers.add(nums[i]);
            }
        }
        return false;
    }
}