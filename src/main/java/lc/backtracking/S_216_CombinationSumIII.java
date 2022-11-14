package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_216_CombinationSumIII.java, v 0.1 2019‐12‐11 12:57 PM enyi.lr Exp $$
 */
public class S_216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9) {
            return result;
        }
        if (n < 0 && n > 45) {
            return result;
        }
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> lists = combinationSum3(nums, k, n, 0);
        for (List<Integer> list : lists) {
            if (list.size() == k) {
                result.add(list);
            }
        }
        return result;
    }

    public List<List<Integer>> combinationSum3(int[] nums, int k, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        // recursive termination condition
        if (k == 0) {
            return result;
        }
        if (start >= nums.length) {
            return result;
        }
        if (nums[start] > target) {
            return result;
        }

        for (int i = start; i < nums.length; i++) {
            int selected = nums[i];
            if (selected == target) {
                List<Integer> oneAnswer = new ArrayList<>();
                oneAnswer.add(selected);
                result.add(oneAnswer);
                // as the number is sorted, so we can return now
                return result;
            }
            List<List<Integer>> lists = combinationSum3(nums, k - 1, target - selected, i + 1);
            for (List<Integer> list : lists) {
                list.add(selected);
            }
            result.addAll(lists);
        }
        return result;
    }

}