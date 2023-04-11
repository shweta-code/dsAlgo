package com.algos.graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraphTest {
    private final CycleDetectionInDirectedGraph cycleDetectionInDirectedGraph = new CycleDetectionInDirectedGraph();

    @Test
    public void isCycleForAcyclicGraph() {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(3);
        adj.get(3).add(1);
        adj.get(1).add(2);
        adj.get(2).add(4);
        adj.get(4).add(0);
        boolean isCycle = cycleDetectionInDirectedGraph.isCycle(V, adj);
        Assert.assertFalse(isCycle);
    }

    @Test
    public void isCycleForSelfLoop() {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);
        boolean isCycle = cycleDetectionInDirectedGraph.isCycle(V, adj);
        Assert.assertTrue(isCycle);
    }

}
