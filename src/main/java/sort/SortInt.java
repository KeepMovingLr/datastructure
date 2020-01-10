package sort;

import java.util.Random;

/**
 * @author enyi.lr
 * @version $Id: SortInt.java, v 0.1 2019‐06‐19 1:17 PM enyi.lr Exp $$
 */
public class SortInt {


    /***************************************************************/
    // time complexity O(n^2)
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

    // 插入排序的优化写法。 如果数组本身近乎有序，那么将会是O(n)的，效率非常高
    public void insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (element < array[j]) {
                    array[j + 1] = array[j];
                    if (j == 0) {
                        array[0] = element;
                    }
                } else {
                    array[j + 1] = element;
                    break;
                }
            }
        }
    }

    /***************************************************************/
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    /***************************************************************/
    public void bubbleSort(int[] array) {
        // array.length -1 is the times that need to be bubbled
        for (int j = 0; j < array.length - 1; j++) {
            // bubble
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }

    }



    /***************************************************************/
    // it is a Divide and Conquer algorithm
    public void mergeSort(int[] array) {
        __mergeSort(array, 0, array.length - 1);
    }

    // use recursive method to merge sort array[i,j]
    private void __mergeSort(int[] array, int i, int j) {
        // recursive terminal condition
        if (i >= j) {
            return;
        }
        int middle = i + (j - i) / 2;
        __mergeSort(array, i, middle);
        __mergeSort(array, middle + 1, j);

        // optimize
        if (array[middle] > array[middle + 1]) {
            __merge(array, i, middle, j);
        }
    }

    // important
    public void mergeSortBottomUp(int[] array) {
        int length = array.length;
        for (int size = 1; size <= length; size = size * 2) {
            for (int i = 0; i < length; i = i + size * 2) {
                __merge(array, i, getMin(i + size - 1, length - 1), getMin(i + size * 2 - 1, length - 1));
            }

        }
    }

    // merge array[left,middle] and array[middle+1,right]
    private void __merge(int[] array, int left, int middle, int right) {
        if (left == right) {
            return;
        }
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for (int l = j; l <= right; l++) {
                temp[k] = array[l];
                j++;
                k++;
            }
        } else {
            for (int l = i; l <= middle; l++) {
                temp[k] = array[l];
                i++;
                k++;
            }
        }

        int m = 0;
        for (int l = left; l <= right; l++) {
            array[l] = temp[m];
            m++;
        }
    }

    /***************************************************************/

    // 3-way quick sort
    public void quickSort3Ways(int[] array) {
        __quickSort3Ways(array, 0, array.length - 1);
    }

    // quick sort array[left,right]
    private void __quickSort3Ways(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] ints = __partition3ways(array, left, right);
        int leftPar = ints[0];
        int rightPar = ints[1];
        __quickSort3Ways(array, left, leftPar - 1);
        __quickSort3Ways(array, rightPar + 1, right);
    }

    /**
     * get random range in [rangeL,rangeR]
     *
     * @param rangeL
     * @param rangeR
     * @return
     */
    public int getRandomWithRange(int rangeL, int rangeR) {
        Random random = new Random();
        return random.nextInt(rangeR - rangeL + 1) + rangeL;
    }

    private int[] __partition3ways(int[] array, int left, int right) {
        int[] result = new int[2];
        // optimize method, random
        int random = getRandomWithRange(left, right);
        swap(array, left, random);

        int value = array[left];

        int l = left;
        int r = right;
        int k = left;
        // use [left,l) save smaller than value, use (r,right] save larger than value, use [l,k] save equal to value
        while (k + 1 <= r) {
            if (array[k + 1] == value) {
                k++;
            } else if (array[k + 1] < value) {
                swap(array, l, k + 1);
                l++;
                k++;
            } else if (array[k + 1] > value) {
                swap(array, r, k + 1);
                r--;
                // note that need not k++, because we need to check the swapped value
            }
        }
        // todo bug fix
        swap(array, left, l - 1);
        l--;
        result[0] = l;
        result[1] = k;
        return result;
    }

    // quickSort
    public void quickSort(int[] array) {
        __quickSort(array, 0, array.length - 1);
    }

    // quick sort from array[left, right]
    private void __quickSort(int[] array, int left, int right) {
        // recursive terminal condition
        if (left >= right) {
            return;
        }
        int partition = __partition(array, left, right);
        __quickSort(array, left, partition - 1);
        __quickSort(array, partition + 1, right);

    }

    /**
     * partition array[left,right]
     *
     * @param array
     * @param left
     * @param right
     * @return an index j which array[left,j-1] < array[j] and array[j+1,right] > array[j]
     */
    private int __partition(int[] array, int left, int right) {
        if (left == right) {
            return left;
        }
        int v = array[left];
        int j = left;
        // array[left+1,j] < v  array[j+1,i) > v
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= v) {
                j++;
                swap(array, j, i);
            }
        }
        swap(array, j, left);
        return j;
    }





    private void swap(int[] array, int indexI, int indexJ) {
        int arr = array[indexI];
        array[indexI] = array[indexJ];
        array[indexJ] = arr;
    }

    private int getMin(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) throws Exception {
        SortInt sortInt = new SortInt();
        System.out.println(sortInt.getRandomWithRange(0, 2));
        int[] int1 = SortTestUtils.generateIntArray(10000000, 0, 10000000);
        int[] int2 = SortTestUtils.copy(int1);
        int[] int3 = SortTestUtils.copy(int1);
        SortTestUtils.testSort("quickSort", int1);
        SortTestUtils.testSort("quickSort3Ways", int2);
        //SortTestUtils.testSort("mergeSortBottomUp", int2);
        for (int i = 0; i < int1.length; i++) {
            if (int1[i] != int2[i]) {
                System.out.println("wrong---");
            }
        }

    }
}