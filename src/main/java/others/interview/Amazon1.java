package others.interview;

import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Amazon1.java, v 0.1 2019‐12‐13 7:13 PM enyi.lr Exp $$
 */
public class Amazon1 {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        // WRITE YOUR CODE HERE
        int count = 0;
        if (rows == 0 || column == 0) {
            return count;
        }
        for (int i = 0; i < rows; i++) {
            List<Integer> currentList = grid.get(i);
            for (int j = 0; j < column; j++) {
                if (currentList.get(j) == 1) {
                    markCluster(grid, i, j, rows, column);
                    count++;
                }
            }
        }
        return count;
    }
    // METHOD SIGNATURE ENDS

    private void markCluster(List<List<Integer>> grid, int currentRow, int currentColumn, int rows, int column) {
        if (currentRow < 0 || currentColumn < 0 || currentRow >= rows || currentColumn >= column || grid.get(currentRow).get(currentColumn)
                != 1) {
            return;
        }
        grid.get(currentRow).set(currentColumn, 0);
        markCluster(grid, currentRow + 1, currentColumn, rows, column);
        markCluster(grid, currentRow - 1, currentColumn, rows, column);
        markCluster(grid, currentRow, currentColumn + 1, rows, column);
        markCluster(grid, currentRow, currentColumn - 1, rows, column);
    }
}