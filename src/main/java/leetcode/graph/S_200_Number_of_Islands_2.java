package leetcode.graph;

/**
 * @author enyi.lr
 * @version $Id: Solution200_3.java, v 0.1 2019‐06‐27 12:21 AM enyi.lr Exp $$
 */
public class S_200_Number_of_Islands_2 {

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null) {
            return count;
        }
        if (grid.length == 0){
            return 0;
        }
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        // boolean[][] visited = new boolean[rowNum][columnNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // make all adjacent become '0'
                    dfs(grid, i, j, rowNum, columnNum);
                }
            }
        }
        return count;
    }

    /**
     * use the dfs thinking to solve the problem
     *
     * @param grid
     * @param row
     * @param colomn
     * @param rowNum
     * @param columnNum
     */
    public void dfs(char[][] grid, int row, int colomn, int rowNum, int columnNum) {
        if (grid[row][colomn] == '1') {
            grid[row][colomn] = '0';
            // right
            if (colomn + 1 < columnNum) {
                dfs(grid, row, colomn + 1, rowNum, columnNum);
            }
            // left
            if (colomn - 1 >= 0) {
                dfs(grid, row, colomn - 1, rowNum, columnNum);
            }
            // up
            if (row - 1 >= 0) {
                dfs(grid, row - 1, colomn, rowNum, columnNum);
            }
            // down
            if (row + 1 < rowNum) {
                dfs(grid, row + 1, colomn, rowNum, columnNum);
            }
        }

    }

}