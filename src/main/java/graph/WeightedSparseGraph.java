package graph;

import java.util.*;

/**
 * @author enyi.lr
 * @version $Id: SparseGraph.java, v 0.1 2019‐06‐13 12:19 AM enyi.lr Exp $$ 稀疏图：Adjacency list
 */
public class WeightedSparseGraph {

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

    ArrayList<ArrayList<WeightedDenseGraph.Edge>> g;

    public WeightedSparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.m = 0;
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<WeightedDenseGraph.Edge> list = new ArrayList<>();
            g.add(list);
        }
    }

    // Kahn's Algorithm https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3886/


    public void addEdge(int v, int w , int weight) {
        if (v < 0 || v >= n) {
            return;
        }
        if (w < 0 || w >= n) {
            return;
        }
        // 允许平行边 因为每次判断平行边的效率是O(n),成本有点高
        /*if (hasEdge(v, w)) {
            return;
        }*/
        WeightedDenseGraph.Edge edge = new WeightedDenseGraph.Edge(v, w, weight);
        g.get(v).add(edge);
        if (v != w && !directed) {
            g.get(w).add(new WeightedDenseGraph.Edge(w, v, weight));
        }
        m++;

    }

    public void removeEdge(int v, int w) {
        if (v < 0 || v >= n) {
            return;
        }
        if (w < 0 || w >= n) {
            return;
        }
        int index = -1;
        ArrayList<WeightedDenseGraph.Edge> arrayList = g.get(v);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).b == w){
                index = i;
            }
        }
        if (index != -1) {
            g.get(v).remove(index);
        }
        if (v != w && !directed) {
            int index2 = -1;
            ArrayList<WeightedDenseGraph.Edge> arrayList2 = g.get(w);
            for (int i = 0; i < arrayList2.size(); i++) {
                if (arrayList2.get(i).b == v){
                    index2 = i;
                }
            }
            if (index2 != -1){
                g.get(w).remove(index2);
            }
        }
        m--;
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

    /**
     * get all adjacent edges
     *
     * @param index
     * @return
     */
    public List<WeightedDenseGraph.Edge> getAllAdjacentVertex(int index) {
        return g.get(index);
    }

    public int getNodeCount() {
        return n;
    }

    public int getEdgeCount() {
        return m;
    }

    /**********DFS***********************************************************************************************************/

    public void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[n];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        // visit vertex. Can be set to other operation.
        System.out.println("vertex:" + v);
        List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(v);
        for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex.b]) {
                DFSUtil(adjacentVertex.b, visited);
            }
        }

    }

    /**
     * get the count of connected component
     *
     * @return
     */
    public int getConnectedComponentCount() {
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    public List<List<Integer>> getAllConnectedComponent() {
        LinkedList<List<Integer>> result = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                LinkedList<Integer> re = DFSVisitedVertices(i, visited);
                result.add(re);
            }
        }
        return result;
    }

    private LinkedList<Integer> DFSVisitedVertices(int v, boolean[] visited) {
        LinkedList<Integer> result = new LinkedList<>();
        visited[v] = true;
        result.add(v);
        List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(v);
        for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex.b]) {
                result.addAll(DFSVisitedVertices(adjacentVertex.b, visited));
            }
        }
        return result;
    }

    /**********detect loop*****important and hard to
     * understand******************************************************************************************************/

    /**
     * @param vertex
     * @param visited
     * @param previous from vertex to current node has been visited
     * @return
     */
    public boolean hasLoop(int vertex, boolean[] visited, Set<Integer> previous) {
        if (previous.contains(vertex)) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        previous.add(vertex);
        // check if all of the children has cycle
        List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(vertex);
        for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
            if (hasLoop(adjacentVertex.b, visited, previous)) {
                return true;
            }
        }
        // if all the children has no cycle, then remove it
        previous.remove(vertex);
        return false;
    }

    /**********BFS***********************************************************************************************************/
    public void BFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[n];
        boolean[] entrancedQueue = new boolean[n];
        BFSUtil(v, visited, entrancedQueue);
    }

    private void BFSUtil(int v, boolean[] visited, boolean[] entrancedQueue) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(v);
        entrancedQueue[v] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.pop();
            visited[vertex] = true;
            // can do other operation such as save to a list
            System.out.println("BFS visit vertex:" + vertex);
            List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(vertex);
            for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
                if (!entrancedQueue[adjacentVertex.b]) {
                    queue.add(adjacentVertex.b);
                    entrancedQueue[adjacentVertex.b] = true;
                }
            }
        }
    }

    public String showNearestPath(int vertex1, int vertex2) {
        LinkedList<Integer> nearestPath = getNearestPath(vertex1, vertex2);
        if (nearestPath.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : nearestPath) {
            stack.add(integer);
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop() + "-");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public LinkedList<Integer> getNearestPath(int vertex1, int vertex2) {
        boolean[] visited = new boolean[n];
        boolean[] entrancedQueue = new boolean[n];
        Map<Integer, Integer> fromMap = new HashMap<>();
        BFSAndSaveFromVertex(vertex1, visited, entrancedQueue, fromMap);
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (visited[vertex2]) {
            Integer end = vertex2;
            linkedList.add(end);
            while (fromMap.get(end) != null && fromMap.get(end) != vertex1) {
                end = fromMap.get(end);
                linkedList.add(end);
            }
            linkedList.add(vertex1);
        }
        return linkedList;
    }

    private void BFSAndSaveFromVertex(int v, boolean[] visited, boolean[] entrancedQueue, Map<Integer, Integer> fromMap) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(v);
        entrancedQueue[v] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.pop();
            visited[vertex] = true;
            List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(vertex);
            for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
                if (!entrancedQueue[adjacentVertex.b]) {
                    fromMap.put(adjacentVertex.b, vertex);
                    queue.add(adjacentVertex.b);
                    entrancedQueue[adjacentVertex.b] = true;
                }
            }
        }
    }

    /**********PATH***********************************************************************************************************/

    public boolean hasPath(int vertex1, int vertex2) {
        boolean[] visited = new boolean[n];
        DFSUtil(vertex1, visited);
        return visited[vertex2];
    }

    /**
     * get one path between vertex1 and vertex2
     *
     * @param vertex1
     * @param vertex2
     */
    public LinkedList<Integer> getOnePath(int vertex1, int vertex2) {
        Map<Integer, Integer> fromVertex = new HashMap<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        boolean[] visited = new boolean[n];
        if (hasPath(vertex1, vertex2)) {
            DFSAndSaveFromVertex(vertex1, visited, fromVertex);
        }
        int end = vertex2;
        linkedList.add(end);
        while (fromVertex.get(end) != null && fromVertex.get(end) != vertex1) {
            end = fromVertex.get(end);
            linkedList.add(end);
        }
        linkedList.add(vertex1);
        return linkedList;
    }

    private void DFSAndSaveFromVertex(int v, boolean[] visited, Map<Integer, Integer> fromVertex) {
        visited[v] = true;
        List<WeightedDenseGraph.Edge> allAdjacentVertex = getAllAdjacentVertex(v);
        for (WeightedDenseGraph.Edge adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex.b]) {
                fromVertex.put(adjacentVertex.b, v);
                DFSAndSaveFromVertex(adjacentVertex.b, visited, fromVertex);
            }
        }

    }

    public String showPath(int vertex1, int vertex2) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> onePath = getOnePath(vertex1, vertex2);
        for (Integer integer : onePath) {
            stack.push(integer);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop() + "-");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }


}