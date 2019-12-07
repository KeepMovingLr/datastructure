package leetcode.queue;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author enyi.lr
 * @version $Id: S_199_BinaryTreeRightSideView.java, v 0.1 2019‐12‐04 1:26 PM enyi.lr Exp $$
 */
public class S_199_BinaryTreeRightSideView {
    class TreeNodePair {
        TreeNode treeNode;

        Integer level;

        public TreeNodePair(TreeNode treeNode, Integer level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            TreeNodePair that = (TreeNodePair) o;
            return Objects.equals(treeNode, that.treeNode) &&
                    Objects.equals(level, that.level);
        }

        @Override
        public int hashCode() {
            return Objects.hash(treeNode, level);
        }

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            result.add(list.get(list.size() - 1));
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNodePair> queue = new ArrayDeque<>();
        queue.add(new TreeNodePair(root, 0));

        while (!queue.isEmpty()) {
            TreeNodePair treeNodePair = queue.remove();
            TreeNode treeNode = treeNodePair.treeNode;
            Integer level = treeNodePair.level;
            // how to check if the level list has exist
            if (result.size() == level) {
                List<Integer> levelList = new ArrayList<>();
                levelList.add(treeNode.val);
                result.add(levelList);
            } else {
                result.get(level).add(treeNode.val);
            }
            if (treeNode.left != null) {
                queue.add(new TreeNodePair(treeNode.left, level + 1));
            }
            if (treeNode.right != null) {
                queue.add(new TreeNodePair(treeNode.right, level + 1));
            }

        }
        return result;

    }

}