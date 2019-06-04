package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UnionFind1.java, v 0.1 2019‐06‐02 10:16 PM enyi.lr Exp $$
 */
public class UnionFind6 implements UF {

    // we use parent[i] to represent the parent of the element which index is i
    private int[] parent;

    // rank[i]表示以i为根的集合所表示的树的层数
    // 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
    // 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
    // rank[i] represents the tree height of elements which union number is i ( which root is i)
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        // let id[i] = i, means there is no union element
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // time complexity O(h)  h is the height of the tree
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int unionP = find(p);
        int unionQ = find(q);
        if (unionP == unionQ) {
            return;
        }
        int pHeight = rank[unionP];
        int qHeight = rank[unionQ];
        if (pHeight > qHeight) {
            parent[unionQ] = unionP;
        } else if (qHeight < qHeight) {
            parent[unionP] = unionQ;
        } else {
            parent[unionQ] = unionP;
            rank[unionP] = rank[unionP] + 1;
        }

    }

    // find the union number of the element which index is p
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}