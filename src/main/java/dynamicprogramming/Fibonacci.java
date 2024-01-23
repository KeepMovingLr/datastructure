package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fibonacci-number/
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */
public class Fibonacci {

    /************************************************************************************/
    // has a lot of replicate calls
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }


    /************************************************************************************/

    Map<Integer,Integer> map = new HashMap<>();
    public int fib2(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(map.get(n) == null) {
            int res = fib2(n - 1) + fib2(n - 2);
            map.put(n , res);
        }
        return map.get(n);
    }

    /************************************************************************************/

    // bottom up method
    public int fib3(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
