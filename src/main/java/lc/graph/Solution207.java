package lc.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution207.java, v 0.1 2019‐06‐23 10:05 PM enyi.lr Exp $$
 */
public class Solution207 {
    class Graph {
        int                 count       = 0;
        List<List<Integer>> g           = null;
        boolean             isDirection = true;

        public Graph(int count) {
            this.count = count;
            this.g = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                g.add(new ArrayList<>());
            }
        }

        public void addEdge(int vertex1, int vertex2) {
            if (!hasEdge(vertex1, vertex2)) {
                g.get(vertex1).add(vertex2);
            }
        }

        public boolean hasEdge(int vertex1, int vertex2) {
            return g.get(vertex1).contains(vertex2);
        }

        public boolean hasLoop() {
            boolean[] visited = new boolean[count];
            for (int i = 0; i < count; i++) {
                boolean[] recStack = new boolean[count];
                if (isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }
            return false;
        }

        public List<Integer> getAllAdjacentNode(int vertex1) {
            return g.get(vertex1);
        }

        private boolean isCyclicUtil(int i, boolean[] visited,
                                     boolean[] recStack) {

            // Mark the current node as visited and
            // part of recursion stack
            if (recStack[i]) {
                return true;
            }

            if (visited[i]) {
                return false;
            }

            visited[i] = true;

            recStack[i] = true;
            List<Integer> children = getAllAdjacentNode(i);

            for (Integer c : children) {
                if (isCyclicUtil(c, visited, recStack)) {
                    return true;
                }
            }

            recStack[i] = false;

            return false;
        }

        /*public boolean BFSAndCheckLoop(int vertex, Set<Pair> visitedVertices, boolean[] visited) {
            boolean result = false;
            visited[vertex] = true;
            List<Integer> allAdjacentNode = getAllAdjacentNode(vertex);
            for (Integer adjacentVertex : allAdjacentNode) {
                if (!visited[adjacentVertex]) {
                    visitedVertices.add(new Pair(vertex, adjacentVertex));
                    result = result || BFSAndCheckLoop(adjacentVertex, visitedVertices, visited);
                } else {
                    // check if has cycle
                    if (hasCycle(visitedVertices, new Pair(adjacentVertex, vertex))) {
                        return true;
                    }
                }
            }
            return result;
        }

        public boolean hasCycle(Set<Pair> pairs, Pair pair) {
            for (Pair pair1 : pairs) {
                if (pair1.equals(pair)) {
                    return true;
                }
            }
            return false;
        }*/

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edges = prerequisites[i];
            graph.addEdge(edges[0], edges[1]);
        }
        return !graph.hasLoop();
    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        int count = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(solution207.canFinish(count, prerequisites));
    }
}