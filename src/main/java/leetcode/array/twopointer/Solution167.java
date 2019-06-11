package leetcode.array.twopointer;

/**
 * @author enyi.lr
 * @version $Id: Solution167.java, v 0.1 2019‐05‐21 11:55 PM enyi.lr Exp $$
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int front = 0;
        int end = numbers.length - 1;
        while (front < end) {
            int total = numbers[front] + numbers[end];
            if (total == target) {
                result[0] = front + 1;
                result[1] = end + 1;
                return result;
            }
            if (total > target) {
                end--;
            } else {
                front++;
            }
        }
        return result;
    }

}