package lc.tree;

import lc.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_257_BinaryTreePaths.java, v 0.1 2019‐12‐06 9:36 PM enyi.lr Exp $$
 */
public class S_257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<List<String>> lists = binaryTreePathList(root);
        if (lists != null){
            for (List<String> list : lists) {
                StringBuilder stringBuilder = new StringBuilder();
                Collections.reverse(list);
                for (String s : list) {
                    stringBuilder.append(s).append("->");
                }
                String re = stringBuilder.toString();
                result.add(re.substring(0, re.length() - 2));
            }
        }

        return result;
    }

    public List<List<String>> binaryTreePathList(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        if (isLeaf(treeNode)) {
            List<String> path = new ArrayList<>();
            path.add(String.valueOf(treeNode.val));
            result.add(path);
            return result;
        }
        if (treeNode.left != null && treeNode.right != null) {
            List<List<String>> leftPaths = binaryTreePathList(treeNode.left);
            List<List<String>> rightPaths = binaryTreePathList(treeNode.right);
            for (List<String> leftPath : leftPaths) {
                leftPath.add(String.valueOf(treeNode.val));
            }
            for (List<String> rightPath : rightPaths) {
                rightPath.add(String.valueOf(treeNode.val));
            }
            result.addAll(leftPaths);
            result.addAll(rightPaths);
            return result;
        }
        if (treeNode.left == null) {
            List<List<String>> rightPaths = binaryTreePathList(treeNode.right);
            for (List<String> rightPath : rightPaths) {
                rightPath.add(String.valueOf(treeNode.val));
            }
            result.addAll(rightPaths);
            return result;
        } else {
            List<List<String>> leftPaths = binaryTreePathList(treeNode.left);
            for (List<String> leftPath : leftPaths) {
                leftPath.add(String.valueOf(treeNode.val));
            }
            result.addAll(leftPaths);
            return result;
        }
    }

    public boolean isLeaf(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        return treeNode.left == null && treeNode.right == null;
    }

}