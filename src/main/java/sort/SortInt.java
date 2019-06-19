package sort;

/**
 * @author enyi.lr
 * @version $Id: SortInt.java, v 0.1 2019‐06‐19 1:17 PM enyi.lr Exp $$
 */
public class SortInt {
    public void selectionSort(int[] array) {
        // use [0,i] contains the satisfied value
        for (int i = 0; i < array.length; i++) {
            // select the smallest one in [j, array.length]
            int min_idx = i;
            // find the minimum one from [i+1,array.length)
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[min_idx]) {
                    min_idx = k;
                }
            }
            // swap array[i] and array[j]
            swap(array, i, min_idx);
        }
    }

    public void insertionSort(int[] array) {

    }

    private void swap(int[] array, int i, int min_idx) {
        int arr = array[i];
        array[i] = array[min_idx];
        array[min_idx] = arr;
    }

    public static void main(String[] args) {

    }
}