package leetcode.trie;

import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution208.java, v 0.1 2019‐06‐01 7:57 PM enyi.lr Exp $$
 */
public class Solution211 {

    class WordDictionary {
        private class Node {

            public boolean                  isWord;
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

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) { cur.next.put(c, new Node()); }
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            //return match(root, word, 0);
            return match2(root, word);

        }

        private boolean match2(Node root, String word) {
            if ("".equals(word)) {
                return root.isWord;
            }
            char c = word.charAt(0);
            if (c != '.') {
                if (root.next.get(c) == null) {
                    return false;
                }
                word = word.substring(1);
                return match2(root.next.get(c), word);
            } else {
                word = word.substring(1);
                for (Character character : root.next.keySet()) {
                    if (match2(root.next.get(character), word)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private boolean match(Node root, String word, int index) {
            if (index == word.length()) {
                return root.isWord;
            }
            char c = word.charAt(index);
            if (c != '.') {
                if (root.next.get(c) == null) {
                    return false;
                }
                return match(root.next.get(c), word, index + 1);
            } else {
                for (char nextChar : root.next.keySet()) {
                    if (match(root.next.get(nextChar), word, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

    }

}