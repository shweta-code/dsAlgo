package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LC1101EarliestWhenEveryoneFriends;
import org.junit.Assert;
import org.junit.Test;

public class LC1101EarliestWhenEveryoneFriendsTest {

    private final LC1101EarliestWhenEveryoneFriends becomeFriends = new LC1101EarliestWhenEveryoneFriends();
    @Test
    public void test1() {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int earliestAcq = becomeFriends.earliestAcq(logs, 6);
        Assert.assertEquals(20190301,earliestAcq);
    }
}
