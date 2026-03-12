package org.graph;

import java.util.*;

/**
 * Graph Traversal Practice
 * <p>
 * Implement:
 * 1. DFS traversal
 * 2. BFS traversal
 */
public class GraphTraversalPractice {

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 4}
        };

        int source = 0;

        Map<Integer, List<Integer>> graph = buildGraph(V, edges);

        System.out.println("DFS Traversal:");
        System.out.println(dfsTraversal(graph, source));

        System.out.println("BFS Traversal:");
        System.out.println(bfsTraversal(graph, source));
    }

    /**
     * Build adjacency list representation of graph
     */
    public static Map<Integer, List<Integer>> buildGraph(int V, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }

    /**
     * Depth First Search Traversal
     */
    public static List<Integer> dfsTraversal(Map<Integer, List<Integer>> graph, int source) {

        List<Integer> sol = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfs(graph, source, seen, sol);

        return sol;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> seen, List<Integer> sol) {
        seen.add(node);
        sol.add(node);
        for (Integer neighbour : graph.get(node)) {
            if (seen.contains(neighbour)) continue;
            dfs(graph, neighbour, seen, sol);
        }
    }


    /**
     * Breadth First Search Traversal
     */
    public static List<Integer> bfsTraversal(Map<Integer, List<Integer>> graph, int source) {
        List<Integer> sol = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Deque<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(source);
        while (!nodeQueue.isEmpty()) {
            Integer poll = nodeQueue.poll();
            nodeQueue.addAll(graph.get(poll));
            if (seen.contains(poll)) continue;
            sol.add(poll);
            seen.add(poll);
        }

        return sol;
    }
}