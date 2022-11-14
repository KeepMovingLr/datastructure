package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_39_CombinationSum.java, v 0.1 2019‐12‐08 3:04 PM enyi.lr Exp $$
 */
public class S_39_CombinationSum_3 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = 0; i < candidates.length; i++) {
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
                if (candidates[0] <= target-selected){
                    List<List<Integer>> lists = combinationSum(candidates, target - selected);
                    for (List<Integer> list : lists) {
                        // 这里由于需要去除，是否可以优化？
                        list.add(selected);
                        Collections.sort(list);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }

        }
        return result;
    }

}