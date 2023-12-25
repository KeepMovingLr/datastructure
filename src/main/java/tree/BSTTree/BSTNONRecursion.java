package tree.BSTTree;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: BSTNONRecursion.java, v 0.1 2019‐05‐12 11:03 PM enyi.lr Exp $$
 */
public class BSTNONRecursion<E extends Comparable> {

    private Node root;

    private int size;

    private class Node {
        public E    value;
        public Node left, right;

        public Node(E value) {
            this.value = value;
            left = null;
            right = null;

        }
    }

    /*************************************************************************************************/

    /**
     * 广度优先遍历
     */
    public void levelTraversal() {
        ArrayDeque<Node> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();
            // 以print代替操作
            System.out.println(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /*************************************************************************************************/
    /**
     * 广度优先遍历 折线输出
     */
    public void levelTraversalZigzag() {
        ArrayDeque<Node> queue = new ArrayDeque();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            Node first = queue.getFirst();
            // 以print代替操作
            System.out.println(first.value);
            if (i % 2 == 0) {
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            } else {
                if (first.right != null) {
                    queue.add(first.right);
                }
                if (first.left != null) {
                    queue.add(first.left);
                }

            }
            i++;

        }
    }

    /*************************************************************************************************/

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * preorder traversal of a tree which root is root in the way of non recursion
     *
     * @param root
     */
    private void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            visitNode(pop);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

    }

    private void visitNode(Node node) {
        // 以输出代替访问。其他题目中，经常是要先存储到一个集合之类的 set.add(root.value);
        System.out.println(node.value);
    }

    /*************************************************************************************************/
    // todo remember it
    private void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            visitNode(cur);
            cur = cur.right;
        }
    }

    /*************************************************************************************************/

    // todo  postorder traversal of a tree which root is root in the way of non recursion



    /*************************************************************************************************/
    // todo minimum()  and maximum()

    public E minimum() {
        return null;
    }
    /*************************************************************************************************/




    /*************************************************************************************************/
    /*************************************************************************************************/
    /*************************************************************************************************/
    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

}