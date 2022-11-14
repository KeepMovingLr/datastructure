package lc.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution200.java, v 0.1 2019‐06‐03 10:55 PM enyi.lr Exp $$
 */
public class Solution200_2 {
    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];
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
                rank[unionP] = rank[unionP] + 1;
            }

        }

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

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        char[] oneline = grid[0];
        int columnNum = oneline.length;
        int rowNum = grid.length;
        UnionFind unionFind = new UnionFind(columnNum * rowNum);
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    unionFind.parent[i * columnNum + j] = i * columnNum + j;
                } else {
                    unionFind.parent[i] = -1;
                }
            }

        }
        // connected
        int[] parent = unionFind.parent;
        int size = unionFind.parent.length;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] >= 0) {
                if (i % columnNum != (columnNum - 1)) {
                    if (parent[i + 1] >= 0) {
                        unionFind.unionElements(i, i + 1);
                    }
                }
                if (i + columnNum < size) {
                    if (parent[i + columnNum] > 0) {
                        unionFind.unionElements(i, i + columnNum);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if (unionFind.parent[i] != -1) {
                set.add(unionFind.find(i));
            }

        }
        return set.size();
    }

    public static void main(String[] args) {
        String chars = "1,1,1,1,0,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0";
        String[] split = chars.split(",");
        char[][] grid = new char[4][5];
        for (int i = 0; i < split.length; i++) {
            grid[i / 5][i % 5] = split[i].charAt(0);
        }
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        Solution200_2 solution200 = new Solution200_2();
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }

}