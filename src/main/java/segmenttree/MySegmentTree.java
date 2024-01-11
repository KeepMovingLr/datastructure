package segmenttree;

/**
 * Similar to SegmentTree, I just use a class as TreeNode to make it easy to understand
 */
public class MySegmentTree<E> {
    class TreeNode<E>{
        int treeIdx;
        int rangeL;
        int rangeR;
        E val;

        public TreeNode(int treeIdx, int rangeL, int rangeR) {
            this.treeIdx = treeIdx;
            this.rangeL = rangeL;
            this.rangeR = rangeR;
        }

    }

    public MySegmentTree(E[] data) {
        this.data = data;
        this.tree = new TreeNode[data.length * 4];
    }

    E[] data;
    TreeNode[] tree;



}
