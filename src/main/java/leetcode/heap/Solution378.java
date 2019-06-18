package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solution378.java, v 0.1 2019‐06‐19 12:09 AM enyi.lr Exp $$
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(matrix[i][i1]);
                } else {
                    priorityQueue.add(matrix[i][i1]);
                    priorityQueue.remove();
                }
            }

        }
        return priorityQueue.peek();
    }

}