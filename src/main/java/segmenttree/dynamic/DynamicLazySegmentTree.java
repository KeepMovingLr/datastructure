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

    static SegmentNode root = new SegmentNode(0, 10);
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
        if (l > cur.rangeR || r < cur.rangeL)
            return;

        if (l <= cur.rangeL && r >= cur.rangeR) {
            cur.lazyLeft += value;
            cur.lazyRight += value;
            cur.val += (cur.rangeR - cur.rangeL + 1) * value;
            return;
        }
        if (l <= cur.rangeM) {
            if (cur.leftChild == null)
                cur.leftChild = new SegmentNode(cur.rangeL, cur.rangeM);
            cur.leftChild.lazyVal = cur.lazyLeft;
            cur.lazyLeft = 0;
            update(cur.leftChild, l, r, value);
        }
        if (r >= cur.rangeM + 1) {
            if (cur.rightChild == null)
                cur.rightChild = new SegmentNode(cur.rangeM + 1, cur.rangeR);
            cur.rightChild.lazyVal = cur.lazyRight;
            cur.lazyRight = 0;
            update(cur.rightChild, l, r, value);
        }
    }

    public static int query(int l, int r) {
        if (l > root.rangeR || r < root.rangeL)
            return 0;
        return query(root, l, r);
    }

    public static int query(SegmentNode cur, int l, int r) {
        int lazyValue = cur.lazyVal;
        if (lazyValue != 0) {
            cur.val += (cur.rangeR - cur.rangeL + 1) * lazyValue;
            cur.lazyVal = 0;
            cur.lazyLeft += lazyValue;
            cur.lazyRight += lazyValue;
        }
        if (l <= cur.rangeL && r >= cur.rangeR) {
            return cur.val;
        }
        if (l > cur.rangeR || r < cur.rangeL)
            return 0;
        int leftSum = 0;
        int rightSum = 0;
        if (r <= cur.rangeM) {
            if (cur.leftChild == null) {
                cur.leftChild = new SegmentNode(cur.rangeL, cur.rangeM);
                cur.leftChild.lazyVal = cur.lazyLeft;
                cur.lazyLeft = 0;
            }
            return query(cur.leftChild, l, r);
        }
        if (l >= cur.rangeM + 1) {
            if (cur.rightChild == null) {
                cur.rightChild = new SegmentNode(cur.rangeM + 1, cur.rangeR);
                cur.rightChild.lazyVal = cur.lazyRight;
                cur.lazyRight = 0;
            }
            return query(cur.rightChild, l, r);
        }
        if (cur.leftChild == null) {
            cur.leftChild = new SegmentNode(cur.rangeL, cur.rangeM);
            cur.leftChild.lazyVal = cur.lazyLeft;
            cur.lazyLeft = 0;
        }
        leftSum = query(cur.leftChild, l, r);
        if (cur.rightChild == null) {
            cur.rightChild = new SegmentNode(cur.rangeM + 1, cur.rangeR);
            cur.rightChild.lazyVal = cur.lazyRight;
            cur.lazyRight = 0;
        }
        rightSum = query(cur.rightChild, l, r);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        System.out.println();
        update(0, 10, 1);
        System.out.println(query(0, 10));
        System.out.println();
        System.out.println(query(0, 5));
        System.out.println();
        System.out.println(query(3, 5));
        System.out.println();
        System.out.println(query(3, 5));
        System.out.println();
        update(0, 10, 1);
        System.out.println(query(0, 10));
        System.out.println();
    }

}
