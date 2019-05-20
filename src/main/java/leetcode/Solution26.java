package leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution26.java, v 0.1 2019‐05‐19 10:40 PM enyi.lr Exp $$
 */
public class Solution26 {

    public int removeDuplicates2(int[] nums) {
        // use [0,k) save the un duplicate element has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!contains(nums, k, nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * check if nums[0,index) contains value
     *
     * @param nums
     * @param index
     * @param value
     * @return
     */
    private boolean contains(int[] nums, int index, int value) {
        for (int i = 0; i < index; i++) {
            if (nums[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int removeDuplicates1(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int begin = 0;
        for (Integer value : set) {
            nums[begin] = value;
            begin++;
        }
        return set.size();
    }

}