package leetcode.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: LRUCache.java, v 0.1 2019‐12‐14 4:17 PM enyi.lr Exp $$
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }



    class DListNode {
        int       key;
        int       value;
        DListNode pre;
        DListNode next;

        public DListNode(int key, int value, DListNode pre, DListNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        public DListNode(){

        }
    }

    public void addNodeToHead(DListNode node) {
        node.pre = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    public void removeNode(DListNode node) {
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.next = null;
        node.pre = null;
    }

    public void moveToHead(DListNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    public DListNode popTail() {
        DListNode node = dummyTail.pre;
        removeNode(node);
        return node;
    }

    Map<Integer, DListNode> cache = new HashMap<Integer, DListNode>();
    private int capacity;
    private int size;
    DListNode dummyHead;
    DListNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dummyHead = new DListNode(0, 0, null, null);
        dummyTail = new DListNode(0, 0, null, null);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if (size < capacity) {
            if (node == null) {
                DListNode newNode = new DListNode(key, value, null, null);
                addNodeToHead(newNode);
                size++;
                cache.put(key, newNode);
            } else {
                node.value = value;
                moveToHead(node);
            }
        } else {
            if (node == null) {
                DListNode newNode = new DListNode(key, value, null, null);
                DListNode popNode = popTail();
                cache.remove(popNode.key);
                addNodeToHead(newNode);
                cache.put(key, newNode);
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

    }

}