package array.prefix;

// 小而美的算法技巧：前缀和/差分数组

/**
 * https://zhuanlan.zhihu.com/p/401865066
 */
public class PreFix {

    // prefix Sum
    public void PrefixSum(int[] nums) {
        // notice here, we can create a nums.length + 1 array
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 如果要求[i...j]之间的数组和，只需要计算preSum[j+1]-preSum[i]即可。
    }

    public void PrefixSum2(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        // calculate [i...j] sum preSum[j] - preSum[i-1], if i == 0, just preSum[j]
    }
}
