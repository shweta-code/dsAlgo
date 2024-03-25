package com.algos.graphs.shortestPath;

import org.junit.Assert;
import org.junit.Test;


public class DjikstrasAlgorithmTest {

    @Test
    public void testOne(){
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

        Assert.assertArrayEquals(new int[]{0, 4, 12, 19, 21, 11, 9, 8, 14}, d.djikstra(graph, 0));
    }

}
