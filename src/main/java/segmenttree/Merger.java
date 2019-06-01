package segmenttree;

/**
 * @author enyi.lr
 * @version $Id: Merger.java, v 0.1 2019‐06‐01 1:51 PM enyi.lr Exp $$
 */
public interface Merger<E> {
    E merge(E a, E b);
}