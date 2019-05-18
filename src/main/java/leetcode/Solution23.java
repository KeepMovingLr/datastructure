package leetcode;

/**
 * @author enyi.lr
 * @version $Id: Solution23.java, v 0.1 2019‐05‐19 12:09 AM enyi.lr Exp $$
 */
public class Solution23 {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; ) {
            if (nums[i] == val) {
                nums[i] = nums[size - 1];
                size--;
            } else {
                i++;
            }

        }
        return size;

    }
}