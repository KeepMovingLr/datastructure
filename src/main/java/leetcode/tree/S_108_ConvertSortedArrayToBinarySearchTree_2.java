package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution108.java, v 0.1 2019‐06‐29 12:05 AM enyi.lr Exp $$
 */
public class S_108_ConvertSortedArrayToBinarySearchTree_2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return getRoot(nums, 0, nums.length - 1);
    }

    /**
     * get the middle largest element as a root of a tree in sub array[begin,ent]
     *
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public TreeNode getRoot(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int middle = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.right = getRoot(nums, middle + 1, end);
        root.left = getRoot(nums, begin, middle - 1);
        return root;
    }
}