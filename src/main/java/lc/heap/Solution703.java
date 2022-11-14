package lc.heap;

import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solution703.java, v 0.1 2019‐06‐18 11:39 PM enyi.lr Exp $$
 */
public class Solution703 {
    static class KthLargest {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int                    length        = 0;
        int                    k             = 0;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.length = nums.length;
            for (int i = 0; i < nums.length; i++) {
                priorityQueue.add(nums[i]);
            }
            if (k <= length) {
                while (priorityQueue.size() != k) {
                    priorityQueue.remove();
                }
            }

        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size() != k) {
                priorityQueue.remove();
            }
            return priorityQueue.peek();
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int a = kthLargest.add(3);
        int b = kthLargest.add(5);

    }

}