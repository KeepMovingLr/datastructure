package lc.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: FibonacciSequence.java, v 0.1 2020‐01‐08 1:16 PM enyi.lr Exp $$
 */
public class FibonacciSequence {
    /**
     * Fibonacci sequence f(0)=0 f(1)=1 f(n) = f(n-1)+f(n-2)
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return -1;
    }

    /**
     * 记忆化搜索的方式，自顶向下
     *
     * @param n
     * @return
     */
    Map<Integer, Integer> memoryMap = new HashMap<>();
    public int fibonacci2(int n) {
        for (int i = 0; i < n + 1; i++) {
            memoryMap.put(i, -1);
        }
        if (n == 0) {
            memoryMap.put(0, 0);
        }
        if (n == 1) {
            memoryMap.put(1, 1);
        }
        if (memoryMap.get(n) == -1) {
            memoryMap.put(n, fibonacci2(n - 1) + fibonacci2(n - 2));
        }
        return memoryMap.get(n);
    }

    /**
     * 动态规划，自底向上
     *
     * @param n
     * @return
     */
    public int fibonacci3(int n) {
        int[] memory = new int[n + 1];
        memory[0] = 0;
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.fibonacci(10));
        System.out.println(fibonacciSequence.fibonacci2(10));
        System.out.println(fibonacciSequence.fibonacci3(10));
    }

}