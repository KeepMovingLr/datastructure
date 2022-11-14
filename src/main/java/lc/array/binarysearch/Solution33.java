package lc.array.binarysearch;

/**
 * @author enyi.lr
 * @version $Id: Solution33.java, v 0.1 2019‐06‐19 10:26 PM enyi.lr Exp $$
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = length - 1;
        int mid = left + (right - left) / 2;
        if (nums[right] > nums[left]) {
            // not rotated
            while (left <= right) {
                if (nums[mid] == target) {
                    return mid;
                }
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                mid = left + (right - left) / 2;
            }
            return -1;
        } else {
            // has been rotated
            while (left <= right) {
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[0]) {
                    if (target > nums[mid] || target < nums[left]) {
                        // search on right
                        left = mid + 1;
                    } else {
                        // search on left
                        right = mid - 1;
                    }

                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        // search on right
                        left = mid + 1;
                    } else {
                        // search on left
                        right = mid - 1;
                    }
                }
                mid = left + (right - left) / 2;

            }
            return -1;
        }

    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] arr = {3, 1};
        int index = solution33.search(arr, 1);
        System.out.println(index);
    }

}