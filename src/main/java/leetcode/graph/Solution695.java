package leetcode.graph;

/**
 * @author enyi.lr
 * @version $Id: Solution695.java, v 0.1 2019‐06‐29 12:55 AM enyi.lr Exp $$
 */
public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j]) {
                    int count = dfs(grid, i, j, rows, columns, visited);
                    max = getMax(max, count);
                }
            }
        }
        return max;
    }

    public int getMax(int i, int j) {
        if (i > j) {
            return i;
        }
        return j;
    }

    public int dfs(int[][] grid, int row, int col, int rowNum, int colNum, boolean[][] visited) {
        int count = 0;
        if (!visited[row][col]) {
            visited[row][col] = true;
            if (grid[row][col] == 1) {
                count++;
                // right
                if (col + 1 < colNum) {
                    count = count + dfs(grid, row, col + 1, rowNum, colNum, visited);
                }
                // left
                if (col - 1 >= 0) {
                    count = count + dfs(grid, row, col - 1, rowNum, colNum, visited);
                }
                // up
                if (row + 1 < rowNum) {
                    count = count + dfs(grid, row + 1, col, rowNum, colNum, visited);
                }
                // down
                if (row - 1 >= 0) {
                    count = count + dfs(grid, row - 1, col, rowNum, colNum, visited);
                }
            }
        }
        return count;
    }
}