package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_216_CombinationSumIII.java, v 0.1 2019‐12‐11 12:57 PM enyi.lr Exp $$
 */
public class S_216_CombinationSumIII_2 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9) {
            return result;
        }
        if (n < 0 && n > 45) {
            return result;
        }
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return combinationSum3(nums, k, n, 0);
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
                // As we must select k number,if k is not 1, it means there is no answer of this condition
                if (k == 1) {
                    List<Integer> oneAnswer = new ArrayList<>();
                    oneAnswer.add(selected);
                    result.add(oneAnswer);
                    // as the number is sorted, so we can return now
                }
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