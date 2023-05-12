package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCodeMinHeightTrees;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LeetCodeMinHeightTreesTest {

    // private final LeetCodeMinHeightTreesWrong minHeightTrees = new LeetCodeMinHeightTreesWrong();
    private final LeetCodeMinHeightTrees minHeightTrees = new LeetCodeMinHeightTrees();

    @Test
    public void testFourVertex(){

        // Revise - Define an inline array
        List<Integer> minHeightNodes = minHeightTrees.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}});
        int[] actuals = minHeightNodes.stream().mapToInt(Integer::intValue).toArray();
        Assert.assertArrayEquals(new int[]{1}, actuals);

    }

    @Test
    public void testSixEdges(){

        // Revise - Define an inline array
        List<Integer> minHeightNodes = minHeightTrees.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
        int[] actuals = minHeightNodes.stream().mapToInt(Integer::intValue).toArray();
        Assert.assertArrayEquals(new int[]{3,4}, actuals);

    }

    @Test
    public void testSingleNodeNoEdge(){

        // Revise - Define an inline array
        List<Integer> minHeightNodes = minHeightTrees.findMinHeightTrees(1, new int[][]{});
        int[] actuals = minHeightNodes.stream().mapToInt(Integer::intValue).toArray();
        Assert.assertArrayEquals(new int[]{0}, actuals);

    }

    @Test
    public void testTree(){

        // Revise - Define an inline array
        List<Integer> minHeightNodes = minHeightTrees.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}});
        int[] actuals = minHeightNodes.stream().mapToInt(Integer::intValue).toArray();
        Assert.assertArrayEquals(new int[]{1}, actuals);

    }
}
