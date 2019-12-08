package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_39_CombinationSum.java, v 0.1 2019‐12‐08 3:04 PM enyi.lr Exp $$
 */
public class S_39_CombinationSum {

    public static void main(String[] args) {
        S_39_CombinationSum combinationSum = new S_39_CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum.combinationSum(candidates, 7));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean hasAnswer = false;
        for (int candidate : candidates) {
            if (target >= candidate) {
                hasAnswer = true;
                break;
            }
        }
        if (!hasAnswer) {
            return result;
        }
        for (int i = 0; i < candidates.length; i++) {
            int selected = candidates[i];
            if (target == selected) {
                List<Integer> oneAnswer = new ArrayList<>();
                oneAnswer.add(target);
                result.add(oneAnswer);
            } else {
                List<List<Integer>> lists = combinationSum(candidates, target - selected);
                for (List<Integer> list : lists) {
                    list.add(selected);
                    Collections.sort(list);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }

            }

        }
        return result;
    }

}