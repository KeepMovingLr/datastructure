package sort;

/**
 * @author enyi.lr
 * @version $Id: Sort.java, v 0.1 2019‐06‐19 12:36 PM enyi.lr Exp $$
 */
public class SortWithTemplate<T extends Comparable> {

    public void selectionSort(T[] array) {
        // use [0,i] contains the satisfied value
        for (int i = 0; i < array.length; i++) {
            // select the smallest one in [j, array.length]
            int min_idx = i;
            // find the minimum one from [i+1,array.length)
            for (int k = i + 1; k < array.length; k++) {
                if (array[k].compareTo(array[min_idx]) < 0) {
                    min_idx = k;
                }
            }
            // swap array[i] and array[j]
            swap(array, i, min_idx);
        }
    }

    private void swap(T[] array, int i, int min_idx) {
        T arr = array[i];
        array[i] = array[min_idx];
        array[min_idx] = arr;
    }

    public static void main(String[] args) {
        Integer[] ints = SortTestUtils.generateArray(10, 10, 20);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("--------");
        SortWithTemplate sort = new SortWithTemplate();
        sort.selectionSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}