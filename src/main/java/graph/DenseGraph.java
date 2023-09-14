package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: DenseGraph.java, v 0.1 2019‐06‐13 12:05 AM enyi.lr Exp $$
 * <p>
 * 稠密图
 * Dense graph use Adjacency Matrix
 *
 * space complexity O(n^2) n is the number of vertices
 * limitation:
 *      - space complexity O(n^2)
 *      - time complexity O(n) for get all adjacent edges
 */
public class DenseGraph {
    /**
     * the count of all nodes
     */
    private int v;
    /**
     * the count of all edges
     */
    private int e;
    /**
     * if it is a directed graph.
     */
    private boolean directed;

    /**
     * use adjacency matrix to save graph
     */
    private int[][] g;

    public DenseGraph(int v, boolean directed) {
        this.v = v;
        e = 0;
        this.directed = directed;
        g = new int[v][v];

    }

    /**
     * get all adjacent edges
     * time complexity O(n)
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

    // O(n)
    public int degree(int v) {
        return getAllAdjacentEdges(v).length;
    }

    public int getNodeCount() {
        return v;
    }

    public int getEdgeCount() {
        return e;
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v >= this.v) {
            return;
        }
        if (w < 0 || w >= this.v) {
            return;
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = 1;
        if (!this.directed) {
            g[w][v] = 1;
        }
        e++;
    }

    // O(1)
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= this.v) {
            throw new RuntimeException();
        }
        if (w < 0 || w >= this.v) {
            throw new RuntimeException();
        }
        return g[v][w] == 1;
    }

}