package leetcode.trie;

import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution208.java, v 0.1 2019‐06‐01 7:57 PM enyi.lr Exp $$
 */
public class Solution208 {
    class Trie {
        private class Node {
            public boolean isWord;

            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }
        private Node root;
        private int  size;


        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
            size = 0;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                if (current.next.get(word.charAt(i)) == null) {
                    Node newNode = new Node(false);
                    current.next.put(word.charAt(i), newNode);
                }
                current = current.next.get(word.charAt(i));
            }
            if (current.isWord == false) {
                current.isWord = true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                if (current.next.get(word.charAt(i)) == null) {
                    return false;
                }
                current = current.next.get(word.charAt(i));

            }
            return current.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node current = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (current.next.get(prefix.charAt(i)) == null) {
                    return false;
                }
                current = current.next.get(prefix.charAt(i));
            }
            return true;
        }
    }
}