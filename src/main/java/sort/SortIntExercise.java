package sort;

/**
 * @author enyi.lr
 * @version $Id: SortIntExercise.java, v 0.1 2019‐11‐05 12:34 PM enyi.lr Exp $$
 */
public class SortIntExercise {

    public void mergeSort(int[] array) {
        __mergeSort(array, 0, array.length - 1);
    }

    public void __mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        __mergeSort(array, left, middle);
        __mergeSort(array, middle + 1, right);
        if (array[middle] > array[middle + 1]) {
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        // merge [left,middle] [middle+1,right]
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = middle + 1;
        int k = 0;
        while (l <= middle && r <= right) {
            if (array[l] < array[r]) {
                temp[k] = array[l];
                l++;
            } else {
                temp[k] = array[r];
                r++;
            }
            k++;
        }
        while (l <= middle) {
            temp[k] = array[l];
            k++;
            l++;
        }
        while (r <= right) {
            temp[k] = array[r];
            k++;
            r++;
        }

        // copy array
        int m = 0;
        for (int i = left; i <= right; i++) {
            array[i] = temp[m];
            m++;
        }
    }

    public void mergeSortBottomUp(int[] array) {

    }

}