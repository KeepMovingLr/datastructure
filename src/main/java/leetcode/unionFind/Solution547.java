package leetcode.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution547.java, v 0.1 2019‐06‐02 11:12 PM enyi.lr Exp $$
 * v2
 */
public class Solution547 {
    private class UnionFind2 {
        private int[] parent;
        private int[] rank;

        public UnionFind2(int size) {
            parent = new int[size];
            rank = new int[size];

            // let id[i] = i, means there is no union element
            for (int i = 0; i < parent.length; i++) {
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
            int pHeight = rank[unionP];
            int qHeight = rank[unionQ];
            if (pHeight > qHeight) {
                parent[unionQ] = unionP;
            } else if (qHeight < qHeight) {
                parent[unionP] = unionQ;
            } else {
                parent[unionQ] = unionP;
                rank[p] = rank[p] + 1;
            }
        }

        private int find(int p) {
            if (p < 0 || p >= parent.length) {
                throw new IllegalArgumentException("p is out of bound.");
            }
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

    }

    private class UnionFind {
        private int[] id;

        public UnionFind(int size) {
            id = new int[size];
            // let id[i] = i, means there is no union element
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

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

        private int find(int p) {
            if (p < 0 || p >= id.length) {
                throw new IllegalArgumentException("p is out of bound.");
            }
            return id[p];
        }

    }

    UnionFind  unionfind;
    UnionFind2 unionfind2;

    public int findCircleNum(int[][] M) {
        unionfind = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j) {
                    if (M[i][j] == 1) {
                        unionfind.unionElements(i, j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int index : unionfind.id) {
            set.add(index);
        }
        return set.size();
    }

    public int findCircleNum2(int[][] M) {
        unionfind2 = new UnionFind2(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j) {
                    if (M[i][j] == 1) {
                        unionfind2.unionElements(i, j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int index : unionfind2.parent) {
            if (index == unionfind2.parent[index]) {
                set.add(index);
            }
        }
        return set.size();
    }

    public int findCircleNum3(int[][] M) {
        unionfind2 = new UnionFind2(M.length);
        int count = M.length;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i != j){
                    if (M[i][j] == 1){
                        unionfind2.unionElements(i,j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(unionfind2.find(i));
        }
        return set.size();
    }
}