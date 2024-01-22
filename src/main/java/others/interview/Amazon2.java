package others.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author enyi.lr
 * @version $Id: Amazon2.java, v 0.1 2019‐12‐13 7:18 PM enyi.lr Exp $$
 */
public class Amazon2 {

    public static void main(String[] args) {
        Amazon2 amazon2 = new Amazon2();
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(1);
        row1.add(1);
        row1.add(0);
        row1.add(1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(1);
        row2.add(0);
        row2.add(1);
        row2.add(0);
        List<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);
        row3.add(0);
        row3.add(1);
        List<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(1);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);
        System.out.println(amazon2.minimumDays(4, 5, grid));

    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        if (rows == 0 && columns == 0 || grid == null) {
            return 0;
        }
        Queue<Point> queue = new ArrayDeque<>();
        int outOfDateCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 0) {
                    outOfDateCount++;
                } else {
                    queue.add(new Point(i, j));
                }
            }
        }
        int minimumDays = 0;
        while (!queue.isEmpty()) {
            minimumDays++;
            for (int i = 0; i < queue.size(); i++) {
                Point point = queue.poll();
                // set its neighbors to 1 if its neighbor is 0
                if (point.x - 1 >= 0) {
                    if (grid.get(point.x - 1).get(point.y) == 0) {
                        grid.get(point.x - 1).set(point.y, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x - 1, point.y));
                    }
                }
                if (point.x + 1 < rows) {
                    if (grid.get(point.x + 1).get(point.y) == 0) {
                        grid.get(point.x + 1).set(point.y, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x + 1, point.y));
                    }
                }
                if (point.y - 1 >= 0) {
                    if (grid.get(point.x).get(point.y - 1) == 0) {
                        grid.get(point.x).set(point.y - 1, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x, point.y - 1));
                    }
                }
                if (point.y + 1 < columns) {
                    if (grid.get(point.x).get(point.y + 1) == 0) {
                        grid.get(point.x).set(point.y + 1, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x, point.y + 1));
                    }
                }
            }
            if (outOfDateCount == 0) {
                return minimumDays;
            }
        }
        return -1;

    }

}