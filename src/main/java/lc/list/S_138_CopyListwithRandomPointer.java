package lc.list;

import java.util.HashMap;

/**
 * @author enyi.lr
 * @version $Id: S_138_CopyListwithRandomPointer.java, v 0.1 2019‐12‐14 8:56 PM enyi.lr Exp $$
 */
public class S_138_CopyListwithRandomPointer {
    class Node {
        public int  val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val, null, null);
        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

}