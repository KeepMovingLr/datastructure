package lc.collection;

import java.util.Arrays;

/**
 * @author enyi.lr
 * @version $Id: Solution259.java, v 0.1 2019‐11‐04 2:59 PM enyi.lr Exp $$ v2
 */
public class Solution259_3SumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumSmaller2(int[] nums, int target) {
        int result = 0;
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int need = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                result = result + binarySearchSmaller(nums, j, nums.length - 1, need);
            }
        }
        return result;
    }

    public int binarySearchSmaller(int[] num, int start, int end, int target) {
        int result = 0;
        while (start < end) {
            int sum = num[start] + num[end];
            if (sum < target) {
                result = result + (end - start);
                start++;
            } else {

            }
        }

        return result;
    }

}