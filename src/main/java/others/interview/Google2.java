package others.interview;

import java.util.*;

/**
 * 有几个学生被淘汰了？
 * 给你一个二维数组，a[i][0]代表第i个学生的math成绩，a[i][1]代表第i个学生的English成绩。 如果存在学生b的两门成绩都比学生a高，a就被淘汰了。问一共有几个学生被淘汰了？
 * (1, 2)
 * (3, 4)
 * (5, 6)
 * (7, 8)
 * <p>
 * https://leetcode.cn/circle/discuss/YqC4Gz/
 */
public class Google2 {

    // time complexity O(n^2) space O(n)
    public int countDiscardedStudent(int[][] result) {
        if (result.length == 0)
            return 0;
        // 按数学排序，数学相等的时候按照英语排序
        Arrays.sort(result, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        Set<Integer> removedSet = new HashSet<>(); // store removed index

        for (int i = result.length - 1; i >= 0; i--) {
            int[] mathHighest = result[i];
            for (int j = i - 1; j >= 0; j--) {
                int[] mathSecondHighest = result[j];
                if (mathSecondHighest[0] == mathHighest[0])
                    continue;
                if (mathHighest[1] > mathSecondHighest[1]) // English is higher than j
                    removedSet.add(j);
            }
        }

        return removedSet.size();
    }


    public static void main(String[] args) {
        Google2 google2 = new Google2();
//        int[][] grade = {{1, 2}, {3, 4}, {5, 6}, {2, 1}};
        int[][] grade = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 2}, {3, 3}};
        int count = google2.countDiscardedStudent(grade);
        System.out.println(count);
    }
}
