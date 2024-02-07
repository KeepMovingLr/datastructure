package segmenttree;

/**
 * Similar to SegmentTree, I just use a class as TreeNode to make it easy to understand
 */
public class MyLazySegmentTree<E> {
    class SegmentNode<E> {

        int rangeL;
        int rangeM;
        int rangeR;
        E val;

        SegmentNode<E> leftChild;
        SegmentNode<E> rightChild;

        public SegmentNode(int rangeL, int rangeR) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
        }

        public SegmentNode(int rangeL, int rangeR, E val) {
            this.rangeL = rangeL;
            this.rangeR = rangeR;
            this.rangeM = rangeL + (rangeR - rangeL) / 2;
            this.val = val;
        }
    }

    private E[] data;
    private Merger<E> merger;

    private SegmentNode<E> root;

    public MyLazySegmentTree(E[] data, Merger<E> merger) {
        this.data = data;
        this.merger = merger;
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
        SegmentNode<E> node = new SegmentNode(l, r);
        node.leftChild = buildSegmentTree(l, node.rangeM);
        node.rightChild = buildSegmentTree(node.rangeM + 1, r);
        node.val = merger.merge(node.leftChild.val, node.rightChild.val);
        return node;
    }

    public E query(int queryL, int queryR) {
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
    private E query(SegmentNode<E> root, int queryL, int queryR) {
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

        E leftVal = query(root.leftChild, queryL, root.rangeM);
        E rightVal = query(root.rightChild, root.rangeM + 1, queryR);
        return merger.merge(leftVal, rightVal);
    }

    /**
     * @param index
     * @param value
     */
    public void update(int index, E value) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = value;
        set(root, index, value);
    }

    private void set(SegmentNode<E> root, int index, E value) {
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
        root.val = merger.merge(root.leftChild.val, root.rightChild.val);
    }
}
