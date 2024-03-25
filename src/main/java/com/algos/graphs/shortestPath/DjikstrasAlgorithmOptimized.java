package com.algos.graphs.shortestPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DjikstrasAlgorithmOptimized {
    public final int V;

    public DjikstrasAlgorithmOptimized(int v) {
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
        DjikstrasAlgorithmOptimized d = new DjikstrasAlgorithmOptimized(graph.length);
        int[] djistraOptimal = d.djikstraOptimal(0, graph);
        System.out.println(Arrays.toString(djistraOptimal));

    }

    public int[] djikstraOptimal(int src, int[][] graph){

        Queue<NodeAndDistance> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        int[] distanceOfNodesFromSrc = new int[V];

        Arrays.fill(distanceOfNodesFromSrc, Integer.MAX_VALUE);

        // feed data
        distanceOfNodesFromSrc[src] = 0;
        q.add(new NodeAndDistance(src, distanceOfNodesFromSrc[src]));

        while (!q.isEmpty()) {
            NodeAndDistance polled = q.poll();
            int u = polled.node;
            int distanceFromSrc = polled.distance;

            for (int v = 0; v < V; v++) {
                if(graph[u][v] != 0 &&  distanceFromSrc + graph[u][v] < distanceOfNodesFromSrc[v]){
                    distanceOfNodesFromSrc[v] = distanceFromSrc + graph[u][v];
                    q.add(new NodeAndDistance(v, distanceOfNodesFromSrc[v]));
                }
            }

        }

        return distanceOfNodesFromSrc;
    }

    public static class NodeAndDistance{
        public int node;
        public int distance;

        public NodeAndDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
