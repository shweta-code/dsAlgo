package com.algos.graphs;

import java.util.*;


// DFS using Recurssion
// https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// This algorithm refer to both directed / undirected connected and disconnected graphs
public class DFS {

    // Undirected Connected Graph
    // 1 -- 2
    // |    |
    // 3 -- 4
    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);
        dfsOfGraph(V, adj);
    }

    private static void dfs(Integer currentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> graphTraversal) {

        // print current node
        // mark currentNode as visited
        //iterate over adjNodes
        // call dfs if node is unvisited


        graphTraversal.add(currentNode);
        visited[currentNode] = true;
        for (Integer adjNode : adjList.get(currentNode)) {
            if(!visited[adjNode]){
                dfs(adjNode, adjList,visited, graphTraversal);
            }
        }



    }

    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> graphTraversal = new ArrayList<>();
        // iterate over adjList
        // call dfs
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(visited));
            if (!visited[i]) {
                dfs(i, adj, visited, graphTraversal);
            }
        }
        return graphTraversal;
    }

    // Undirected Disconnected Graph
}
