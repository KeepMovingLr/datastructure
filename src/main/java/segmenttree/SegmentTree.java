package segmenttree;

/**
 * @author enyi.lr
 * @version $Id: SegmentTree.java, v 0.1 2019‐06‐01 1:38 PM enyi.lr Exp $$
 * Segment Tree, Interval Tree
 * 给定一个区间（区间是固定的，但是区间中的元素可能是动态变化的），
 * 更新：更新区间中一个元素或者一个区间的值 O(log(n))
 * 查询一个区间[i,j]的最大值,最小值 或者 区间数据和  O(log(n))
 * <p>
 * 线段树是 二叉树，是个平衡二叉树，但不是满二叉树或者完全二叉树
 * 如果区间有n个元素，数组表示需要4n个空间，我们的线段树不考虑添加元素，即区间固定，使用4n的静态空间即可 (以空间换时间)
 * 这种方式有点像预计算的方式，先计算出一些数据，然后留着备用
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] data, Merger<E> merger) {
        this.data = (E[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        this.tree = (E[]) new Object[data.length * 4];
        this.merger = merger;
        // build Segment Tree
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * notice the definition
     * 在treeIndex的位置创建表示区间[i,j]的线段树
     *
     * @param rootIndex the root index of segment tree
     * @param l         the left index of data which wants to be built a segment tree
     * @param r         the right index of data which wants to be built a segment tree
     */
    private void buildSegmentTree(int rootIndex, int l, int r) {
        if (l == r) {
            tree[rootIndex] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChild(rootIndex), l, mid);
        buildSegmentTree(rightChild(rootIndex), mid + 1, r);
        tree[rootIndex] = merger.merge(tree[leftChild(rootIndex)], tree[rightChild(rootIndex)]);
    }

    /**
     * query the interval of data[queryL,queryR]
     *
     * @param queryL left index of the interval which wants to be queried;
     * @param queryR right index of the interval which wants to be queried;
     * @return result of the interval
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeRoot为根的线段树中代表的[l...r]的范围里，搜索区间[queryL...queryR]的值.
     * if treeRoot is 0, the segment represents data[0,data.length-1]
     * if treeRoot is 1, the segment represents data[0,mid]  mid = 0 + (data.length-0)/2;
     * if treeRoot is 2, the segment represents data[mid+1,data.length-1]  mid = 0 + (data.length-0)/2;
     *
     * @param treeRoot
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeRoot, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeRoot];
        }
        int mid = l + (r - l) / 2;
        if (mid >= queryR) {
            // find result from left sub tree
            return query(leftChild(treeRoot), l, mid, queryL, queryR);

        }
        if (mid + 1 <= queryL) {
            // find result from right  sub tree
            return query(rightChild(treeRoot), mid + 1, r, queryL, queryR);
        }
        E leftResult = query(leftChild(treeRoot), l, mid, queryL, mid);
        E rightResult = query(rightChild(treeRoot), mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * update data[index] to value
     *
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = value;
        set(0, 0, data.length - 1, index, value);
    }

    private void set(int treeRoot, int l, int r, int index, E value) {
        if (l == r) {
            tree[treeRoot] = value;
            return;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            // left
            set(leftChild(treeRoot), l, mid, index, value);
        }
        if (index >= mid + 1) {
            // right
            set(rightChild(treeRoot), mid + 1, r, index, value);
        }
        tree[treeRoot] = merger.merge(tree[leftChild(treeRoot)], tree[rightChild(treeRoot)]);

    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}