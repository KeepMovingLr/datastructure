package LinkedList2;

/**
 * @author enyi.lr
 * @date 9/11/22 5:10 pm
 * @description implement a linkedlist by myself
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public LinkedList.Node next;

        public Node(E e, LinkedList.Node next) {
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
            return "Node{" + "e=" + e + '}';
        }
    }

    private Node dummyHead;
    private int size;

    public void addToIndex(int index, E e) {
        if (index > size || index < 0) {
            return;
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node newNode = new Node(e, pre.next);
        pre.next = newNode;
        size++;
    }

    public void addFirst(E e) {
        addToIndex(0, e);
    }

    public void addLast(E e) {
        addToIndex(size, e);
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index >= size || index < 0) {
            throw new RuntimeException("");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E removeByIndex(int index) {
        Node pre = dummyHead;
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    public E removeFirst() {
        return removeByIndex(0);
    }

    public E removeLast() {
        return removeByIndex(size - 1);
    }


}
