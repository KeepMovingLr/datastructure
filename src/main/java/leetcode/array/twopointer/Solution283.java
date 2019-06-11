package leetcode.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution283.java, v 0.1 2019‐05‐19 9:39 PM enyi.lr Exp $$
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {

    }

    public void moveZeroes3(int[] nums) {
        // use [0,k) save the non zero element that has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkNonZore(nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }



    public void moveZeroes4(int[] nums) {
        // use [0,k) save the non zero element that has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkNonZore(nums[i])) {
                // swap
                if (k != i) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    private boolean checkNonZore(int digit) {
        if (digit != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void moveZeroes2(int[] nums) {
        int[] nonZeroElement = new int[nums.length];
        int begin = 0;
        for (int num : nums) {
            if (num != 0) {
                nonZeroElement[begin] = num;
                begin++;
            }
        }
        for (int i = 0; i < nonZeroElement.length; i++) {
            nums[i] = nonZeroElement[i];
        }
    }

}