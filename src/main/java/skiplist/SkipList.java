package skiplist;

import java.util.Random;

/**
 * Skip list explanation:  https://en.wikipedia.org/wiki/Skip_list
 * https://www.youtube.com/watch?v=ol-FaNLXlR0
 * <p>
 * 0 <= num, target <= 2 * 10000
 */
public class SkipList {
    class Node {
        Integer value;

        /**
         * An array of pointers to the next nodes at different levels
         */
        Node[] next;

        public Node(Integer value, int level) {
            this.value = value;
            this.next = new Node[level];
        }
    }

    private static final double P = 0.5;
    private final int MAX_LEVEL;
    private final Node head;
    private final Random random;

    private int level;

    public SkipList() {
        int N = 32; // Maximum number of elements given by the constraints
        this.MAX_LEVEL = (int) Math.ceil(Math.log(N) / Math.log(2)); // Calculating MAX_LEVEL based on N

        this.head = new Node(null, MAX_LEVEL);
        this.random = new Random();
        this.level = 0;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node current = this.head;
        for (int i = this.level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < num) {
                current = current.next[i];
            }
            update[i] = current;
        }

        int lvl = randomLevel();
        if (lvl > this.level) {
            // init all non-exist levels
            for (int i = this.level + 1; i <= lvl; i++) {
                update[i] = head;
            }
            this.level = lvl;
        }

        Node newNode = new Node(num, lvl + 1);
        for (int i = 0; i <= lvl; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean remove(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node current = this.head;
        for (int i = this.level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < num) {
                current = current.next[i];
            }
            update[i] = current;
        }

        current = current.next[0];
        if (current == null || current.value != num) {
            return false;
        }

        for (int i = 0; i <= this.level; i++) {
            if (update[i].next[i] != current) break;
            update[i].next[i] = current.next[i];
        }

        while (this.level > 0 && head.next[this.level] == null) {
            this.level--;
        }

        return true;
    }

    public boolean search(int target) {
        Node current = this.head;
        for (int i = this.level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < target) {
                current = current.next[i];
            }
        }
        current = current.next[0];
        return current != null && current.value == target;
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL - 1 && random.nextDouble() < P) {
            lvl++;
        }
        return lvl;
    }

    public static void main(String[] args) {
        SkipList skiplist = new SkipList();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // false
        skiplist.add(4);
        System.out.println(skiplist.search(1)); // true
        System.out.println(skiplist.remove(0)); // false
        System.out.println(skiplist.remove(1)); // true
        System.out.println(skiplist.search(1)); // false
    }
}
