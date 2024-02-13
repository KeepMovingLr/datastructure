package segmenttree;

/**
 * Lazy Propagation in Segment tree
 * the merge method here is sum
 */

public class MyLazySegmentTree {
    class SegmentNode {

        int rangeL;
        int rangeM;
        int rangeR;
        int lazy;
        int val;

        SegmentNode leftChild;
        SegmentNode rightChild;

        public SegmentNode(int rangeL, int rangeR) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
            this.lazy = 0;
        }

        public SegmentNode(int rangeL, int rangeR, int val) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
            this.val = val;
            this.lazy = 0;
        }
    }

    private int[] data;

    private SegmentNode root;

    public MyLazySegmentTree(int[] data) {
        this.data = data;
        this.root = buildSegmentTree(0, data.length - 1);
    }

    /**
     * build a segment tree, stands for range [l , r]
     *
     * @param l
     * @param r
     * @return the Root of the Segment Tree
     */
    private SegmentNode buildSegmentTree(int l, int r) {
        if (l == r) {
            return new SegmentNode(l, r, data[l]);
        }
        SegmentNode node = new SegmentNode(l, r);
        node.leftChild = buildSegmentTree(l, node.rangeM);
        node.rightChild = buildSegmentTree(node.rangeM + 1, r);
        node.val = node.leftChild.val + node.rightChild.val;
        return node;
    }

    public int query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(root, queryL, queryR);
    }

    /**
     * query the result
     *
     * @param root
     * @param queryL
     * @param queryR
     * @return
     */
    private int query(SegmentNode root, int queryL, int queryR) {
        int lazy = root.lazy;
        // lazy update first
        if (lazy != 0) {
            root.val += lazy * (queryR - queryL + 1);
            root.lazy = 0;
            if (root.leftChild != null)
                root.leftChild.lazy = lazy;
            if (root.rightChild != null)
                root.rightChild.lazy = lazy;
        }
        if (root.rangeL == queryL && root.rangeR == queryR) {
            return root.val;
        }

        // check if we need to query left or right
        if (queryR <= root.rangeM) {
            return query(root.leftChild, queryL, queryR);
        }

        if (queryL >= root.rangeM + 1) {
            return query(root.rightChild, queryL, queryR);
        }

        int leftVal = query(root.leftChild, queryL, root.rangeM);
        int rightVal = query(root.rightChild, root.rangeM + 1, queryR);
        return leftVal + rightVal;
    }

    /**
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = value;
        set(root, index, value);
    }

    private void set(SegmentNode root, int index, int value) {
        if (root.rangeL == root.rangeR) {
            root.val = value;
            return;
        }
        if (index <= root.rangeM) {
            set(root.leftChild, index, value);
        }
        if (index >= root.rangeM + 1) {
            set(root.rightChild, index, value);
        }
        root.val = root.leftChild.val + root.rightChild.val;
    }

    /**
     * range update, update [from,end] , for each element in [from,end] , add by addVal
     *
     * @param from
     * @param end
     * @param addVal
     */
    public void updateRange(int from, int end, int addVal) {
        if (from < 0 || from >= data.length || end < 0 || end >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        updateRange(root, from, end, addVal);
    }

    private void updateRange(SegmentNode root, int from, int end, int addVal) {
        if (root.rangeL == from && root.rangeR == end) {
            if (root.lazy != 0) {
                root.val += root.lazy;
                root.lazy = 0;
            }
            root.val += (end - from + 1) * addVal;
            if (root.leftChild != null)
                root.leftChild.lazy = addVal;
            if (root.rightChild != null)
                root.rightChild.lazy = addVal;
            return;
        }
        if (end <= root.rangeM) {
            // update on left
            updateRange(root.leftChild, from, end, addVal);
        } else if (from >= root.rangeM + 1) {
            // update on right
            updateRange(root.rightChild, from, end, addVal);
        } else if (from <= root.rangeM && end >= root.rangeM + 1) {
            updateRange(root.leftChild, from, root.rangeM, addVal);
            updateRange(root.leftChild, root.rangeM + 1, end, addVal);
        }
        root.val = root.leftChild.val + root.rightChild.val;
    }
}
