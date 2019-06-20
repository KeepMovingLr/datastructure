package leetcode.array.sort;

/**
 * @author enyi.lr
 * @version $Id: Solution977.java, v 0.1 2019‐06‐21 12:43 AM enyi.lr Exp $$
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        // insertion sort
        for (int i = 1; i < A.length; i++) {
            int element = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if (element < A[j]) {
                    A[j + 1] = A[j];
                    if (j == 0) {
                        A[0] = element;
                    }
                } else {
                    A[j + 1] = element;
                    break;
                }
            }

        }
        return A;
    }

    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[] a = {-4, -1, 0, 3, 10};
        solution977.sortedSquares(a);

    }
}