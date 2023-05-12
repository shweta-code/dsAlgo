package com.algos.leetcode.graph;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/description/
public class LeetCodeMinHeightTrees {

    // Solutions
    // https://leetcode.com/problems/minimum-height-trees/solutions/827284/c-99-tc-with-explanation-using-bfs-top-sort/
    public static void main(String[] args) {


    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // edge list
        // Create adjacency list
        // find nodes with edge degree
        // fill a queue with edge degree one

        // THis is also a nice theory - https://leetcode.com/problems/minimum-height-trees/solutions/76052/two-o-n-solutions/

        ArrayList<Integer> ans = new ArrayList<>();

        //edge Case
        if (edges.length == 0) {
            ans.add(0);
            return ans;
        }


        List<List<Integer>> adjList = new ArrayList<>();

        createAdjList(n, edges, adjList);

        // Revise - How to print a list?
        System.out.println(Arrays.toString(adjList.toArray()));

        int[] edgeDegree = new int[n];
//        int[] heights = new int[n];
        for (int[] edge:
                edges) {
            edgeDegree[edge[0]]++;
            edgeDegree[edge[1]]++;
        }

        System.out.println("edgeDegree");
        System.out.println(Arrays.toString(edgeDegree));

        Queue<Integer> bfsQ = new LinkedList<>();
        //boolean[] visited = new boolean[n];
        for (int i = 0; i < edgeDegree.length; i++) {
            // Keep adding all leaf nodes
            if (edgeDegree[i] == 1) {
                bfsQ.add(i);
                /*heights[i] = 1;
                break;*/
            }
        }

        // This condition will not work as it is not dependent on total no of nodes(n)
        // but it is dependent on nodes in the longest path
        //
        // while ((n%2 == 0 && bfsQ.size() > 2) || (n%2 == 1 && bfsQ.size() > 1)) {
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();

            // Revise - How to clear a list
            ans.clear();
            for (int i = 0; i < size && bfsQ.size() > 0; i++) {
                int currentNode = bfsQ.poll();
                edgeDegree[currentNode]--;
                ans.add(currentNode);
                for (int adjNode :
                        adjList.get(currentNode)) {
                    edgeDegree[adjNode]--;
                    if (edgeDegree[adjNode] == 1) {
                        bfsQ.add(adjNode);
                    }
                }
            }
        }

        return ans;

    }

    private static void createAdjList(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int[] edge :
                edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
}
