package lc.segmenttree;

import segmenttree.SegmentTree;

/**
 * @author enyi.lr
 * @version $Id: Solution303.java, v 0.1 2019‐06‐01 4:13 PM enyi.lr Exp $$
 */
public class Solution303 {
    class NumArray {
        Integer[]            data;
        SegmentTree<Integer> segmentTree;

        public NumArray(int[] nums) {
            data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum = sum + data[k];
            }
            return sum;
        }

    }
}