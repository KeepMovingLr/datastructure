package leetcode.array;

import java.util.Arrays;

/**
 * @author enyi.lr
 * @version $Id: S_1099_TwoSumLessThanK.java, v 0.1 2019‐12‐16 3:10 PM enyi.lr Exp $$
 */
public class S_1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        if (A[0] > K) {
            return -1;
        }
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum >= K) {
                right--;
            } else {
                result = Math.max(result, sum);
                left++;
            }
        }
        if (result == Integer.MIN_VALUE){
            return -1;
        }
        return result;
    }

}