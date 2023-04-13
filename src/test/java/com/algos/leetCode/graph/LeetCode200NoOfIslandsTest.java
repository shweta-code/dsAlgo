package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCode200NoOfIslands;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode200NoOfIslandsTest {

    private final LeetCode200NoOfIslands noOfIslands = new LeetCode200NoOfIslands();

    @Test
    public void testCaseOne() {

        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int numIslands = noOfIslands.numIslands(grid);
        Assert.assertEquals(1, numIslands);
    }
}
