package linkedlist;

/**
 * @author enyi.lr
 * @version $Id: LinkedList.java, v 0.1 2019‐05‐18 7:46 PM enyi.lr Exp $$
 * 总结：对于LinkedList的增删改查操作，增删需要记录前一个节点的引用，改查需要记录当前节点的引用。
 * Review time： 2023-08-12
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }

    // dummy head
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public void addToIndex(int index, E e) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;   // 3 -> 1 prev.next = new Node(e,prev.next);
        size++;
    }

    public void addLast(E e) {
        addToIndex(size, e);
    }

    public void addFirst(E e) {
        addToIndex(0, e);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        // bug fix
        while (current != null) {
            if (e.equals(current.e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeByIndex(int index) {
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node needDelete = previous.next;
        previous.next = needDelete.next;
        needDelete.next = null;
        size--;
        return needDelete.e;
    }

    public E removeFirst() {
        return removeByIndex(0);
    }

    public E removeLast() {
        return removeByIndex(size - 1);
    }

    // important, need to fully understand it
    public void reverseList() {
        Node pre = null;
        Node cur = dummyHead.next;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        dummyHead.next = pre;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + "->");
            current = current.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.reverseList();
        System.out.println(linkedList);
    }

}