package leetcode;

/**
 * @author enyi.lr
 * @version $Id: Solution88.java, v 0.1 2019‐05‐21 12:40 AM enyi.lr Exp $$
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int k = 0;
        int j = 0;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        for (int i = 0; i < m + n; i++) {
            if (nums1[k] <= nums2[j]) {
                nums[i] = nums1[k];
                k++;
                if (k == m) {
                    break;
                }
            } else {
                nums[i] = nums2[j];
                j++;
                if (j == n) {
                    break;
                }
            }
        }
        int index = 0;
        if (k == m) {
            for (int i = j; i < n; i++) {
                nums[m + j + index] = nums2[i];
                index++;
            }
        }
        index = 0;
        if (j == n) {
            for (int i = k; i < m; i++) {
                nums[n + k + index] = nums1[i];
                index++;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
        }

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        /*int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        solution88.merge(num1, 3, num2, 3);*/

        int[] num1 = {};
        int[] num2 = {};
        solution88.merge(num1, 1, num2, 0);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }

}