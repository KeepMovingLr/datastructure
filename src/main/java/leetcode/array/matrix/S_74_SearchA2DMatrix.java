package leetcode.array.matrix;

/**
 * @author enyi.lr
 * @version $Id: S_74_SearchA2DMatrix.java, v 0.1 2019‐12‐13 9:30 PM enyi.lr Exp $$
 */
public class S_74_SearchA2DMatrix {
    /**
     *
     * @param matrix matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int totalNum = rows * columns;
        // use binary search to solve the problem
        int begin = 0;
        int end = totalNum - 1;
        int middle = begin + (end - begin) / 2;
        int rowNum = middle / columns;
        int colNum = middle % columns;
        while (begin <= end) {
            if (matrix[rowNum][colNum] == target) {
                return true;
            } else if (matrix[rowNum][colNum] < target) {
                begin = middle + 1;
                middle = begin + (end - begin) / 2;
                rowNum = middle / columns;
                colNum = middle % columns;
            } else {
                end = middle - 1;
                middle = begin + (end - begin) / 2;
                rowNum = middle / columns;
                colNum = middle % columns;
            }
        }
        return false;

    }

}