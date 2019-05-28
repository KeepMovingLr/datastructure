package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        // sort the array
        int l = 0;
        while (l < nums.length - 1) {
            Map<Integer, Integer> resultMap = new HashMap<>();
            int target = 0 - nums[l];
            for (int i = l + 1; i < nums.length; i++) {
                if (resultMap.containsKey(target - nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(target - nums[i]);
                    list.add(nums[i]);
                    Collections.sort(list);
                    result.add(list);
                } else {
                    resultMap.put(nums[i], i);
                }
            }
            l++;
        }

        for (List<Integer> list : result) {
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>() {};
        // sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r && l + 1 < nums.length) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[l]);
                    oneResult.add(nums[r]);
                    result.add(oneResult);
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : result) {
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        for (List<Integer> list : solution15.threeSum(nums)) {
            System.out.println(list);
        }
        int[] nums2 = {0, 0, 0, 0};
        for (List<Integer> list : solution15.threeSum(nums2)) {
            System.out.println(list);
        }
        int[] nums3 = {-2, 0, 1, 1, 2};
        for (List<Integer> list : solution15.threeSum(nums3)) {
            System.out.println(list);
        }
        int[] nums4 = {};
        for (List<Integer> list : solution15.threeSum(nums4)) {
            System.out.println(list);
        }

    }

}