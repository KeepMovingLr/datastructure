package leetcode.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution209.java, v 0.1 2019‐05‐22 10:28 PM enyi.lr Exp $$
 */
public class Solution209 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solution209 solution209 = new Solution209();
        int i = solution209.minSubArrayLen(7, nums);
        System.out.println(i);
        int[] nums2 = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        System.out.println(solution209.minSubArrayLen(15, nums2));
        int[] nums3 = {5};
        System.out.println(solution209.minSubArrayLen(5, nums3));
        int[] nums4 = {5};
        System.out.println(solution209.minSubArrayLen(6, nums4));
    }

    public int minSubArrayLen(int s, int[] nums) {
        return minSubArrayLen2(s, nums);
    }

    public int minSubArrayLen2(int s, int[] nums) {
        // nums[l,r] contains our satisfied value
        int left = 0;
        int right = -1;
        int minLength = nums.length + 100;
        int sum = 0;
        while (left < nums.length) {
            if (sum < s && right + 1 < nums.length) {
                right++;
                sum = sum + nums[right];
            } else {
                sum = sum - nums[left];
                left++;
            }
            if (sum >= s) {
                minLength = getMin(minLength, right - left + 1);
            }
        }
        if (minLength == nums.length + 100) {
            return 0;
        } else {
            return minLength;
        }

    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= s) {
                return 1;
            } else {
                return 0;
            }
        }
        if (nums[0] >= s) {
            return 1;
        }
        int minLength = nums.length + 100;
        // use [i,j] to save the index which satisfied the problem
        int i = 0;
        int j = 1;
        int sum = getSum(nums, i, j);
        while (i < nums.length) {
            while (sum < s && j < nums.length) {
                j++;
                if (j == nums.length) {
                    if (minLength == nums.length + 100) {
                        return 0;
                    }
                    return minLength;
                }
                sum = getSum(nums, i, j);
            }
            int minLength2 = j - i + 1;
            minLength = getMin(minLength, minLength2);
            i++;
            sum = getSum(nums, i, j);
            while (sum >= s) {
                int minLength3 = j - i + 1;
                minLength = getMin(minLength, minLength3);
                if (i != j) {
                    i++;
                    sum = getSum(nums, i, j);
                } else {
                    return 1;
                }

            }

        }
        if (minLength == nums.length + 100) {
            return 0;
        }
        return minLength;
    }

    private int getSum(int[] nums, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    private int getMin(int x, int y) {
        if (x <= y) {
            return x;
        } else {
            return y;
        }
    }

}