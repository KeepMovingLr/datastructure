package others.interview;

import maxheap.MaxHeap;

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
        if (result.length == 0) return 0;
        // 按数学排序，数学相等的时候按照英语排序
        Arrays.sort(result, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        Set<Integer> removedSet = new HashSet<>(); // store removed index

        for (int i = result.length - 1; i >= 0; i--) {
            int[] mathHighest = result[i];
            for (int j = i - 1; j >= 0; j--) {
                int[] mathSecondHighest = result[j];
                if (mathSecondHighest[0] == mathHighest[0]) continue;
                if (mathHighest[1] > mathSecondHighest[1]) // English is higher than j
                    removedSet.add(j);
            }
        }

        return removedSet.size();
    }

    public int countDiscardedStudent2(int[][] result) {
        if (result.length == 0) return 0;
        // 按数学排序，数学相等的时候按照英语排序
        Arrays.sort(result, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int ans = 0;
        int pre = -1;
        int cur = result[result.length - 1][1];
        for (int i = result.length - 2; i >= 0; i--) {
            if (result[i][0] == result[i + 1][0]) {
                cur = Math.max(cur, result[i][1]);
            } else {
                pre = Math.max(pre, cur);
                cur = result[i][1];
            }
            if (result[i][1] < pre) {
                ans++;
            }
        }
        return ans;
    }

    public int countDiscardedStudent3(int[][] result) {
        if (result.length == 0) return 0;
        // 按数学排序，数学相等的时候按照英语排序
        Arrays.sort(result, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minimum heap
        Map<Integer, List<Integer>> map = new HashMap<>();
        // group according to the math result
        for (int i = 0; i < result.length; i++) {
            if (map.get(result[i][0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(result[i][0], list);
            } else {
                List<Integer> list = map.get(result[i][0]);
                list.add(i);
            }
        }
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (pq.isEmpty()) {
                for (Integer idx : list) {
                    pq.add(result[idx][1]);
                }
            } else {
                int idx = list.get(list.size() - 1);
                if (result[idx][1] > pq.poll()) {
                    ans++;
                    pq.poll();
                }
                for (Integer index : list) {
                    pq.add(result[index][1]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Google2 google2 = new Google2();
//        int[][] grade = {{1, 2}, {3, 4}, {5, 6}, {2, 1}};
        int[][] grade = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 2}, {3, 3}, {3, 4}};
        int count = google2.countDiscardedStudent(grade);
        int count2 = google2.countDiscardedStudent2(grade);
        int count3 = google2.countDiscardedStudent3(grade);
        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);
    }
}
