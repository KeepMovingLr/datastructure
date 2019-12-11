package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_39_CombinationSum.java, v 0.1 2019‐12‐08 3:04 PM enyi.lr Exp $$
 */
public class S_39_CombinationSum_4 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        // recursive termination condition is candidates[0] > target, as all numbers are positive integers.
        boolean hasAnswer = candidates[0] <= target;
        if (!hasAnswer) {
            return result;
        }
        for (int i = start; i < candidates.length; i++) {
            int selected = candidates[i];
            if (selected > target) {
                return result;
            }
            if (target == selected) {
                List<Integer> oneAnswer = new ArrayList<>();
                oneAnswer.add(target);
                result.add(oneAnswer);
                // as the array is sorted, so this case, we can return immediately
                return result;
            } else {
                // candidates[0] <= target-selected 减枝操作
                if (candidates[0] <= target - selected) {
                    List<List<Integer>> lists = combinationSum(candidates, target - selected, i);
                    for (List<Integer> list : lists) {
                        list.add(selected);
                        result.add(list);
                    }
                }
            }

        }
        return result;
    }

}