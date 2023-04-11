package com.algos.graphs;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Cycle Detection is done differently for undirected and directed graphs because
// in undirected graphs the way , for two connected nodes both nodes are in each others adajacency
// list and they will invariably form a cycle


// The logic for cycle detection in an Undirected graph is that
// if adjacentNode is visited and its not a parent of the given node, it will mean
// the cycle is formed.
// If using dfs you have visited an adjoining node and its not a parent, it means
// there is a cycle
public class CycleDetectionInUndirectedGraph {

    // Here I plan to use DFS
    // While going into depth if we encounter same node, it means there was a cycle
    // We can keep track of nodes using a boolean [] or a set
    public static void main(String[] args) {

        // Undirected Connected Graph
        // 0 -- 1
        // |    |
        // 2 -- 3
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
        CycleDetectionInUndirectedGraph cycleDetectionInUndirectedGraph = new CycleDetectionInUndirectedGraph();
        boolean isCycle = cycleDetectionInUndirectedGraph.isCycle(V, adj);
        System.out.println(isCycle);


        // Undirected Disconnected Graph
        // 1 -- 2 -- 3

        adj = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(2).add(3);
        cycleDetectionInUndirectedGraph = new CycleDetectionInUndirectedGraph();
        isCycle = cycleDetectionInUndirectedGraph.isCycle(V, adj);
        System.out.println(isCycle);

    }

    private boolean isCyclic(Integer currentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int parent) {

        //
        visited[currentNode] = true;
        for (Integer adjNode : adjList.get(currentNode)) {
           if(!visited[adjNode]){
                return isCyclic(adjNode, adjList,visited, currentNode);
            } else if (adjNode != parent) {
               return true;
           }
        }

        return false;
    }

    // Function to return a list containing the DFS traversal of the graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // iterate over adjList
        // if node is visited , do the dfs
        // If cycle is found in dfs return else continue with other iterations
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, -1)) {
                    return true;
                }
            }
        }

        // default case
        return false;
    }
}
