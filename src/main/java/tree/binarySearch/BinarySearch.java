package tree.binarySearch;

/**
 * @author enyi.lr
 * @version $Id: BinarySearch.java, v 0.1 2019‐06‐24 10:06 PM enyi.lr Exp $$
 */
public class BinarySearch {

    /**
     * binary search in Array arr
     * @param arr
     * @param target
     * @return
     * note: it is important to know the definition of each variable. and keep the variable the same with the previous defination.
     */
    public int binaryS(int[] arr, int target) {
        int l = 0, r = arr.length - 1; // search in [l , r]
        while (l <= r) { // when l == r, the range is still valid, so we need to use l<= r rather than l < r
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Returns index of x if it is present in array, else return -1
     */
    public int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                l = mid + 1;
                mid = l + (r - l) / 2;
            } else {
                r = mid - 1;
                mid = l + (r - l) / 2;
            }
        }
        return -1;
    }

    /**
     * Returns index of target if it is present in arr[l,r], else return -1
     *
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int binarySearch(int[] arr, int l, int r, int target) {
        int mid = l + (r - l) / 2;
        if (l <= r) {
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                return binarySearch(arr, mid + 1, r, target);
            } else {
                return binarySearch(arr, l, mid - 1, target);
            }
        } else {
            return -1;
        }

    }

    /**
     * get the index with the largest data smaller or equal to target
     * there are two ways to solve the problem. one is for loop the whole array.
     *
     * @param arr    a sorted array
     * @param target
     * @return referer https://www.geeksforgeeks.org/floor-in-a-sorted-array/
     */
    public int floor(int[] arr, int target) {

        return -1;

    }

    /**
     * get the index with the smallest data larger than or equal to target
     *
     * @param arr
     * @param target
     * @return
     */
    public int ceil(int[] arr, int target) {
        return -1;
    }
}