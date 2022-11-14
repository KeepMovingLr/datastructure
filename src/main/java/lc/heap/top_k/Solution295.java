package lc.heap.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr  this solution is limt exceeded
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution295 {
    private class MedianFinder {

        private List<Integer> list = new ArrayList<>();
        int size = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            list.add(num);
            size++;
        }

        public double findMedian() {
            Collections.sort(list);
            if (size % 2 == 1) {
                return list.get((size - 1) / 2);
            } else {
                if (size == 0) {
                    return 0.0;
                }
                int a = list.get((size - 1) / 2);
                int b = list.get((size - 1) / 2 + 1);
                return (a + b + 0.0) / 2;
            }

        }
    }

}