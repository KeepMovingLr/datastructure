package leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_47_PermutationsII.java, v 0.1 2019‐12‐07 7:53 PM enyi.lr Exp $$
 */
public class S_47_PermutationsII_2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        S_47_PermutationsII s_47_permutationsII = new S_47_PermutationsII();
        List<List<Integer>> lists = s_47_permutationsII.permuteUnique(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            if (!res.contains(list)) {
                res.add(list);
            }
        }
        return res;
    }

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
}