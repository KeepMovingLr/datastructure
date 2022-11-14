package lc.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution454.java, v 0.1 2019‐05‐30 1:22 PM enyi.lr Exp $$ v2
 */
public class Solution454 {

    public static void main(String[] args) {
        // [-1,-1]
        //[-1,1]
        //[-1,1]
        //[1,-1]
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        Solution454 solution454 = new Solution454();
        int count = solution454.fourSumCount3(A, B, C, D);
        System.out.println(count);
    }

    public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                Integer count = countMap.getOrDefault(key, 0);
                count++;
                countMap.put(key, count);
            }
        }
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                Integer count = countMap2.getOrDefault(key, 0);
                count++;
                countMap2.put(key, count);
            }
        }

        for (Integer key : countMap.keySet()) {
            int condition1 = countMap.get(key);
            int condition2 = countMap2.getOrDefault((0 - key), 0);
            result = result + condition1 * condition2;
        }
        return result;
    }

    // time complicity o(n^2)
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                Integer count = countMap.getOrDefault(key, 0);
                count++;
                countMap.put(key, count);
            }

        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                result = result + countMap.getOrDefault(0 - sum, 0);
            }
        }
        return result;
    }

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