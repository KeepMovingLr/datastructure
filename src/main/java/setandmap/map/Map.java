package setandmap.map;

/**
 * @author enyi.lr
 * @version $Id: Map.java, v 0.1 2019‐06‐09 7:17 PM enyi.lr Exp $$
 */
public interface Map<K, V> {
    void add(K key, V value);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    V remove(K key);

    int getSize();

    boolean isEmpty();
}