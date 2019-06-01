package leetcode.segmenttree;

import segmenttree.SegmentTree;

/**
 * @author enyi.lr
 * @version $Id: Solution307.java, v 0.1 2019‐06‐01 4:46 PM enyi.lr Exp $$
 */
public class Solution307 {
    class NumArray {
        SegmentTree<Integer> segmentTree;
        Integer[]            data;

        public NumArray(int[] nums) {
            if (nums.length != 0) {
                data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<Integer>(data, ((a, b) -> a + b));
            }
        }

        public void update(int i, int val) {
            segmentTree.set(i, val);
        }

        public int sumRange(int i, int j) {
            return segmentTree.query(i, j);
        }
    }
}