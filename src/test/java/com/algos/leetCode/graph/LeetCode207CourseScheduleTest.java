package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCode207CourseSchedule;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode207CourseScheduleTest {

    private final LeetCode207CourseSchedule courseSchedule = new LeetCode207CourseSchedule();

    @Test
    public void testTwoCyclicNodes() {
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        boolean canFinish = courseSchedule.canFinish(2, prerequisites);
        Assert.assertFalse(canFinish);

    }
}
