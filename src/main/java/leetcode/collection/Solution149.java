package leetcode.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr  how to deal with problem using set and map
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$ v2
 * todo 还没有得到正确的解
 */
public class Solution149 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {1, 1}, {1, 1},{1, 2}};
        int[][] arr2 = {{84, 250}, {0, 0}, {1, 0}, {0, -70}, {0, -70}, {1, -1}, {21, 10}, {42, 90}, {-42, -230}};
        Solution149 solution149 = new Solution149();
        int i = solution149.maxPoints(arr);
        System.out.println(i);

    }

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        // 去重 key:point use list to present ，value：count
        Map<List<Integer>, Integer> indexCount = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            List<Integer> pointList = new ArrayList<>();
            pointList.add(point[0]);
            pointList.add(point[1]);
            Integer count = indexCount.getOrDefault(pointList, 0);
            count++;
            indexCount.put(pointList, count);
        }
        int[][] newPoints = new int[indexCount.size()][2];
        int k = 0;
        for (List<Integer> key : indexCount.keySet()) {
            newPoints[k] = new int[] {key.get(0), key.get(1)};
            k++;
        }
        if (indexCount.size() == 1){
            for (List<Integer> list : indexCount.keySet()) {
                return indexCount.get(list);
            }
        }
        //
        int max = 0;
        Set<List<Integer>> currentMaxPointSet = new HashSet<>();
        for (int i = 0; i < newPoints.length; i++) {
            Set<List<Integer>> maxPointSet = new HashSet<>();
            int[] point1 = newPoints[i];
            List<Integer> pointList = new ArrayList<>();
            pointList.add(point1[0]);
            pointList.add(point1[1]);
            maxPointSet.add(pointList);
            for (int i1 = i + 1; i1 < newPoints.length; i1++) {
                int[] point2 = newPoints[i1];
                List<Integer> pointList2 = new ArrayList<>();
                pointList2.add(point2[0]);
                pointList2.add(point2[1]);
                maxPointSet.add(pointList2);
                int count = 2;
                for (int j = i1 + 1; j < newPoints.length; j++) {
                    int[] point3 = newPoints[j];
                    if (inOneLine(point1, point2, point3)) {
                        List<Integer> pointList3 = new ArrayList<>();
                        pointList3.add(point3[0]);
                        pointList3.add(point3[1]);
                        maxPointSet.add(pointList3);
                        count++;
                    }
                }
                max = getMax(max, count);
                currentMaxPointSet = getMaxSet(maxPointSet, currentMaxPointSet);
            }
        }
        // deplicate
        for (List<Integer> key : indexCount.keySet()) {
            int count = indexCount.get(key);
            if (count > 1) {
                if (currentMaxPointSet.contains(key)) {
                    max = max + count - 1;
                }
            }
        }
        return max;
    }

    private Set<List<Integer>> getMaxSet(Set<List<Integer>> maxPointSet, Set<List<Integer>> currentMaxPointSet) {
        if (maxPointSet.size() > currentMaxPointSet.size()) {
            currentMaxPointSet = maxPointSet;
        }
        return currentMaxPointSet;
    }

    private boolean inOneLine(int[] point1, int[] point2, int[] point3) {
        // y = kx + b (k!=0)
        if ((point1[0] == point2[0] && point1[1] != point2[1]) || (point1[0] == point3[0] && point1[1] != point3[1])
                || (point2[0] == point3[0] && point2[1] != point3[1])) {
            if (point1[0] == point2[0] && point2[0] == point3[0]) {
                return true;
            } else {
                return false;
            }
        }
        double k = getK(point1, point2);
        double b = getb(point1, point3);
        return point3[1] == k * point3[0] + b;
    }

    private int getMax(int max, int count) {
        if (max > count) {
            return max;
        } else {
            return count;
        }
    }

    private double getK(int[] point1, int[] point2) {
        if ((point1[0] - point2[0]) != 0) {
            return (point1[1] - point2[1]) / (point1[0] - point2[0]);
        } else {
            return 0;
        }
    }

    private double getb(int[] point1, int[] point2) {
        double k = (point1[1] - point2[1]) / (point1[0] - point2[0]);
        return point2[1] - k * point2[0];
    }

    private double getC(int[] point1, int[] point2) {
        return 0;
    }

    private double getB(int[] point1, int[] point2) {
        return 0;
    }

    private double getA(int[] point1, int[] point2) {
        return 0;
    }

}