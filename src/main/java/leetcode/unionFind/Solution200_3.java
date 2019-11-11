package leetcode.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution200_3.java, v 0.1 2019‐11‐11 12:16 PM enyi.lr Exp $$ v2 使用并查集的思想，给每一个编号为一个集合，编号后计算不同的集合有多少个。
 */
public class Solution200_3 {

    // 使用并查集的思想，给每一个编号
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;
        int[] parent = new int[total];
        int[] rank = new int[total];
        // 编号
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parent[i * cols + j] = i * cols + j;
                rank[i * cols + j] = 1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    parent[i * cols + j] = -1;
                } else {
                    //int unionNum = find(i * rows + j, parent);
                    // left
                    if (j > 0) {
                        if (grid[i][j - 1] == '1') {
                            union(parent, rank, i * cols + j, i * cols + j - 1);
                        }
                    }
                    // up
                    if (i > 0) {
                        if (grid[i - 1][j] == '1') {
                            union(parent, rank, i * cols + j, (i - 1) * cols + j);
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                set.add(find(i, parent));
            }
        }
        set.remove(-1);
        return set.size();
    }

    private void union(int[] parent, int[] rank, int i, int i1) {
        int union1 = find(i, parent);
        int union2 = find(i1, parent);
        if (union1 == union2) {
            return;
        }
        if (rank[union1] > rank[union2]) {
            parent[union2] = union1;
        } else if (rank[union1] < rank[union2]) {
            parent[union1] = union2;
        } else {
            parent[union2] = union1;
            rank[union1]++;
        }

    }

    private int find(int index, int[] parents) {
        while (parents[index] != index) {
            // path compression
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
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
        Solution200_3 solution200 = new Solution200_3();
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }

}