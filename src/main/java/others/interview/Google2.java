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
    // todo is this correct solution?
    public int countDiscardedStudent(int[][] result) {
        if (result.length == 0)
            return 0;
        Arrays.sort(result, (a, b) -> a[0] - b[0]);
        Map<int[], Integer> map = new HashMap<>();
        Map<Integer, int[]> map2 = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            map.put(result[i], i);
            map2.put(i, result[i]);
        }
        Arrays.sort(result, (a, b) -> a[1] - b[1]);
        int max = -1;
        Set<Integer> removeSet = new HashSet<>();
        for (int j = result.length - 1; j >= 0; j--) {
            int[] highest = result[j];
            int idx = map.get(highest);
            max = Math.max(max, idx - 1);
        }
        return max + 1;
    }

    // time complexity O(nlogn) space O(1)
    public int countDiscardedStudent2(int[][] result) {
        if (result.length == 0)
            return 0;
        Arrays.sort(result, (a, b) -> a[0] - b[0]);
        int res = 0;
        int cur = result[result.length - 1][1];
        for (int i = result.length - 2; i >= 0; i--) {
            if (cur > result[i][1])
                res++;
            else
                cur = result[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Google2 google2 = new Google2();
//        int[][] grade = {{1, 2}, {3, 4}, {5, 6}, {2, 1}};
        int[][] grade = {{2, 1}, {1, 2}, {3, 4}};
        int count = google2.countDiscardedStudent(grade);
        int count2 = google2.countDiscardedStudent2(grade);
        System.out.println(count == count2);
    }
}
