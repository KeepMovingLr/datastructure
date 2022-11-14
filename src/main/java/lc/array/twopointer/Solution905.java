package lc.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution905.java, v 0.1 2019‐06‐21 1:03 AM enyi.lr Exp $$
 */
public class Solution905 {

    public int[] sortArrayByParity(int[] A) {
        // use [0,k) contains the satisfied element
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (isEven(A[i])) {
                swap(A, i, k);
                k++;
            }
        }

        return A;
    }

    public boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int[] array, int i, int j) {
        int arr = array[i];
        array[i] = array[j];
        array[j] = arr;
    }

}