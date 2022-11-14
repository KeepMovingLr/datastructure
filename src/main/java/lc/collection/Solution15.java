package lc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author enyi.lr  how to deal with problem using set and map
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$
 */
public class Solution15 {

    // O(square（n))
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length >= 3 && nums[0] == nums[nums.length - 1]) {
            if (nums[0] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                lists.add(list);
                return lists;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int need = 0 - sum;
                if (set.contains(need)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(need);
                    Collections.sort(list);
                    if (!lists.contains(list)) {
                        lists.add(list);

                    }
                }
            }
            set.add(nums[i]);
        }
        return lists;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        return lists;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        //int[] arrays = {-1, 0, 1, 2, -1, -4};
        int[] arrays = {-2, 0, 1, 1, 2};
        List<List<Integer>> lists = solution15.threeSum(arrays);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }

}