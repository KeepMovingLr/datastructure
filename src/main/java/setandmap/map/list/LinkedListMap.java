package setandmap.map.list;

import setandmap.map.Map;

/**
 * @author enyi.lr
 * @version $Id: LinkedListMap.java, v 0.1 2019‐10‐23 12:23 PM enyi.lr Exp $$
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    class Node {
        K    key;
        V    value;
        Node next;

        public Node() {
            key = null;
            value = null;
            next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        if (getNode(key) == null) {
            Node node = new Node(key, value);
            node.next = dummyHead.next;
            dummyHead.next = node;
            size++;
        } else {
            Node node = getNode(key);
            node.value = value;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        if (contains(key)) {
            return null;
        }
        return getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new RuntimeException();
        }
        node.value = value;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key == key) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node node = prev.next;
            prev.next = prev.next.next;
            node.next = null;
            return node.value;
        }
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * Getter method for property <tt>dummyHead</tt>.
     *
     * @return property value of dummyHead
     */
    public Node getDummyHead() {
        return dummyHead;
    }

    /**
     * Setter method for property <tt>dummyHead</tt>.
     *
     * @param dummyHead value to be assigned to property dummyHead
     */
    public void setDummyHead(Node dummyHead) {
        this.dummyHead = dummyHead;
    }

    /**
     * Setter method for property <tt>size</tt>.
     *
     * @param size value to be assigned to property size
     */
    public void setSize(int size) {
        this.size = size;
    }
}