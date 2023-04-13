package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCode547NoOfProvinces;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode547NoOfProvincesTest {

    private final LeetCode547NoOfProvinces noOfProvinces = new LeetCode547NoOfProvinces();

    @Test
    public void isConnectedThreeCities(){

        // Revise - Define an inline array
        int num = noOfProvinces.findCircleNumNotWorking(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        Assert.assertEquals(2, num);

    }

    @Test
    public void isConnectedThirteenCities(){

        int[][] connectedArr = new int[][]{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};

        // Revise - Define an inline array
        int num = noOfProvinces.findCircleNumNotWorking(connectedArr);
        Assert.assertEquals(8, num);

    }
}
