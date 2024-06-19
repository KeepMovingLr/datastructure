package unionFind;

/**
 * @author enyi.lr
 * @version $Id: UF.java, v 0.1 2019‐06‐02 5:29 PM enyi.lr Exp $$ <br>
 * Union-Find aka Disjoint Set Union(DSU) <br>
 * <br>
 * Find:<br>
 * The find function finds the root node of a given vertex.<br>
 * Path compression is used to make the trees flatter by making nodes point directly to the root during the find operation. This helps in speeding up future operations.<br>
 * <br>
 * Union:<br>
 * The union function unions two vertices and makes their root nodes the same.<br>
 * Union by rank (or size) is used to attach the smaller tree under the root of the larger tree, which helps in keeping the tree balanced.<br>
 * <br>
 * <br>
 * Union-Find is particularly useful in applications involving equivalence relations, <br>
 * such as finding connected components in a graph,<br>
 * network connectivity, <br>
 * and in Kruskal's algorithm for finding the Minimum Spanning Tree (MST) of a graph.<br>
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}