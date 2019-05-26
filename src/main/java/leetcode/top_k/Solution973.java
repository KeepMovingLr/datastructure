package leetcode.top_k;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {
                if (a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1]) {
                    return 1;
                } else if (a[0] * a[0] + a[1] * a[1] == b[0] * b[0] + b[1] * b[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int[] point : points) {
            Integer[] value = {point[0], point[1]};
            priorityQueue.add(value);
        }
        int i = 0;
        while (!priorityQueue.isEmpty() && i < K) {
            Integer[] remove = priorityQueue.remove();
            int[] resultV = {remove[0], remove[1]};
            result[i] = resultV;
            i++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new int[2][];
        System.out.println(result.length);
    }

}