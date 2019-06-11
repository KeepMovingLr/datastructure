package leetcode.array;

/**
 * @author enyi.lr
 * @version $Id: Solution27.java, v 0.1 2019‐05‐19 10:34 PM enyi.lr Exp $$
 */
public class Solution27 {
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

    public int removeElement2(int[] nums, int val) {
        // use nums[0,k) to save the elements has been traversed that satisfy the condition
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkNotEqual(nums[i], val)) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        return k;
    }

    private boolean checkNotEqual(int value1, int value2) {
        if (value1 == value2) {
            return false;
        } else {
            return true;
        }
    }
}