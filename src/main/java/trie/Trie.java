package trie;

import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Trie.java, v 0.1 2019‐06‐01 7:18 PM enyi.lr Exp $$
 *  pronouncing it /ˈtriː/ (as "tree"), after the middle syllable of retrieval. However, other authors pronounce it /ˈtraɪ/ (as "try")
 */
public class Trie {
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

    public Trie() {
        root = new Node();
        size = 0;
    }

    // get the amount of the word in the trie
    public int getSize() {
        return size;
    }

    /**
     * add a word into the trie
     *
     * @param word need to be added
     */
    public void add(String word) {
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

    /**
     * @param word
     * @return
     */
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

    /**
     * check if the trie contains the word which prefex is param prefix
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.next.get(prefix.charAt(i)) == null) {
                return false;
            }
            current = current.next.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        System.out.println(trie.contains("hell"));
        System.out.println(trie.contains("hello"));
        System.out.println(trie.contains("wor"));
        System.out.println(trie.contains("world"));
        System.out.println(trie.getSize());

    }

}