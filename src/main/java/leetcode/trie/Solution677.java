package leetcode.trie;

import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution208.java, v 0.1 2019‐06‐01 7:57 PM enyi.lr Exp $$
 */
public class Solution677 {

    static class MapSum {
        private class Node {

            public  boolean                  isWord;
            public  TreeMap<Character, Node> next;
            private int                      count;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();

            }

            public Node(int count) {
                this(false);
                this.count = count;
            }

            public Node() {
                this(false);
                count = 0;
            }

        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node current = root;
            if (contains(key)) {
                for (int i = 0; i < key.length(); i++) {
                    char c = key.charAt(i);
                    Node node = current.next.get(c);
                    node.count = val;
                    current = current.next.get(c);
                }
                return;
            }

            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (current.next.get(c) == null) {
                    Node node = new Node(val);
                    current.next.put(c, node);
                    current = current.next.get(c);
                } else {
                    Node node = current.next.get(c);
                    node.count = node.count + val;
                    current.next.put(c, node);
                    current = current.next.get(c);
                }
            }
            current.isWord = true;
        }

        public boolean contains(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                if (current.next.get(word.charAt(i)) == null) {
                    return false;
                }
                current = current.next.get(word.charAt(i));

            }
            return current.isWord;

        }

        public int sum(String prefix) {
            int min = Integer.MAX_VALUE;
            Node current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (current.next.get(c) == null) {
                    return 0;
                } else {
                    int count = current.next.get(c).count;
                    if (count < min) {
                        min = count;
                    }
                }
                current = current.next.get(c);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        int ap = mapSum.sum("aa");
        System.out.println(ap);
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("aa"));

    }

}