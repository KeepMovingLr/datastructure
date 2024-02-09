package segmenttree.dynamic;

/**
 * dynamic segment Tree with lazy propagation <br>
 * 1e9 stands for 1 × 10^9 <br>
 * use the example of sum of array
 */
public class DynamicLazySegmentTree {
    static class SegmentNode {
        int rangeL, rangeR, rangeM;
        int lazyLeft, lazyRight;
        int val;
        int lazyVal;
        SegmentNode leftChild;
        SegmentNode rightChild;

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
    }

    static SegmentNode root = new SegmentNode(0, 100);
//    static SegmentNode root = new SegmentNode(0, (int) 1e9);

    public static void update(int l, int r, int value) {
        update(root, l, r, value);
    }

    private static void update(SegmentNode cur, int l, int r, int value) {
        int lazyValue = cur.lazyVal;
        if (lazyValue != 0) {
            cur.val += (cur.rangeR - cur.rangeL + 1) * lazyValue;
            cur.lazyVal = 0;
            cur.lazyLeft += lazyValue;
            cur.lazyRight += lazyValue;
            return;
        }

        if (l <= cur.rangeL && r >= cur.rangeR) {
            cur.lazyLeft += value;
            cur.lazyRight += value;
            cur.val += (cur.rangeR - cur.rangeL + 1) * value;
            return;
        }
        if (l < cur.rangeM) {
            if (cur.leftChild == null)
                cur.leftChild = new SegmentNode(cur.rangeL, cur.rangeM);
            cur.leftChild.lazyVal = cur.lazyLeft;
            cur.lazyLeft = 0;
            update(cur.leftChild, l, r, value);
        }
        if (r > cur.rangeM) {
            if (cur.rightChild == null)
                cur.rightChild = new SegmentNode(cur.rangeM, cur.rangeR);
            cur.rightChild.lazyVal = cur.lazyRight;
            cur.lazyRight = 0;
            update(cur.rightChild, l, r, value);
        }
    }

    public static void main(String[] args) {
        update( 40, 60 ,10);
        System.out.println();
    }

}
