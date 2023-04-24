package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCode210CourseScheduleII;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode210CourseScheduleIITest {

    private final LeetCode210CourseScheduleII courseSchedule = new LeetCode210CourseScheduleII();

    // leetcode test case
    @Test
    public void testTwoNodesAcyclic() {
        int[][] prerequisites = new int[][]{{1,0}};
        int[] order = courseSchedule.findOrder(2, prerequisites);
        Assert.assertArrayEquals(new int[]{0,1},order);

    }

    // leetcode test case
    @Test
    public void testTwoNodesCyclic() {
        int[][] prerequisites = new int[][]{{1,0},{1,2},{0,1}};
        int[] order = courseSchedule.findOrder(3, prerequisites);
        Assert.assertArrayEquals(new int[]{},order);

    }


    // leetcode test case
    @Test
    public void testthreeDisconnectedGraphsWhereOneisCyclic() {
        int[][] prerequisites = new int[][]{{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}};
        int[] order = courseSchedule.findOrder(8, prerequisites);
        Assert.assertArrayEquals(new int[]{},order);

    }
}
