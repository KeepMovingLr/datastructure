package leetcode.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution18.java, v 0.1 2019‐06‐07 9:38 AM enyi.lr Exp $$
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int second = nums[i1];
                for (int j = i1 + 1; j < nums.length; j++) {
                    int third = nums[j];
                    for (int k = j + 1; k < nums.length; k++) {
                        if (first + second + third + nums[k] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(first);
                            list.add(second);
                            list.add(third);
                            list.add(nums[k]);
                            Collections.sort(list);
                            if (!result.contains(list)) {
                                result.add(list);
                            }
                        }

                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > target) {
            return result;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int second = nums[i1];
                for (int j = i1 + 1; j < nums.length; j++) {
                    int third = nums[j];
                    int need = target - first - second - third;
                    if (set.contains(need)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(first);
                        list.add(second);
                        list.add(third);
                        list.add(need);
                        Collections.sort(list);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
            set.add(first);

        }
        return result;
    }

}