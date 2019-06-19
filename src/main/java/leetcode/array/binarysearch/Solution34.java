package leetcode.array.binarysearch;

/**
 * @author enyi.lr
 * @version $Id: Solution34.java, v 0.1 2019‐06‐19 11:09 PM enyi.lr Exp $$
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        if (length == 1) {
            if (nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
            }
            return result;
        }
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] == target) {
                        result[0] = i;
                    }
                }
                for (int i = mid; i < length; i++) {
                    if (nums[i] == target) {
                        result[1] = i;
                    }
                }
                return result;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return result;
    }

}