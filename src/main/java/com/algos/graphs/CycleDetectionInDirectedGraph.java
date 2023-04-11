package com.algos.graphs;

import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Cycle Detection is done differently for undirected and directed graphs because
// in undirected graphs the way , for two connected nodes both nodes are in each others adajacency
// list and they will invariably form a cycle


public class CycleDetectionInDirectedGraph {


    private boolean isCyclic(Integer currentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack) {

        // the element exists in recStack , it means there is a cycle
        if (recStack[currentNode]) {
            return true;
        }

        // Why this condition should be there?
        // For a directed graph like this, when you encounter node 9/4 in second path
        // you should not go down the path which is already visited
        // because you would have already discovered it does not have cycle
        // 1 <- 2 <- 3 <- 4 -> 5 -> 6 -> 7
        //                |
        //           8 -> 9 <- 10
        if (visited[currentNode]) {
            return false;
        }

        System.out.println("currentNode " +currentNode);
        // Mark the element as visited and recurssed
        visited[currentNode] = true;
        recStack[currentNode] = true;

        System.out.println("visited " + Arrays.toString(visited));
        System.out.println("recStack " + Arrays.toString(recStack));

        for (Integer adjNode : adjList.get(currentNode)) {
            // why this condition has to commented out?
            // because cyclic adj nodes will always be visited and you will never be
            // able to discover the cycle
           // if(!visited[adjNode]){
            if (isCyclic(adjNode, adjList, visited, recStack)) {
                return true;
            }
           // }
        }

        recStack[currentNode] = false;
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        // iterate over adjList
        // if node is visited , do the dfs
        // If cycle is found in dfs return else continue with other iterations
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }

        // default case
        return false;
    }
}
