package trie;

import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Trie.java, v 0.1 2019‐06‐01 7:18 PM enyi.lr Exp $$
 * pronouncing it /ˈtriː/ (as "tree"), after the middle syllable of retrieval. However, other authors pronounce it /ˈtraɪ/ (as "try")
 * Trie - Prefix tree
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * https://en.wikipedia.org/wiki/Trie#:~:text=In%20computer%20science%2C%20a%20trie,key%2C%20but%20by%20individual%20characters.
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
    private int size;

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
            size++;
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

    public boolean containsRec(String word) {
        return _containsRec(root, 0, word);
    }

    private boolean _containsRec(Node root, int fromIdx, String word) {
        if (fromIdx == word.length()) return root.isWord;
        char c = word.charAt(fromIdx);
        if (!root.next.containsKey(c)) {
            return false;
        }
        Node node = root.next.get(c);
        return _containsRec(node, fromIdx + 1, word);
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

    public boolean isPrefixRec(String prefix) {
        return isPrefixRec(root, 0, prefix);
    }

    private boolean isPrefixRec(Node root, int fromIdx, String prefix) {
        if (fromIdx == prefix.length())
            return true;
        char c = prefix.charAt(fromIdx);
        if (!root.next.containsKey(c))
            return false;
        Node node = root.next.get(c);
        return isPrefixRec(node, fromIdx + 1, prefix);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        System.out.println(trie.contains("hell"));
        System.out.println(trie.containsRec("hell"));
        System.out.println(trie.contains("hello"));
        System.out.println(trie.containsRec("hello"));
        System.out.println(trie.contains("wor"));
        System.out.println(trie.containsRec("wor"));
        System.out.println(trie.contains("world"));
        System.out.println(trie.containsRec("world"));
        System.out.println(trie.contains("m"));
        System.out.println(trie.containsRec("m"));
        System.out.println(trie.getSize());
        System.out.println(trie.isPrefix("hell"));
        System.out.println(trie.isPrefixRec("hell"));
        System.out.println(trie.isPrefix("hello"));
        System.out.println(trie.isPrefixRec("hello"));
        System.out.println(trie.isPrefix("wor"));
        System.out.println(trie.isPrefixRec("wor"));
        System.out.println(trie.isPrefix("world"));
        System.out.println(trie.isPrefixRec("world"));
        System.out.println(trie.isPrefix("m"));
        System.out.println(trie.isPrefixRec("m"));

    }

}