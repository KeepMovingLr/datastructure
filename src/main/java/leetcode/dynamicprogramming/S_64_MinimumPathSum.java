package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author enyi.lr
 * @version $Id: S_64_MinimumPathSum.java, v 0.1 2020‐01‐30 11:30 AM enyi.lr Exp $$
 */
public class S_64_MinimumPathSum {
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
     * 记忆化搜索的方式解决这个问题
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        Map<Pair, Integer> cache = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        cache.put(new Pair(rows - 1, cols - 1), grid[rows - 1][cols - 1]);
        return minPathSum(grid, 0, 0, cache);
    }

    public int minPathSum(int[][] grid, int rowNum, int colNum, Map<Pair, Integer> cache) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rowNum == rows - 1 && colNum == cols - 1) {
            return grid[rowNum][colNum];
        }
        int rightMin = Integer.MAX_VALUE;
        int bottomMin = Integer.MAX_VALUE;
        if (cache.get(new Pair(rowNum, colNum)) == null) {
            if (colNum != cols - 1) {
                if (cache.get(new Pair(rowNum, colNum + 1)) == null) {
                    rightMin = minPathSum(grid, rowNum, colNum + 1, cache);
                    cache.put(new Pair(rowNum, colNum + 1), rightMin);
                } else {
                    rightMin = cache.get(new Pair(rowNum, colNum + 1));
                }
            }
            if (rowNum != rows - 1) {
                if (cache.get(new Pair(rowNum + 1, colNum)) == null) {
                    bottomMin = minPathSum(grid, rowNum + 1, colNum, cache);
                    cache.put(new Pair(rowNum + 1, colNum), bottomMin);
                } else {
                    rightMin = cache.get(new Pair(rowNum + 1, colNum));
                }
            }
            int minValue = rightMin > bottomMin ? bottomMin : rightMin;
            cache.put(new Pair(rowNum, colNum), minValue + grid[rowNum][colNum]);
            return minValue + grid[rowNum][colNum];
        } else {
            return cache.get(new Pair(rowNum, colNum));
        }

    }
}