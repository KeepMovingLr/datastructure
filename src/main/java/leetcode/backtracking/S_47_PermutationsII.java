package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_47_PermutationsII.java, v 0.1 2019‐12‐07 7:53 PM enyi.lr Exp $$
 */
public class S_47_PermutationsII {

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
        List<Integer> needPermute = new ArrayList<>();
        for (int num : nums) {
            needPermute.add(num);
        }
        return permuteSub(needPermute);
    }

    public List<List<Integer>> permuteSub(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 0) {
            return result;
        }
        if (nums.size() == 1) {
            List<Integer> oneResult = new ArrayList<>();
            oneResult.add(nums.get(0));
            result.add(nums);
            return result;
        }
        for (int i = 0; i < nums.size(); i++) {
            int selected = nums.get(i);
            List<Integer> left = new ArrayList<>();
            for (int i1 = 0; i1 < nums.size(); i1++) {
                if (i1 != i){
                    left.add(nums.get(i1));
                }
            }
            List<List<Integer>> lists = permuteSub(left);
            for (List<Integer> list : lists) {
                list.add(selected);
            }
            result.addAll(lists);
        }
        return result;

    }
}