package lc.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution547_3.java, v 0.1 2019‐06‐26 11:06 PM enyi.lr Exp $$
 */
public class Solution547_3 {
    class UnionFind {
        int[] parent;
        int   size;

        public UnionFind(int size) {
            parent = new int[size];
            this.size = size;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int p1 = findParent(i);
            int p2 = findParent(j);
            if (p1 == p2) {
                return;
            }
            parent[p1] = p2;
        }

        public int findParent(int i) {
            while (i != parent[i]) {
                i = parent[i];
            }
            return i;
        }

    }

    public int findCircleNum(int[][] M) {
        int length = M.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(unionFind.findParent(i));
        }
        return set.size();

    }

}