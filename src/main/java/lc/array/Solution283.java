package lc.array;

/**
 * @author enyi.lr
 * @date 2019/10/24 9:54 PM
 * @description ${DESCRIPTION}
 */
public class Solution283 {

    // time complexity O(n)
    // space complexity O(n)
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[size] = num;
                size++;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

    // time complexity O(n)
    // space complexity O(1)
    public void moveZeroes2(int[] nums) {
        // use firstZero to represent the first zero of the zero list
        int firstZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (firstZero != -1) {
                    // swap
                    swap(nums, i, firstZero);
                    firstZero++;
                }
            } else {
                if (firstZero == -1) {
                    firstZero = i;
                }
            }

        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
