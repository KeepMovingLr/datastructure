package leetcode.graph;

/**
 * @author enyi.lr
 * @version $Id: Solution200_3.java, v 0.1 2019‐06‐27 12:21 AM enyi.lr Exp $$
 */
public class S_200_Number_of_Islands {

    public static void main(String[] args) {
        // [["1","1","1"],["0","1","0"],["1","1","1"]]
        S_200_Number_of_Islands solution200_3 = new S_200_Number_of_Islands();
        char[][] grid = new char[3][3];
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = '1';
            }
        }
        grid[1][0] = '0';
        grid[1][2] = '0';
        int i = solution200_3.numIslands(grid);
        System.out.println(i);
    }



    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == '1') {
                        count++;
                        // dfs
                        dfs(grid, i, j, visited, rowCount, columnCount);
                    }
                }
            }
        }
        return count;
    }

    /**
     * use the dfs thinking to solve the problem
     * @param grid
     * @param row
     * @param colomn
     * @param visited
     * @param rowNum
     * @param columnNum
     */
    public void dfs(char[][] grid, int row, int colomn, boolean[][] visited, int rowNum, int columnNum) {
        if (!visited[row][colomn]) {
            visited[row][colomn] = true;
            if (grid[row][colomn] == '1') {
                // right
                if (colomn + 1 < columnNum) {
                    dfs(grid, row, colomn + 1, visited, rowNum, columnNum);
                }
                // left
                if (colomn - 1 >= 0) {
                    dfs(grid, row, colomn - 1, visited, rowNum, columnNum);
                }
                // up
                if (row - 1 >= 0) {
                    dfs(grid, row - 1, colomn, visited, rowNum, columnNum);
                }
                // down
                if (row + 1 < rowNum) {
                    dfs(grid, row + 1, colomn, visited, rowNum, columnNum);
                }
            }
        }

    }

}