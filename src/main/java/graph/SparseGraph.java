package graph;

import array.Array;

import java.util.*;

/**
 * @author enyi.lr
 * @version $Id: SparseGraph.java, v 0.1 2019‐06‐13 12:19 AM enyi.lr Exp $$ 稀疏图：Adjacency list
 * space complexity O(V+E)
 */
public class SparseGraph {

    /**
     * the count of the node
     */
    private int v;
    /**
     * the count of the edge
     */
    private int e;
    /**
     * if it is a directed graph
     */
    private boolean directed;

    // can use ArrayList<Set<Integer>> g to improve performance
    ArrayList<Set<Integer>> graph;
    ArrayList<ArrayList<Integer>> g;

    public SparseGraph(int v, boolean directed) {
        this.v = v;
        this.directed = directed;
        this.e = 0;
        g = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            g.add(list);
        }
    }

    // Kahn's Algorithm https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3886/

    // add an edge between vertex v and vertex w
    public void addEdge(int v, int w) {
        if (v < 0 || v >= this.v) {
            return;
        }
        if (w < 0 || w >= this.v) {
            return;
        }
        // 允许平行边 因为每次判断平行边的效率是O(n),成本有点高
        /*if (hasEdge(v, w)) {
            return;
        }*/
        g.get(v).add(w);
        if (v != w && !directed) {
            g.get(w).add(v);
        }
        e++;

    }

    // remove an edge between vertex v and vertex w
    public void removeEdge(int v, int w) {
        if (v < 0 || v >= this.v) {
            return;
        }
        if (w < 0 || w >= this.v) {
            return;
        }
        int index = -1;
        ArrayList<Integer> arrayList = g.get(v);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == w) {
                index = i;
            }
        }
        if (index != -1) {
            g.get(v).remove(index);
        }
        if (v != w && !directed) {
            int index2 = -1;
            ArrayList<Integer> arrayList2 = g.get(w);
            for (int i = 0; i < arrayList2.size(); i++) {
                if (arrayList2.get(i) == v) {
                    index2 = i;
                }
            }
            if (index2 != -1) {
                g.get(w).remove(index2);
            }
        }
        e--;
    }

    // check if there is an edge between vertex v and vertex w
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= this.v) {
            throw new RuntimeException();
        }
        if (w < 0 || w >= this.v) {
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
    public List<Integer> getAllAdjacentVertex(int index) {
        return g.get(index);
    }

    public int getDegree(int index) {
        return g.get(index).size();
    }

    public int getNodeCount() {
        return v;
    }

    public int getEdgeCount() {
        return e;
    }

    /**********DFS***********************************************************************************************************/

    public void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[this.v];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        // visit vertex. Can be set to other operation.
        System.out.println("vertex:" + v);
        List<Integer> allAdjacentVertex = getAllAdjacentVertex(v);
        for (Integer adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex]) {
                DFSUtil(adjacentVertex, visited);
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
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    public List<List<Integer>> getAllConnectedComponent() {
        LinkedList<List<Integer>> result = new LinkedList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
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
        List<Integer> allAdjacentVertex = getAllAdjacentVertex(v);
        for (Integer adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex]) {
                result.addAll(DFSVisitedVertices(adjacentVertex, visited));
            }
        }
        return result;
    }

    /**********detect loop*****important and hard to
     * understand******************************************************************************************************/

    public boolean isCyclic() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, i))
                    return true;
            }
        }
        return false;
    }

    public boolean hasCycle(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        List<Integer> allAdjacentVertex = getAllAdjacentVertex(vertex);
        for (Integer adj : allAdjacentVertex) {
            if (!visited[adj]) {
                if (hasCycle(adj, visited, vertex)) {
                    return true;
                }
            } else if (adj != parent) {
                return true;
            }
        }
        return false;
    }

    /**
     * todo has a bug
     * It is a backtracking method
     *
     * @param vertex
     * @param visited
     * @param previous from vertex to current node has been visited
     * @return
     */
    public boolean hasLoop(int vertex, boolean[] visited, Set<Integer> previous, int parent) {
        if (previous.contains(vertex)) {
            return true;
        }
        if (visited[vertex]) { // can use an illustrate to understand this. As when we loop the children, we don't check if visited, so it has this statement
            return false;
        }
        visited[vertex] = true;
        previous.add(vertex);
        // check if all the children have a cycle
        List<Integer> allAdjacentVertex = getAllAdjacentVertex(vertex);
        for (Integer adjacentVertex : allAdjacentVertex) {
            if (adjacentVertex == parent)
                continue;
            if (hasLoop(adjacentVertex, visited, previous, vertex)) {
                return true;
            }
        }
        // if all the children has no cycle, then remove it
        previous.remove(vertex);
        return false;
    }

    /**
     * todo Has a bug????
     * another way to detect loop, similar to dfs
     * also a backtracking method
     *
     * @param vertex
     * @param visited
     * @param previous
     * @return
     */
    public boolean hasLoop2(int vertex, boolean[] visited, Set<Integer> previous) {
        visited[vertex] = true;
        previous.add(vertex);
        List<Integer> adjacent = getAllAdjacentVertex(vertex);
        for (Integer a : adjacent) {
            if (previous.contains(a)) {
                return true;
            }
            if (!visited[a]) {
                if (hasLoop2(a, visited, previous)) {
                    return true;
                }
            }
        }
        previous.remove(vertex);
        return false;
    }

    /**********BFS***********************************************************************************************************/
    public void BFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[this.v];
        boolean[] entrancedQueue = new boolean[this.v];
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
            List<Integer> allAdjacentVertex = getAllAdjacentVertex(vertex);
            for (Integer adjacentVertex : allAdjacentVertex) {
                if (!entrancedQueue[adjacentVertex]) {
                    queue.add(adjacentVertex);
                    entrancedQueue[adjacentVertex] = true;
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
        boolean[] visited = new boolean[v];
        boolean[] entrancedQueue = new boolean[v];
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
            List<Integer> allAdjacentVertex = getAllAdjacentVertex(vertex);
            for (Integer adjacentVertex : allAdjacentVertex) {
                if (!entrancedQueue[adjacentVertex]) {
                    fromMap.put(adjacentVertex, vertex);
                    queue.add(adjacentVertex);
                    entrancedQueue[adjacentVertex] = true;
                }
            }
        }
    }

    /**********PATH***********************************************************************************************************/

    public boolean hasPath(int vertex1, int vertex2) {
        boolean[] visited = new boolean[v];
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
        boolean[] visited = new boolean[v];
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
        List<Integer> allAdjacentVertex = getAllAdjacentVertex(v);
        for (Integer adjacentVertex : allAdjacentVertex) {
            if (!visited[adjacentVertex]) {
                fromVertex.put(adjacentVertex, v);
                DFSAndSaveFromVertex(adjacentVertex, visited, fromVertex);
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

    /************************************************************************************************************************/

    public static void main(String[] args) {
        SparseGraph sparseGraph = new SparseGraph(7, false);
        sparseGraph.addEdge(0, 1);
        sparseGraph.addEdge(0, 2);
        sparseGraph.addEdge(0, 5);
        sparseGraph.addEdge(0, 6);
        sparseGraph.addEdge(4, 6);
        sparseGraph.addEdge(4, 5);
        sparseGraph.addEdge(4, 3);
        sparseGraph.addEdge(5, 3);
        System.out.println("has cycle - " + sparseGraph.isCyclic());
        /*
        sparseGraph.DFS(0);
        System.out.println("connected:" + sparseGraph.getConnectedComponentCount());
        LinkedList<Integer> onePath = sparseGraph.getOnePath(0, 3);
        System.out.println("onePath" + onePath);
        System.out.println(sparseGraph.showPath(0, 3));
        */
        List<List<Integer>> allConnectedComponent = sparseGraph.getAllConnectedComponent();
        for (List<Integer> list : allConnectedComponent) {
            System.out.println("connected component:" + list);
        }
        sparseGraph.BFS(0);
        LinkedList<Integer> nearestPath = sparseGraph.getNearestPath(0, 3);
        System.out.println("nearest:" + sparseGraph.showNearestPath(0, 3));
    }
}