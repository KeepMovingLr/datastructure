package leetcode.array.binarysearch;

/**
 * @author enyi.lr
 * @version $Id: Solution157.java, v 0.1 2019‐06‐19 7:18 PM enyi.lr Exp $$
 */
public class Solution153 {

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            // if right is smaller than left,  it is the smallest
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] < nums[0]) {
                // min is at the right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

}