package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UF.java, v 0.1 2019‐06‐02 5:29 PM enyi.lr Exp $$
 * Union - Find
 * Find:
 * The find function finds the root node of a given vertex.
 * Union:
 * The union function unions two vertices and makes their root nodes the same.
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}