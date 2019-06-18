package leetcode.heap.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution215.java, v 0.1 2019‐05‐21 12:41 AM enyi.lr Exp $$
 */
public class Solution215_sort {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        Integer integer = list.get(nums.length - k);
        return integer;
    }

}