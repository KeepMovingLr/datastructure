package leetcode.unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution547_4.java, v 0.1 2019‐06‐26 11:42 PM enyi.lr Exp $$
 */
public class Solution547_4 {
    class Graph {
        int[][] g;
        int     vertexCount = 0;
        int     edgesCount  = 0;

        public Graph(int[][] g) {
            this.g = g;
            vertexCount = g.length;
        }

        public List<Integer> getAllAdjacentVertices(int i) {
            int[] vertiecs = g[i];
            List<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 < vertiecs.length; i1++) {
                if (vertiecs[i1] == 1) {
                    list.add(i1);
                }
            }
            return list;
        }

        public void depthTraversal(int i, boolean[] visited) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> allAdjacentVertices = getAllAdjacentVertices(i);
                for (Integer allAdjacentVertex : allAdjacentVertices) {
                    depthTraversal(allAdjacentVertex, visited);
                }
            }
        }

        public int getConnectedComponents() {
            int connectedComponent = 0;
            boolean[] visited = new boolean[vertexCount];
            for (int i = 0; i < vertexCount; i++) {
                if (!visited[i]) {
                    connectedComponent++;
                    depthTraversal(i, visited);
                }
            }
            return connectedComponent;
        }

    }

    public int findCircleNum(int[][] M) {
        Graph graph = new Graph(M);
        return graph.getConnectedComponents();
    }

}