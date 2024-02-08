package segmenttree.dynamic;

/**
 * dynamic segment Tree with lazy propagation
 * 1e9 stands for 1 × 10^9
 */
public class DynamicLazySegmentTree {
    static class SegmentNode {
        int rangeL, rangeR, rangeM;
        int lazyLeft, lazyRight;
        int val;
        int lazyVal;
        DynamicSegmentTree.SegmentNode leftChild;
        DynamicSegmentTree.SegmentNode rightChild;

        public SegmentNode() {
        }

        public SegmentNode(int rangeL, int rangeR, int val) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
            this.val = val;
        }

        public SegmentNode(int rangeL, int rangeR) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
        }

        static SegmentNode root = new SegmentNode(0, (int) 1e9);

        public static void update(int l, int r, int value) {
            update(root, l, r, value);
        }

        static void update(SegmentNode cur, int l, int r, int value) {
            int lazyValue = cur.lazyVal;
            if (lazyValue != 0) {
                cur.val += (cur.rangeR - cur.rangeL + 1) * lazyValue;
                cur.lazyVal = 0;
            }
        }

    }

}
