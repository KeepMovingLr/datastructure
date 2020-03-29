package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_40_CombinationSumII.java, v 0.1 2019‐12‐08 4:10 PM enyi.lr Exp $$
 */
public class S_40_CombinationSumII_2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        return combinationSum2Helper(candidates, target, used, 0);
    }

    // todo 优化
    public List<List<Integer>> combinationSum2Helper(int[] candidates, int target, boolean[] used, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        int element = getFirstUnusedElement(candidates, used, start);
        // recursive termination condition
        if (element > target) {
            return result;
        }
        for (int i = start; i < candidates.length; i++) {
            if (!used[i]) {
                int selected = candidates[i];
                if (selected > target) {
                    return result;
                }
                if (selected == target) {
                    List<Integer> oneAnswer = new ArrayList<>();
                    oneAnswer.add(selected);
                    Collections.sort(oneAnswer);
                    if (!result.contains(oneAnswer)) {
                        result.add(oneAnswer);
                    }
                } else {
                    used[i] = true;
                    List<List<Integer>> lists = combinationSum2Helper(candidates, target - selected, used, i + 1);
                    for (List<Integer> list : lists) {
                        list.add(selected);
                        result.add(list);
                    }
                    used[i] = false;
                }
            }
        }
        return result;
    }

    private int getFirstUnusedElement(int[] candidates, boolean[] used, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (!used[i]) {
                return candidates[i];
            }
        }
        return 0;
    }

}