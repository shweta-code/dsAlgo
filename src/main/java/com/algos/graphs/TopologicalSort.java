package com.algos.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
// https://www.geeksforgeeks.org/topological-sorting/

// For topological Sort, dfs cannot be used as is
// DFS needs to be tweaked for topological Sort algorithm
public class TopologicalSort {

    // Undirected Graph
    // 0 --> 1
    // ^     ^
    // |     |
    // 2 --> 3
    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int[] topoSort = topoSort(V, adj);
        System.out.println(Arrays.toString(topoSort));
    }

    private static void dfs(Integer currentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {

        // print current node
        // mark currentNode as visited
        //iterate over adjNodes
        // call dfs if node is unvisited
        visited[currentNode] = true;
        for (Integer adjNode : adjList.get(currentNode)) {
            if(!visited[adjNode]){
                dfs(adjNode, adjList,visited, stack);
            }
        }

        stack.add(currentNode);
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        // Revise - How to initialize stack in java
        Stack<Integer> topologicallySorted = new Stack<>();
        // iterate over adjList
        // call dfs
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, topologicallySorted);
            }
        }


        Integer[] ans = new Integer[topologicallySorted.size()];
        // Revise - How to convert stack into an array?
        topologicallySorted.toArray(ans);

        // Revise - How to reverse an array
        Collections.reverse(Arrays.asList(ans));

        // Revise - How to convert object type [] into primitive type []
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();

        // Revise - An alternate way of doing this is using  LinkedList
       /* LinkedList<String> list = new LinkedList<>();
        list.push("foo");
        list.push("bar");
        String[] arr = list.toArray(new String[0]);
        Assert.assertArrayEquals(new String[] { "bar", "foo" }, arr);*/


    }
}
