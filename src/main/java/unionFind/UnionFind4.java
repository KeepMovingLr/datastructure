package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UnionFind1.java, v 0.1 2019‐06‐02 10:16 PM enyi.lr Exp $$
 * optimize according to rank
 */
public class UnionFind4 implements UF {

    // we use parent[i] to represent the parent of the element which index is i
    private int[] parent;

    // rank[i] represents the tree height of elements which union number is i ( which root is i)
    private int[] rank;

    public UnionFind4(int size) {
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
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}