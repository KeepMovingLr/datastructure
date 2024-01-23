package dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.cn/circle/discuss/fReB3T/
 * The 0/1 knapsack problem of size n can be formulated as follows:
 * Given the capacity of the knapsack, and the weights and the values of n objects,
 * choose which objects to include in the knapsack so that the cumulative value of the objects is maximized without exceeding the capacity of the knapsack.
 */
public class Knapsack01 {

    /*******************************************************************************/

    /**
     * recursive method
     *
     * @param capacity
     * @param w
     * @param v
     * @return
     */
    public int knapsack01(int capacity, int[] w, int[] v) {

        return bestValue(w, v, w.length - 1, capacity);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (c <= 0 || index < 0)
            return 0;
        // not select the index object
        int res = bestValue(w, v, index - 1, c);
        // select index
        if (w[index] <= c) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        return res;
    }

    /*******************************************************************************/

    private int[][] memo;

    /**
     * memo[i][c] means 从下标0， i - 1 的物品里任取，放进容量为c的背包，最大价值
     *
     * @param capacity the capacity of the knapsack
     * @param w        the weight of objects
     * @param v        the value of objects
     * @return time complexity O(n*C)
     * space complexity O(n*C)
     */
    public int knapsack01_Top_Down(int capacity, int[] w, int[] v) {
        // the count of the stuff need to be added into knapsack
        int count = w.length;
        this.memo = new int[count][capacity + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return bestValue2(w, v, count - 1, capacity);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue2(int[] w, int[] v, int index, int c) {
        if (c <= 0 || index < 0)
            return 0;
        if (memo[index][c] != -1)
            return memo[index][c];
        // not select the index stuff
        int res = bestValue2(w, v, index - 1, c);
        // select index
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue2(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    /*******************************************************************************/
    /**
     * memo[i][c] means 从下标0， i - 1 的物品里任取，放进容量为c的背包，最大价值
     *
     * @param capacity
     * @param w
     * @param v
     * @return time complexity O(n*C)
     * space complexity O(n*C)
     */
    public int knapsack01_Bottom_Top(int capacity, int[] w, int[] v) {
        // the count of the objects need to be added into knapsack
        int count = w.length;
        int[][] memo = new int[count][capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            memo[0][c] = c >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < count; i++) {
            for (int c = 0; c <= capacity; c++) {
                // not select i
                memo[i][c] = memo[i - 1][c];
                if (c >= w[i]) { // select i, choose the larger one
                    memo[i][c] = Math.max(memo[i][c], v[i] + memo[i - 1][c - w[i]]);
                }
            }
        }
        return memo[count - 1][capacity];
    }

    /*******************************************************************************/
    /**
     * @param capacity
     * @param w
     * @param v
     * @return
     * time complexity O(n*C)
     * space complexity O(C)
     */
    public int knapsack01_Bottom_Top_Optimize(int capacity, int[] w, int[] v) {
        // the count of the objects need to be added into knapsack
        int count = w.length;
        int[] memo = new int[capacity + 1];
        // select index 0 object
        for (int c = capacity; c >= 0; c--) {
            memo[c] = c >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < count; i++) {
            for (int c = capacity; c >= 0; c--) {
                if (c < w[i]) {
                    break;
                }
                // select i
                int value = v[i] + memo[c - w[i]];
                // not select i , then value is memo[c]
                memo[c] = Math.max(memo[c], value);
            }
        }

        return memo[capacity];
    }

    /*******************************************************************************/

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int total = knapsack01.knapsack01_Top_Down(10, new int[]{6, 2, 3, 1}, new int[]{3, 1, 3, 10});
        int total2 = knapsack01.knapsack01_Bottom_Top(10, new int[]{6, 2, 3, 1}, new int[]{3, 1, 3, 10});
        int total3 = knapsack01.knapsack01(10, new int[]{6, 2, 3, 1}, new int[]{3, 1, 3, 10});
        int total4 = knapsack01.knapsack01_Bottom_Top_Optimize(10, new int[]{6, 2, 3, 1}, new int[]{3, 1, 3, 10});
        System.out.println("test total is " + total);
        System.out.println("test total2 is " + total2);
        System.out.println("test total3 is " + total3);
        System.out.println("test total4 is " + total4);
    }
}
