package leetcode.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution547.java, v 0.1 2019‐06‐02 11:12 PM enyi.lr Exp $$
 */
public class Solution547_2 {
    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void unionElements(int p, int q) {
            int unionP = find(p);
            int unionQ = find(q);
            if (unionP == unionQ) {
                return;
            }
            if (rank[unionP] > rank[unionQ]) {
                parent[unionQ] = unionP;
            } else if (rank[unionQ] > rank[unionP]) {
                parent[unionP] = unionQ;
            } else {
                parent[unionQ] = unionP;
                rank[unionP] += 1;
            }
        }

        // return the union number of p
        private int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }
    }

    public int findCircleNum(int[][] M) {
        int length = M.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    if (M[i][j] == 1) {
                        unionFind.unionElements(i, j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < unionFind.parent.length; i++) {
            set.add(unionFind.find(i));
        }
        return set.size();
    }

}