package leetcode.top_k;

import java.util.PriorityQueue;

/**
 * @author enyi.lr  this solution is limt exceeded
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution295 {
    private class MedianFinder {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int                    size          = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            priorityQueue.add(num);
            size++;
        }

        public double findMedian() {
            double result = 0.0;
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            if (size % 2 == 1) {
                int midIndex = size / 2;
                int i = 0;
                while (!priorityQueue.isEmpty()) {
                    if (i == midIndex) {
                        result = priorityQueue.peek();
                    }
                    temp.add(priorityQueue.remove());
                    i++;

                }
                priorityQueue = temp;
            } else {
                int midIndex1 = (size - 1) / 2;
                int midIndex2 = size / 2;
                Integer result1 = 0;
                Integer result2 = 0;
                int i = 0;
                while (!priorityQueue.isEmpty()) {
                    if (i == midIndex1) {
                        result1 = priorityQueue.peek();
                    }
                    if (i == midIndex2) {
                        result2 = priorityQueue.peek();
                    }
                    i++;
                    temp.add(priorityQueue.remove());
                }
                result = (result1 + result2 + 0.0) / 2;
                priorityQueue = temp;
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }

}