package com.algos.graphs.shortestPath;

import java.util.Arrays;

public class DjikstrasAlgorithm {
    public final int V;

    public DjikstrasAlgorithm(int v) {
        V = v;
    }

    // See the graph visually  here - https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    public static void main(String[] args) {
        int[][] graph
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DjikstrasAlgorithm d = new DjikstrasAlgorithm(graph.length);
        System.out.println(Arrays.toString(d.djikstra(graph, 0)));
    }

    public int[] djikstra(int[][] graph, int src){
        //the output array , shortest distance of each node from src
        int[] dist = new int[V];

        // spSet if vertext[i] is included in shortest path tree
        Boolean[] spSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            spSet[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        for (int i = 0; i < V - 1; i++)
        {
            // node that is at minimum distance from src
            int u = getNodeAtMinDistanceFromSrc(dist, spSet);

            // Mark the picked vertex as processed
            spSet[u] = true;

            // Iterate through all adjacent nodes
            for (int v = 0; v < V; v++) {

                // Check if there is a edge between the node in point to adj node
                // And check for that node shortest Path has not been computes yet
                // 3rd condition - Check if u node is not at infinite distance from v and minimum distance check
                // if v node distance should be updated or not
                if(graph[u][v] != 0 && !spSet[v] && (dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;

    }

    private int getNodeAtMinDistanceFromSrc(int[] dist, Boolean[] spSet) {

        int nodeAtMinDistance = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < dist.length; i++){
            if(!spSet[i]){
                if (dist[i] < minDist) {
                    minDist = dist[i];
                    nodeAtMinDistance = i;
                }
            }
        }

        return  nodeAtMinDistance;
    }
}
