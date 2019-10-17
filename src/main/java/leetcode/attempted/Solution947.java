package leetcode.attempted;

/**
 * @author enyi.lr
 * @version $Id: Solution947.java, v 0.1 2019‐06‐28 12:26 PM enyi.lr Exp $$
 */
public class Solution947 {

    public int removeStones(int[][] stones) {
        int coordinateNum = stones.length;
        if (coordinateNum == 0 || coordinateNum == 1) {
            return 0;
        }
        boolean[] deleted = new boolean[coordinateNum];
        for (int i = 0; i < coordinateNum; i++) {
            if (!deleted[i]) {
                dfs(stones, i, deleted);
            }

        }

        int count = 0;
        for (int i = 0; i < deleted.length; i++) {
            if (deleted[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param stones
     * @param index   the index of the stone
     * @param deleted
     */
    public void dfs(int[][] stones, int index, boolean[] deleted) {
        // check the index stone
        int[] coordinate = stones[index];
        int horizontal = coordinate[0];
        int vertical = coordinate[1];
        for (int i = 0; i < stones.length; i++) {
            if (i != index && !deleted[i]) {
                if (stones[i][0] == horizontal || stones[i][1] == vertical) {
                    deleted[index] = true;
                    dfs(stones, i, deleted);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 1}, {2, 2}, {3, 2}, {3, 3}, {3, 4}, {4, 3}, {4, 4}};
        Solution947 solution947 = new Solution947();
        int i = solution947.removeStones(stones);
        System.out.println("count:" + i);
    }

}