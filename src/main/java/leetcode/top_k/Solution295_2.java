package leetcode.top_k;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author enyi.lr  this solution is limt exceeded
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution295_2 {
    private class MedianFinder {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        int size = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            size++;
            if (size % 2 == 1) {   // 9   10    8   11
                if (maxHeap.isEmpty()) {
                    maxHeap.add(num);
                } else {
                    if (num < minHeap.peek()) {
                        int temp = minHeap.remove();
                        maxHeap.add(temp);  // 10,9
                        minHeap.add(num);  // 8
                    } else {
                        maxHeap.add(num);
                    }
                }
            } else {
                if (num > maxHeap.peek()) {
                    int temp = maxHeap.remove();
                    maxHeap.add(num);  //  11,9
                    minHeap.add(temp); //  8,10
                } else {
                    minHeap.add(num);
                }
            }

        }


    }

}