package leetcode.math;

/**
 * @author enyi.lr
 * @version $Id: S_204_CountPrimes.java, v 0.1 2019‐12‐12 7:41 PM enyi.lr Exp $$
 */
public class S_204_CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        if (n == 0 || n == 1) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param n an integer which is larger than 1
     * @return
     */
    public boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}