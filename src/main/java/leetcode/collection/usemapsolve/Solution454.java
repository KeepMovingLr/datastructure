package leetcode.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution454.java, v 0.1 2019‐05‐30 1:22 PM enyi.lr Exp $$
 */
public class Solution454 {

    // time complicity O(n2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                int sum = C[i] + D[j];
                if (countMap.get(sum) == null) {
                    countMap.put(sum, 1);
                } else {
                    int count = countMap.get(sum);
                    count++;
                    countMap.put(sum, count);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (countMap.containsKey(0 - sum)) {
                    int re = countMap.get(0 - sum);
                    result = result + re;
                }

            }

        }
        return result;
    }

}