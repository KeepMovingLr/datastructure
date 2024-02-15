package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UnionFind1.java, v 0.1 2019‐06‐02 10:16 PM enyi.lr Exp $$
 * Quick find <br>
 * find - O(1) <br>
 * union - O(n) <br>
 */
public class UnionFind1 implements UF {
    // 我们的第一版Union-Find本质就是一个数组. I think it can also implement with map
    // we use id[i] represents the union number of the element which index is i
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        // let id[i] = i, means there is no union element
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // time complexity O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // time complexity O(n)
    @Override
    public void unionElements(int p, int q) {
        int unionP = find(p);
        int unionQ = find(q);
        if (unionP == unionQ) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == unionP) {
                id[i] = unionQ;
            }
        }
    }

    /**
     * find the union number of element p.
     * time complexity: O(1)
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}