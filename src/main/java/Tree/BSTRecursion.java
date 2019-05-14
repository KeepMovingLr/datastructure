package Tree;

/**
 * @author enyi.lr 递归实现
 * @version $Id: BSTRecursion.java, v 0.1 2019‐05‐12 11:01 PM enyi.lr Exp $$
 */
public class BSTRecursion<E extends Comparable> {

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

    public void add_1(E e) {
        if (root == null) {
            this.root = new Node(e);
            size = 1;
        } else {
            add_1(root, e);
        }
    }

    //  add an Element E to the Binary Search Tree which root is currentRoot with the recursion algorithm
    public void add_1(Node currentRoot, E e) {
        Node newNode = new Node(e);
        if (e.compareTo(currentRoot.value) < 0 && currentRoot.left == null) {
            currentRoot.left = newNode;
            size++;
            return;
        }
        if (e.compareTo(currentRoot.value) > 0 && currentRoot.right == null) {
            currentRoot.right = newNode;
            return;
        }

        if (e.compareTo(currentRoot.value) < 0) {
            add_1(currentRoot.left, e);
            return;
        }
        if (e.compareTo(currentRoot.value) > 0) {
            add_1(currentRoot.right, e);
            return;
        }

    }

    /*************************************************************************************************/

    /**
     * add an Element E to the tree which root is currentRoot and return the new root of the tree after adding a new element
     *
     * @param currentRoot the root of the tree
     * @param e           the element to be added
     * @return the new root of the tree after adding a new element
     */
    public Node add_2(Node currentRoot, E e) {
        if (currentRoot == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(currentRoot.value) < 0) {
            Node node = add_2(currentRoot.left, e);
            currentRoot.left = node;
            return currentRoot;
        }
        if (e.compareTo(currentRoot.value) > 0) {
            Node node = add_2(currentRoot.right, e);
            currentRoot.right = node;
            return currentRoot;
        }
        return currentRoot;

    }

    public void add_2(E e) {
        root = add_2(root, e);
    }

    /*************************************************************************************************/

    /**
     * check if the tree which root is currentRoot contains element e
     *
     * @param currentRoot the root of the tree
     * @param e           the element to be added
     * @return if contains
     */
    private boolean contains(Node currentRoot, E e) {
        if (currentRoot == null) {
            return false;
        }
        if (e.compareTo(currentRoot.value) == 0) {
            return true;
        }
        if (e.compareTo(currentRoot.value) < 0) {
            return contains(currentRoot.left, e);
        } else {
            return contains(currentRoot.right, e);
        }
    }

    /*************************************************************************************************/

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * preOrder traversal of a tree which root is root;
     *
     * @param root the root of the tree
     */
    private void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        // 以输出代替访问。其他题目中，经常是要先存储到一个集合之类的 set.add(root.value);
        visitNode(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void visitNode(Node node) {
        // 以输出代替访问。其他题目中，经常是要先存储到一个集合之类的 set.add(root.value);
        System.out.println(node.value);
    }

    /*************************************************************************************************/
    public void inOrderTraversal() {
        inOrderTraversal(root);

    }

    /**
     * inOrder traversal of a tree which root is root;
     *
     * @param root the root of the tree
     */
    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        // 以输出代替访问。其他题目中，经常是要先存储到一个集合之类的 set.add(root.value);
        visitNode(root);
        preOrderTraversal(root.right);
    }

    /*************************************************************************************************/

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * postOrder traversal of a tree which root is root
     *
     * @param root the root of the tree
     */
    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        // 以输出代替访问。其他题目中，经常是要先存储到一个集合之类的 set.add(root.value);
        visitNode(root);
    }

    /*************************************************************************************************/

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).value;
    }

    /**
     * get the minimum node of the tree which root is currentRoot
     *
     * @param currentRoot root
     * @return the minimum node
     */
    private Node minimum(Node currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (currentRoot.left == null) {
            return currentRoot;
        } else {
            return minimum(currentRoot.left);
        }
    }

    /*************************************************************************************************/

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).value;
    }

    /**
     * get the maximum node of the tree which root is currentRoot
     *
     * @param currentRoot root
     * @return the maximum node
     */
    private Node maximum(Node currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (currentRoot.right == null) {
            return currentRoot;
        } else {
            return minimum(currentRoot.right);
        }
    }

    /*************************************************************************************************/

    public E deleteMinimum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minimum = minimum(root);
        root = deleteMinimum(root);
        return minimum.value;
    }

    /**
     * delete minimum node of the tree which root is currentRoot
     *
     * @param currentRoot root
     * @return new root of the tree after deleting
     */
    private Node deleteMinimum(Node currentRoot) {
        if (currentRoot.left == null) {
            Node rightNode = currentRoot.right;
            currentRoot.right = null;
            size--;
            return rightNode;
        }
        currentRoot.left = deleteMinimum(currentRoot.left);
        return currentRoot;

    }

    /*************************************************************************************************/

    public E deleteMaximum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node maximum = maximum(root);
        root = deleteMaximum(root);

        return maximum.value;
    }

    /**
     * delete maximum node of the tree which root is currentRoot
     *
     * @param currentRoot root
     * @return new root of the tree after deleting
     */
    private Node deleteMaximum(Node currentRoot) {
        if (currentRoot.right == null) {
            Node leftNode = currentRoot.left;
            currentRoot.left = null;
            size--;
            return leftNode;
        }
        currentRoot.right = deleteMinimum(currentRoot.right);
        return currentRoot;
    }

    /*************************************************************************************************/

    /**
     * delete the node which value is value
     *
     * @param value
     */
    private void remove(E value) {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        root = remove(root, value);
    }

    /**
     * delete the node which value is value from root which root is currentRoot
     *
     * @param currentRoot
     * @param value
     * @return the new root after deleting value
     */
    private Node remove(Node currentRoot, E value) {
        if (currentRoot == null) {
            return null;
        }
        if (value.compareTo(currentRoot.value) < 0) {
            currentRoot.left = remove(currentRoot.left, value);

        } else if (value.compareTo(currentRoot.value) > 0) {
            currentRoot.right = remove(currentRoot.right, value);
        } else { // value.compareTo(currentRoot.value) == 0
            // delete the node
            if (currentRoot.left == null) {
                Node right = currentRoot.right;
                // 这句话可以没有吧？
                currentRoot.right = null;
                size--;
                return right;
            }
            if (currentRoot.right == null) {
                Node left = currentRoot.left;
                currentRoot.left = null;
                size--;
                return left;
            }

            if (currentRoot.left != null && currentRoot.right != null) {
                Node minimum = minimum(currentRoot.right);
                Node rootAfterdeletingMin = deleteMinimum(currentRoot.right);
                minimum.right = rootAfterdeletingMin;
                minimum.left = currentRoot.left;
                currentRoot.right = currentRoot.left = null;
                // 注意次过程不需要维护size   deleteMinimum已经做size了
                return minimum;
            }

        }
        return currentRoot;
    }

    /*************************************************************************************************/

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

}

