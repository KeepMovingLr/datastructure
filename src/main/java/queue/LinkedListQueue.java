package queue;

/**
 * @author enyi.lr
 * @version $Id: LinkedListQueue.java, v 0.1 2019‐05‐18 10:44 PM enyi.lr Exp $$
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E    e;
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // enqueue operation should be at the linkedList tail;
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            Node node = new Node(e);
            tail = node;
            head = node;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;

    }

    // dequeue operation should be at the linkedList head;
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            Node returnNode = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return returnNode.e;
        }

    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}