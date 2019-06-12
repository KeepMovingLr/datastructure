package graph;

/**
 * @author enyi.lr
 * @version $Id: DenseGraph.java, v 0.1 2019‐06‐13 12:05 AM enyi.lr Exp $$
 * <p>
 * Dense graph use Adjacency Matrix
 */
public class DenseGraph {
    // the count of the node
    private int     n;
    // the count of the edge
    private int     m;
    // if it is a directed graph
    private boolean directed;
    private int[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        m = 0;
        this.directed = directed;
        g = new int[n][n];

    }

    public int getNodeCount() {
        return n;
    }

    public int getEdgeCount() {
        return m;
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v >= n) {
            return;
        }
        if (w < 0 || w >= n) {
            return;
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = 1;
        if (!this.directed) {
            g[w][v] = 1;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n) {
            throw new RuntimeException();
        }
        if (w < 0 || w >= n) {
            throw new RuntimeException();
        }
        return g[v][w] == 1;
    }

}