package graph;

public class WeightedDenseGraph {

    class Edge {
        // vertex
        int a;
        int b;
        // weight
        int weight;

        public Edge() {
        }

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    /**
     * the count of all nodes
     */
    private int n;
    /**
     * the count of all edges
     */
    private int m;
    /**
     * if it is a directed graph.
     */
    private boolean directed;

    /**
     * use adjacency matrix to save graph
     */
    private Edge[][] g;

    public WeightedDenseGraph(int n, boolean directed) {
        this.n = n;
        m = 0;
        this.directed = directed;
        g = new Edge[n][n];

    }

    public void addEdge(int v, int w, int weight) {
        if (hasEdge(v, w))
            return;

        g[v][w] = new Edge(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge(w, v, weight);
        }
    }

    public boolean hasEdge(int v, int w) {
        return g[v][w] != null;
    }
}
