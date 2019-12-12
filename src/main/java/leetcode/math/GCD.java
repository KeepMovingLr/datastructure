package leetcode.math;

/**
 * @author enyi.lr
 * @version $Id: GCD.java, v 0.1 2019‐12‐12 5:19 PM enyi.lr Exp $$
 */
public class GCD {

    /**
     * get the greatest common divisor of n numbers
     * @param num the length of array
     * @param arr positive integer
     * @return
     */
    public int generalizedGCD(int num, int[] arr) {
        int result = arr[0];
        for (int i = 1; i < num; i++) {
            result = GCDOfTwo(result, arr[i]);
        }
        return result;
    }

    /**
     * when a and b is larger than 0
     *
     * @param a
     * @param b
     * @return
     */
    public int GCDOfTwo(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return GCDOfTwo(a - b, b);
        } else {
            return GCDOfTwo(a, b - a);
        }
    }

    public int GCDOfTwo2(int a, int b) {
        if (a < b) {
            int c = b;
            b = a;
            a = c;
        }
        return b == 0 ? a : GCDOfTwo2(b, a % b);
    }



    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.GCDOfTwo2(12, 8));
        int[] arr = {2, 13, 6, 8, 10};
        System.out.println(gcd.generalizedGCD(5, arr));
    }

}