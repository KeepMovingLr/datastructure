package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: DenseGraph.java, v 0.1 2019‐06‐13 12:05 AM enyi.lr Exp $$
 * <p>
 * 稠密图
 * Dense graph use Adjacency Matrix
 */
public class DenseGraph {
    /**
     * the count of the node
     */
    private int     n;
    /**
     * the count of the edge
     */
    private int     m;
    /**
     * if it is a directed graph
     */
    private boolean directed;

    /**
     * use adjacency matrix to save graph
     */
    private int[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        m = 0;
        this.directed = directed;
        g = new int[n][n];

    }

    /**
     * get all adjacent edges
     *
     * @param index
     * @return
     */
    public int[] getAllAdjacentEdges(int index) {
        List<Integer> list = new ArrayList<>();
        int[] edges = g[index];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 1) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
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