package lc.graph;

import graph.SparseGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_1192_CriticalConnectionsinaNetwork.java, v 0.1 2019‐12‐14 6:05 PM enyi.lr Exp $$
 */
public class S_1192_CriticalConnectionsinaNetwork {

    // Time Limit Exceeded
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        SparseGraph graph = new SparseGraph(n, false);
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> list = connections.get(i);
            graph.addEdge(list.get(0), list.get(1));
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> list = connections.get(i);
            graph.removeEdge(list.get(0), list.get(1));
            if (graph.getConnectedComponentCount() > 1) {
                result.add(list);
            }
            graph.addEdge(list.get(0), list.get(1));
        }
        return result;
    }

    public static void main(String[] args) {
        S_1192_CriticalConnectionsinaNetwork criticalConnectionsinaNetwork = new S_1192_CriticalConnectionsinaNetwork();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(0);
        one.add(1);
        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(2);
        List<Integer> three = new ArrayList<>();
        three.add(2);
        three.add(0);
        List<Integer> four = new ArrayList<>();
        four.add(1);
        four.add(3);
        connections.add(one);
        connections.add(two);
        connections.add(three);
        connections.add(four);
        List<List<Integer>> result = criticalConnectionsinaNetwork.criticalConnections(4, connections);
        System.out.println(result);

    }
}