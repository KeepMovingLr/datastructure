package leetcode.collection.usemapsolve;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution447.java, v 0.1 2019‐05‐30 11:56 PM enyi.lr Exp $$
 */
public class Solution447 {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = distance(point, points[j]);
                    if (map.containsKey(distance)) {
                        int count = map.get(distance);
                        count++;
                        map.put(distance, count);
                    } else {
                        map.put(distance, 1);
                    }
                }

            }
            // for i  distance
            result = result + getCount(map);
        }
        return result;
    }

    private int getCount(Map<Integer, Integer> map) {
        int result = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) >= 2) {
                int sum = 0;
                int count = map.get(key);
                for (int i = 0; i < count; i++) {
                    sum = sum + i;
                }
                result = result + sum * 2;
            }
        }
        return result;
    }

    private int distance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }

    public static void main(String[] args) {
        Solution447 solution447 = new Solution447();
        int[][] a = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int re = solution447.numberOfBoomerangs(a);
        System.out.println(re);
    }
}