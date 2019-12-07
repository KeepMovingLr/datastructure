package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution108.java, v 0.1 2019‐06‐29 12:05 AM enyi.lr Exp $$
 */
public class S_108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        return getRoot(nums, 0, length - 1);
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode getRoot(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(nums, left, mid - 1);
        root.right = getRoot(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};
        S_108_ConvertSortedArrayToBinarySearchTree solution108 = new S_108_ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = solution108.sortedArrayToBST(nums);
        System.out.println();
    }
}