package org.graph;

import java.util.*;

/**
 * Problem: Detect Cycle in Graph
 * <p>
 * Given a directed graph with V vertices and a list of edges,
 * determine whether the graph contains a cycle.
 * <p>
 * Return true if a cycle exists, otherwise false.
 */
public class DetectCycleInGraphPractice {

    public static void main(String[] args) {

        int V = 4;

        int[][] edges = {
                {0, 1},
                {1, 3},
                {2, 0},
                {1, 0}
        };

        boolean result = hasCycle(V, edges);

        System.out.println(result);
    }

    public static boolean hasCycle(int V, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors = adjList.getOrDefault(edge[0], new ArrayList<>());
            neighbors.add(edge[1]);
            adjList.put(edge[0], neighbors);
        }
        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (checkCycle(i, adjList, visited, pathVisited))
                return true;
        }

        return false;
    }

    private static boolean checkCycle(int node, Map<Integer, List<Integer>> adjList, int[] visited, int[] pathVisited) {
        if (pathVisited[node] == 1) return true;
        if (visited[node] == 1) return false;
        visited[node] = 1;
        pathVisited[node] = 1;
        List<Integer> neighbors = adjList.get(node);
        if (null != neighbors) {
            for (int neighbour : neighbors) {
                //if (visited[neighbour] != 1) {
                if (checkCycle(neighbour, adjList, visited, pathVisited)) return true;
                //}
            }
        }
        pathVisited[node] = 0;
        return false;
    }
}