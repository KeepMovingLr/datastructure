package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution70_ClimbingStairs.java, v 0.1 2020‐01‐08 6:38 PM enyi.lr Exp $$
 */
public class Solution70_ClimbingStairs {

    // Time Limit Exceeded
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // Time Limit Exceeded
    Map<Integer, Integer> memoryMap = new HashMap<>();

    public int climbStairs2(int n) {
        for (int i = 0; i < n + 1; i++) {
            memoryMap.put(i, -1);
        }
        if (n == 1) {
            memoryMap.put(1, 1);
        }
        if (n == 2) {
            memoryMap.put(2, 2);
        }
        if (memoryMap.get(n) == -1) {
            memoryMap.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
        }
        return memoryMap.get(n);
    }

    public int climbStairs3(int n) {
        int[] memory = new int[n + 1];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = -1;
        }
        memory[1] = 1;
        if (n == 1) {
            return memory[1];
        }
        memory[2] = 2;
        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
}