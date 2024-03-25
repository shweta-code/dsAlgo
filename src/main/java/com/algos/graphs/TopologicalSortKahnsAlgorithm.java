package com.algos.graphs;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
// Kahns algo uses BFS
// Topological Sorting can also be used to detect cycles in Directed and Undirected Graph
public class TopologicalSortKahnsAlgorithm {

    // Visually, topological sort can be seen here
    // https://leetcode.com/problems/minimum-height-trees/solutions/827284/c-99-tc-with-explanation-using-bfs-top-sort/
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegrees = new int[V];
        for (List<Integer> adjNodes :
                adj) {
            for (int adjNode:
                 adjNodes) {
                indegrees[adjNode]++;
            }
        }
        System.out.println(Arrays.toString(indegrees));

        Queue<Integer> bfsQ = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                bfsQ.add(i);
            }
        }

        Stack<Integer> topoSorted = new Stack<>();
        while (!bfsQ.isEmpty()) {
            Integer currentNode = bfsQ.poll();
            topoSorted.add(currentNode);
            for (int adjNode :
                    adj.get(currentNode)) {
                indegrees[adjNode]--;
                if (indegrees[adjNode] == 0) {
                    bfsQ.add(adjNode);
                }
            }
        }

        // Check for cycle
        if (topoSorted.size() != V) {
            System.out.println("Graph contains cycle!");
            return new int[1];
        }

        Integer[] ans = new Integer[topoSorted.size()];
        // Revise - How to convert stack into an array?
        topoSorted.toArray(ans);

        // Revise - How to reverse an array
        // Collections.reverse(Arrays.asList(ans));
        System.out.println(Arrays.toString(ans));

        // Revise - How to convert object type [] into primitive type []
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();

    }
}
