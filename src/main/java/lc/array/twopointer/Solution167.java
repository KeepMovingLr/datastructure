package lc.array.twopointer;


/**
 * @author enyi.lr
 * @version $Id: Solution167.java, v 0.1 2019‐05‐21 11:55 PM enyi.lr Exp $$ v2 对撞指针法
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

    // time complexity O(n)
    public int[] twoSum2(int[] numbers, int target) {
        int frontPointer = 0;
        int endPointer = numbers.length - 1;
        int[] result = new int[2];
        while (frontPointer < endPointer) {
            int sum = numbers[frontPointer] + numbers[endPointer];
            if (sum == target) {
                result[0] = frontPointer + 1;
                result[1] = endPointer + 1;
                return result;
            }
            if (sum > target) {
                endPointer--;
            } else {
                frontPointer++;
            }
        }
        return result;
    }

    // time complexity O(n*n) not good
    public int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    if (numbers[i] + numbers[j] == target) {
                        result[0] = i + 1;
                        result[1] = j + 1;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    // time complexity O(n*log(n))
    public int[] twoSum4(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int result2 = binarySearch(numbers, target - numbers[i]);
            if (result2 != -1 && result2 != i) {
                if (i<result2){
                    result[0] = i + 1;
                    result[1] = result2 + 1;
                } else {
                    result[1] = i + 1;
                    result[0] = result2 + 1;
                }
                return result;
            }
        }
        return result;
    }

    private int binarySearch(int[] numbers, int target) {
        // search element in [begin,end]
        int begin = 0;
        int end = numbers.length - 1;
        int mid = begin + (end - begin) / 2;
        while (begin <= end) {
            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[mid] < target) {
                begin = mid + 1;
                mid = begin + (end - begin) / 2;
            } else {
                end = mid - 1;
                mid = begin + (end - begin) / 2;
            }
        }
        return -1;
    }

}