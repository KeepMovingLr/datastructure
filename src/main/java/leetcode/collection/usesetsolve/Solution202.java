package leetcode.collection.usesetsolve;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution242.java, v 0.1 2019‐05‐29 7:42 PM enyi.lr Exp $$
 * time complexity
 * space complexity
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> results = new HashSet<>();
        while (!results.contains(1)) {
            int newResult = 0;
            while (n != 0) {
                int digit = n % 10;
                newResult = newResult + digit * digit;
                n = n / 10;
            }
            if (results.contains(newResult)) {
                break;
            } else {
                results.add(newResult);
            }
            n = newResult;
        }
        if (results.contains(1)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.isHappy(9));
    }

}