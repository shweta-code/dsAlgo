package com.algos.dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class MinimizeFarthestDistanceTest {

    private final MinimizeFarthestDistance minimizeFarthestDistance = new MinimizeFarthestDistance();
    @Test
    public void test1() {
        int ans = minimizeFarthestDistance.minimumFarthestDistanceForAnyAmenity(new int[][]{{0, 1}, {1, 0}});
        Assert.assertEquals(1, ans);
    }
}
