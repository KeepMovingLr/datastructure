package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_46_Permutations.java, v 0.1 2019‐12‐07 6:00 PM enyi.lr Exp $$
 */
public class S_46_Permutations_2 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        return permuteSum(nums, used);

    }

    public List<List<Integer>> permuteSum(int[] nums, boolean[] used) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (onlyOneCanBeUsed(used)) {
            List<Integer> oneResult = new ArrayList<>();
            oneResult.add(getCanSelectedOne(nums, used));
            result.add(oneResult);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                int selected = nums[i];
                used[i] = true;
                List<List<Integer>> lists = permuteSum(nums, used);
                for (List<Integer> list : lists) {
                    list.add(selected);
                }
                result.addAll(lists);
                used[i] = false;
            }
        }
        return result;
    }

    private Integer getCanSelectedOne(int[] nums, boolean[] used) {
        int res = -1;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                res = i;
            }
        }
        return nums[res];
    }

    private boolean onlyOneCanBeUsed(boolean[] used) {
        int count = 0;
        for (boolean b : used) {
            if (!b) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        S_46_Permutations permutations = new S_46_Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }

}