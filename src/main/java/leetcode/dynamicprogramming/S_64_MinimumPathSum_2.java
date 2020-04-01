package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author enyi.lr
 * @version $Id: S_64_MinimumPathSum.java, v 0.1 2020‐01‐30 11:30 AM enyi.lr Exp $$
 */
public class S_64_MinimumPathSum_2 {
    class Pair {
        int left;
        int righht;

        public Pair(int left, int righht) {
            this.left = left;
            this.righht = righht;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Pair pair = (Pair) o;
            return left == pair.left &&
                    righht == pair.righht;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, righht);
        }
    }

    /**
     * 动态规划的方式解决此问题
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        Map<Pair, Integer> cache = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        cache.put(new Pair(rows - 1, cols - 1), grid[rows - 1][cols - 1]);
        for (int i = rows - 2; i >= 0; i--) {
            cache.put(new Pair(i, cols - 1), grid[i][cols - 1] + cache.get(new Pair(i + 1, cols - 1)));
        }
        for (int i = cols - 2; i >= 0; i--) {
            cache.put(new Pair(rows - 1, i), grid[rows - 1][i] + cache.get(new Pair(rows - 1, i + 1)));
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int right = cache.get(new Pair(i, j + 1));
                int bottom = cache.get(new Pair(i + 1, j));
                int minValuue = right < bottom ? right : bottom;
                cache.put(new Pair(i, j), grid[i][j] + minValuue);
            }
        }
        return cache.get(new Pair(0, 0));
    }

}