package lc.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution200.java, v 0.1 2019‐06‐03 10:55 PM enyi.lr Exp $$
 * v2
 */
public class Solution200 {
    private class UnionFind {
        private int[] id;

        public UnionFind(int size) {
            this.id = new int[size];
            for (int i = 0; i < id.length; i++) {
                // use -1 represents the element has not been defined as an island or water.
                id[i] = -1;
            }
        }

        public void unionElements(int p, int q) {
            int unionP = find(p);
            int unionQ = find(q);
            if (unionP == unionQ) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (find(i) == unionP) {
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
                    unionFind.id[i * columnNum + j] = i * columnNum + j;
                }
            }

        }
        // connected
        int[] id = unionFind.id;
        int size = unionFind.id.length;
        for (int i = 0; i < id.length; i++) {
            if (id[i] >= 0) {
                if (i % columnNum != (columnNum - 1)) {
                    if (id[i + 1] >= 0) {
                        unionFind.unionElements(i, i + 1);
                    }
                }
                if (i + columnNum < size) {
                    if (id[i + columnNum] > 0) {
                        unionFind.unionElements(i, i + columnNum);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < id.length; i++) {
            set.add(id[i]);
        }
        set.remove(-1);
        return set.size();
    }

    public static void main(String[] args) {
        String chars = "0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,0,0,0,1,0,1,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,0,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,1,1,0,1,0,0,1,1,0,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,1,1,0,0,1,1,0,0,1,1,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,1,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,1,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0";
        String[] split = chars.split(",");
        char[][] grid = new char[20][20];
        for (int i = 0; i < split.length; i++) {
            grid[i / 20][i % 20] = split[i].charAt(0);
        }
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        Solution200 solution200 = new Solution200();
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }

}