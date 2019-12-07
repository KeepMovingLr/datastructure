package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: S_437_PathSumIII.java, v 0.1 2019‐12‐07 12:08 PM enyi.lr Exp $$
 */
public class S_437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        int sum1 = findPath(root, sum);
        int sum2 = pathSum(root.left, sum);
        int sum3 = pathSum(root.right, sum);

        return sum1 + sum2 + sum3;
    }

    /**
     * 在以node为根节点的二叉树中，寻找包含node的路径(不一定非要到叶子节点)，和为sum
     *
     * @param node
     * @param num  满足条件的路径的个数
     * @return
     */
    public int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (node.val == num) {
            result++;
            // 由于有负数，所以不能直接返回
        }
        result = result + findPath(node.left, num - node.val);
        result = result + findPath(node.right, num - node.val);
        return result;
    }

}