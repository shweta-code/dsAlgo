package com.algos.leetcode.graph;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/description/
public class LeetCodeMinHeightTreesWrong {

    public static void main(String[] args) {

    }

    // This solution does not work for testSixEdges test case
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // edge list
        // Create adjacency list
        // find nodes with edge degree
        // fill a queue with edge degree one
        // do the bfs and keep marking their heights in the path
        // as we go along and find a node with lesser possible heights, update heights
        // of that node and keep updating in consequent nodes

        // edge case - disconnected tree

        List<List<Integer>> adjList = new ArrayList<>();

        createAdjList(n, edges, adjList);

        // Revise - How to print a list?
        System.out.println(Arrays.toString(adjList.toArray()));

        int[] edgeDegree = new int[n];
        int[] heights = new int[n];
        for (int[] edge:
             edges) {
            edgeDegree[edge[0]]++;
            edgeDegree[edge[1]]++;
        }

        System.out.println("edgeDegree");
        System.out.println(Arrays.toString(edgeDegree));

        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < edgeDegree.length; i++) {
            if (edgeDegree[i] == 1) {
                bfsQ.add(i);
                heights[i] = 1;
                break;
            }
        }

        int maxHeight = Integer.MIN_VALUE;
        while (!bfsQ.isEmpty()) {
            Integer vertex = bfsQ.poll();
            visited[vertex] = true;
            System.out.println("Out from queue");
            int heightParentVertex = heights[vertex];
            maxHeight = Math.max(maxHeight, heightParentVertex);
            List<Integer> adjNodes = adjList.get(vertex);
            for (Integer adjNode:
                 adjNodes) {
                if (!visited[adjNode]) {
                    heights[adjNode] = heightParentVertex+1;
                    bfsQ.add(adjNode);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        System.out.println("maxHeight");
        System.out.println(maxHeight);

        // if even
        for (int i = 0; i < n; i++) {
            if ( heights[i] == ((maxHeight / 2) + 1)) {
                ans.add(i);
            } else if (maxHeight % 2 == 0 && heights[i] == maxHeight / 2) {
                ans.add(i);
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
