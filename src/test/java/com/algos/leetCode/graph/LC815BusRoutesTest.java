package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LC815BusRoutes;
import org.junit.Assert;
import org.junit.Test;

public class LC815BusRoutesTest {

    LC815BusRoutes busRoutes = new LC815BusRoutes();
    @Test
    public void test1(){
        int busesToDestination = busRoutes.numBusesToDestination(new int[][]{{0, 1, 6, 16, 22, 23}, {14, 15, 24, 32}, {4, 10, 12, 20, 24, 28, 33}, {1, 10, 11, 19, 27, 33}, {11, 23, 25, 28}, {15, 20, 21, 23, 29}, {29}},
                4,
                21);
        Assert.assertEquals(2, busesToDestination);
    }
}
