package com.algos.graphs;

import org.junit.Test;

import java.util.ArrayList;

public class TopologicalSortTest {

    private final TopologicalSortKahnsAlgorithm topoSort = new TopologicalSortKahnsAlgorithm();

    @Test
    public void testFiveEdges() {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // adj.get(3).add(4);
        adj.get(3).add(0);
        adj.get(1).add(0);
        adj.get(2).add(0);
        topoSort.topoSort(V, adj);
    }
}
