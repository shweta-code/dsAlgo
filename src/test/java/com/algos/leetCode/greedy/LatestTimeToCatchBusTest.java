package com.algos.leetCode.greedy;

import com.algos.leetcode.greedy.LatestTimeToCatchBusWrong;
import org.junit.Assert;
import org.junit.Test;

public class LatestTimeToCatchBusTest {

    private final LatestTimeToCatchBusWrong timeToCatchBus = new LatestTimeToCatchBusWrong();

    @Test
    public void test1() {
        int timeCatchTheBus = timeToCatchBus.latestTimeCatchTheBus(new int[]{10, 20}, new int[]{2, 17, 18, 19}, 2);
        Assert.assertEquals(16,timeCatchTheBus);
    }
}
