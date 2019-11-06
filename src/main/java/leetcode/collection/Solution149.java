package leetcode.collection;

/**
 * @author enyi.lr  how to deal with problem using set and map
 * @version $Id: Solution15.java, v 0.1 2019‐05‐28 7:33 PM enyi.lr Exp $$ v2
 */
public class Solution149 {
    public static void main(String[] args) {
        int[][] arr = {{4, 0}, {4, -1}, {4, 5}};
        Solution149 solution149 = new Solution149();
        int i = solution149.maxPoints(arr);
        System.out.println(i);

    }

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int i1 = i + 1; i1 < points.length; i1++) {
                int[] point2 = points[i1];
                if (point1 == point2) {
                    // todo
                }
                int count = 2;
                for (int j = i1 + 1; j < points.length; j++) {
                    int[] point3 = points[j];
                    if (point1 == point2 || point2 == point3) {

                    }
                    if (inOneLine(point1, point2, point3)) {
                        count++;
                    }
                }
                max = getMax(max, count);
            }
        }
        return max;
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
        // 点重合的情况
        if ((point1[0] == point2[0] && point1[1] == point2[1]) || (point1[0] == point3[0] && point1[1] == point3[1])
                || (point2[0] == point3[0] && point2[1] == point3[1])) {
            return true;
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