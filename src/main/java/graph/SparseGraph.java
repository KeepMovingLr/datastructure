package graph;

import java.util.ArrayList;

/**
 * @author enyi.lr
 * @version $Id: SparseGraph.java, v 0.1 2019‐06‐13 12:19 AM enyi.lr Exp $$
 */
public class SparseGraph {

    // the count of the node
    private int     n;
    // the count of the edge
    private int     m;
    // if it is a directed graph
    private boolean directed;

    ArrayList<ArrayList<Integer>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.m = 0;
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            g.add(list);
        }
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
        // 允许平行边 因为每次判断平行边的效率是O(n)
        /*if (hasEdge(v, w)) {
            return;
        }*/
        g.get(v).add(w);
        if (v != w && !directed) {
            g.get(w).add(v);
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
        return g.get(v).contains(w);
    }
}