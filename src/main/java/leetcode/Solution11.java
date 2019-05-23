package leetcode;

/**
 * @author enyi.lr
 * @version $Id: Solution125.java, v 0.1 2019‐05‐22 12:12 AM enyi.lr Exp $$
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int currentMaxArea = 0;
        while (leftIndex < rightIndex) {
            int min = getMin(height[leftIndex], height[rightIndex]);
            int distence = rightIndex - leftIndex;
            int area = min * distence;
            currentMaxArea = getMax(area, currentMaxArea);
            if (height[leftIndex] < height[rightIndex]) {
                // As maxArea depends on the smaller height and the with, there is no need move the higher one
                leftIndex++;
            } else {
                rightIndex--;
            }

        }

        return currentMaxArea;
    }

    private int getMax(int x, int y) {
        if (x >= y) {
            return x;
        } else {
            return y;
        }
    }

    private int getMin(int x, int y) {
        if (x <= y) {
            return x;
        } else {
            return y;
        }
    }

    public static void main(String[] args) {
        // [2,3,10,5,7,8,9]   36
        Solution11 solution11 = new Solution11();
        int[] num = {2, 3, 10, 5, 7, 8, 9};
        int i = solution11.maxArea(num);
        System.out.println(i);
    }

}