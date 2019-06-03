package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UF.java, v 0.1 2019‐06‐02 5:29 PM enyi.lr Exp $$
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}