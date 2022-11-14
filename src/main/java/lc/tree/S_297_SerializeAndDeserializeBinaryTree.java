package lc.tree;

import lc.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution297.java, v 0.1 2019‐06‐12 11:54 AM enyi.lr Exp $$ v2 2019/12/16
 */
public class S_297_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        S_297_SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new S_297_SerializeAndDeserializeBinaryTree();
        System.out.println(serializeAndDeserializeBinaryTree.serialize(root));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        serializeRecursive(root, nodes);
        StringBuilder stringBuilder = new StringBuilder();
        for (String node : nodes) {
            stringBuilder.append(node).append(",");
        }
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }

    public void serializeRecursive(TreeNode node, List<String> nodes) {
        if (node == null) {
            nodes.add("null");
        } else {
            nodes.add(String.valueOf(node.val));
            serializeRecursive(node.left, nodes);
            serializeRecursive(node.right, nodes);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>();
        String[] split = data.split(",");
        for (String s : split) {
            nodes.add(s);
        }
        return deserializeRecursive(nodes);
    }

    public TreeNode deserializeRecursive(List<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        if (nodes.get(0).equals("null")) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = deserializeRecursive(nodes);
        root.right = deserializeRecursive(nodes);
        return root;
    }

}