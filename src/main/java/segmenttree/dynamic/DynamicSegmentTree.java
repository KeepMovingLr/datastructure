package segmenttree.dynamic;


/**
 * https://www.geeksforgeeks.org/dynamic-segment-trees-online-queries-for-range-sum-with-point-updates/?ref=lbp
 * <p>
 * Dynamic Segment Tree: similar to Segment tree but with some properties:
 * Instead of using an array to represent the intervals, a node is created whenever a new interval is to be updated.
 * class SegmentNode {
 * int value;
 * SegmentNode L , R;
 * }
 * the above structure is the same as a Binary Search Tree.
 * The Interval of the root is from [1, N]
 * the interval of the left subtree will be [1, N/2] and the interval for the right subtree will be [N/2 + 1, N].
 * We are creating a new node only when required.
 */
public class DynamicSegmentTree {
    static class SegmentNode {
        int rangeL, rangeR, rangeM;
        int val;
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
    }

    public static SegmentNode getNode(int rangeL, int rangeR) {
        SegmentNode node = new SegmentNode();
        node.rangeL = rangeL;
        node.rangeR = rangeR;
        node.rangeM = rangeL + (rangeR - rangeL) / 2;
        return node;
    }

    static SegmentNode root = new SegmentNode(0, (int) Math.pow(10, 7), 0);

    static void updateHelper(SegmentNode cur, int index, int val) {
        if (index < cur.rangeL || index > cur.rangeR)
            return;
        if (index == cur.rangeL && index == cur.rangeR) {
            cur.val = val;
            return;
        }
        if (index <= cur.rangeM) {
            if (cur.leftChild == null)
                cur.leftChild = getNode(cur.rangeL, cur.rangeM);
            updateHelper(cur.leftChild, index, val);
        } else {
            if (cur.rightChild == null)
                cur.rightChild = getNode(cur.rangeM + 1, cur.rangeR);
            updateHelper(cur.rightChild, index, val);
        }

        int sum1 = 0, sum2 = 0;

        if (cur.leftChild != null)
            sum1 = cur.leftChild.val;
        if (cur.rightChild != null)
            sum2 = cur.rightChild.val;
        cur.val = sum1 + sum2;
    }

    /**
     * Function to find the sum of the values given by the range.
     *
     * @param cur
     * @return
     */
    static int queryHelper(SegmentNode cur, int l, int r) {
        // Return 0 if the root is null
        if (cur == null)
            return 0;
        // If the index is not overlapping with the index, then the node is not created. sum is 0
        if (cur.rangeL > r || cur.rangeR < l)
            return 0;
        // If the index is completely overlapping with the index, return the node's value
        if (l <= cur.rangeL && r >= cur.rangeR)
            return cur.val;
        if (r <= cur.rangeM)
            return queryHelper(cur.leftChild, l, r);
        if (l >= cur.rangeM + 1)
            return queryHelper(cur.rightChild, l, r);
        return queryHelper(cur.leftChild, l, cur.rangeM) + queryHelper(cur.rightChild, cur.rangeM + 1, r);
    }

    static int query(int l, int r) {
        return queryHelper(root, l, r);
    }

    static void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public static void main(String[] args) {
        System.out.println(query(0, 10));
        updateHelper(root, 1, 10);
        System.out.println(query(0, 10));
    }
}
