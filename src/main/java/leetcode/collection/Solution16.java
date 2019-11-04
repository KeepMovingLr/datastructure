package leetcode.collection;

import array.Array;

import java.util.Arrays;

/**
 * @author enyi.lr
 * @version $Id: Solution16.java, v 0.1 2019‐06‐07 11:44 AM enyi.lr Exp $$
 */
public class Solution16 {
    // O(n3)  brute force
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum2 = nums[i] + nums[j] + nums[k];
                    int distance1 = distance(target, sum);
                    int distance2 = distance(target, sum2);
                    if (distance2 <= distance1) {
                        sum = sum2;
                    }
                }
            }
        }
        return sum;
    }

    public int distance(int a, int b) {
        return Math.abs(a - b);
    }

    public int threeSumClosest2(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        if (sum > target) {
            return sum;
        }
        int sum2 = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];

        if (sum2 < target) {
            return sum2;
        }

        if (sum < target && target < sum2) {
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int newSum = nums[i] + nums[j] + nums[k];
                        int distance1 = distance(target, sum);
                        int distance2 = distance(target, newSum);
                        if (newSum > target) {
                            if (distance2 < distance1) {
                                sum = newSum;
                                break;
                            }
                        } else {
                            if (distance2 < distance1) {
                                sum = newSum;
                            }
                        }

                    }
                }
            }
        }
        return sum;

    }

    public int threeSumClosest3(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        if (sum > target) {
            return sum;
        }
        int sum2 = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];

        if (sum2 < target) {
            return sum2;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    int newSum = nums[i] + nums[j] + nums[k];
                    int distance = distance(target, sum);
                    int distance1 = distance(target, newSum);
                    if (newSum > target) {
                        if (distance1 < distance) {
                            sum = newSum;
                        }
                        break;
                    } else {
                        if (distance1 < distance) {
                            sum = newSum;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] arr = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};

        int i = solution16.threeSumClosest2(arr, 0);
        System.out.println(i);

    }

}