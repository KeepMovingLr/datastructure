package lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: S_238_Product_ofArrayExceptSelf.java, v 0.1 2020‐01‐29 6:45 PM enyi.lr Exp $$
 */
public class S_238_Product_ofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        Set<Integer> zeroIndex = new HashSet<>();
        int[] res = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
            }
            if (zeroIndex.size() > 1) {
                return res;
            }
            sum = sum * nums[i];
        }

        if (zeroIndex.size() == 0) {
            for (int i = 0; i < res.length; i++) {
                res[i] = sum / nums[i];
            }
        } else {
            for (Integer index : zeroIndex) {
                int sum2 = 1;
                for (int i = 0; i < nums.length; i++) {
                    if (i != index) {
                        sum2 = sum2 * nums[i];
                    }
                }
                res[index] = sum2;
            }
        }

        return res;
    }

    /**
     * 动态规划的思想解决这个问题
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}