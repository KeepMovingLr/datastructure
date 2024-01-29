package array.prefix;

// 小而美的算法技巧：前缀和/差分数组
public class PreFix {

    // prefix Sum
    public void PrefixSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
}
