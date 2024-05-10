package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UF.java, v 0.1 2019‐06‐02 5:29 PM enyi.lr Exp $$ <br>
 * Union - Find <br>
 * Find:<br>
 * The find function finds the root node of a given vertex.<br>
 * Union:<br>
 * The union function unions two vertices and makes their root nodes the same.<br>
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}