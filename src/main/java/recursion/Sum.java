package recursion;

/**
 * @author enyi.lr
 * @version $Id: Sum.java, v 0.1 2019‐10‐17 1:02 PM enyi.lr Exp $$ v2
 */
public class Sum {
    public static int sum(int[] array) {
        return sum(array, 0);
    }

    // calculate [l,n) 这个区间内所有数字的和
    private static int sum(int[] array, int l) {
        if (l == array.length) {
            return 0;
        } else {
            return array[l] + sum(array, l + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Sum.sum(nums));
    }
}