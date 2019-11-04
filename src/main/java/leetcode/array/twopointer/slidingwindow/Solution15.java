package leetcode.array.twopointer.slidingwindow;

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
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$ v2
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        Solution15 solution15 = new Solution15();
        for (List<Integer> list : solution15.threeSum3_optmize(nums)) {
            System.out.println(list);
        }
        /*int[] nums2 = {0, 0, 0, 0};
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
        }*/

    }



    // convert 3sum to 2sum  Time Limit Exceeded
    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int twoSumTarget = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            for (int i1 = 0; i1 < nums.length; i1++) {
                // remove i itself
                if (i1 == i) {
                    continue;
                }
                int need = twoSumTarget - nums[i1];
                if (set.contains(need)) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[i1]);
                    oneResult.add(need);
                    Collections.sort(oneResult);
                    if (!result.contains(oneResult)) {
                        result.add(oneResult);
                    }
                } else {
                    set.add(nums[i1]);
                }
            }
        }
        return result;
    }

    // force  Time Limit Exceeded
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (satisfied(nums[i], nums[j], nums[k])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
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

    private boolean satisfied(int num, int num1, int num2) {
        return (num + num1 + num2) == 0;
    }

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

    // great method: the method is similar to binary search
    public List<List<Integer>> threeSum3_optmize(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return res;
        }
        // sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[l]);
                    oneResult.add(nums[r]);
                    result.add(oneResult);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        for (List<Integer> list : result) {
            res.add(list);
        }
        return res;
    }


    // great method: the method is similar to binary search
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

    class Pair {
        int index1;
        int index2;

        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        /**
         * Getter method for property <tt>index1</tt>.
         *
         * @return property value of index1
         */
        public int getIndex1() {
            return index1;
        }

        /**
         * Setter method for property <tt>index1</tt>.
         *
         * @param index1 value to be assigned to property index1
         */
        public void setIndex1(int index1) {
            this.index1 = index1;
        }

        /**
         * Getter method for property <tt>index2</tt>.
         *
         * @return property value of index2
         */
        public int getIndex2() {
            return index2;
        }

        /**
         * Setter method for property <tt>index2</tt>.
         *
         * @param index2 value to be assigned to property index2
         */
        public void setIndex2(int index2) {
            this.index2 = index2;
        }
    }

}