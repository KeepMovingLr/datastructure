package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_46_Permutations.java, v 0.1 2019‐12‐07 6:00 PM enyi.lr Exp $$
 */
public class S_46_Permutations {

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
        if (nums.size() == 1){
            List<Integer> oneResult = new ArrayList<>();
            oneResult.add(nums.get(0));
            result.add(nums);
            return result;
        }
        for (int i = 0; i < nums.size(); i++) {
            int selected = nums.get(i);
            List<Integer> left = new ArrayList<>();
            for (Integer num : nums) {
                if (num != selected) {
                    left.add(num);
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

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        S_46_Permutations permutations = new S_46_Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        System.out.println(permute);
    }


}