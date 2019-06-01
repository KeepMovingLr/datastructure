package leetcode.segmenttree;

/**
 * @author enyi.lr
 * @version $Id: NumArray2.java, v 0.1 2019‐06‐01 4:38 PM enyi.lr Exp $$
 */
public class NumArray2 {
    // Use sum[i] to save the sum of first i elements  sum[0] = 0;
    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}