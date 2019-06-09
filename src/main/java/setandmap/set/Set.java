package setandmap.set;

/**
 * @author enyi.lr
 * @version $Id: Set.java, v 0.1 2019‐06‐09 6:51 PM enyi.lr Exp $$
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}