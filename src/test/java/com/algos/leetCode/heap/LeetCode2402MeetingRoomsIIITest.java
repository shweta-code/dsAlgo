package com.algos.leetCode.heap;

import com.algos.leetcode.heap.LeetCode2402MeetingRoomsIIITwoHeaps;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode2402MeetingRoomsIIITest {

    LeetCode2402MeetingRoomsIIITwoHeaps meetingRoomsIII = new LeetCode2402MeetingRoomsIIITwoHeaps();

    @Test
    public void testMostBooked() {
        int i = meetingRoomsIII.mostBooked(3, new int[][]{{0, 10}, {1, 9}, {2, 8}, {3, 7}, {4, 6}});
        Assert.assertEquals(1, i);


    }

    @Test
    public void testMostBooked2() {
        int i = meetingRoomsIII.mostBooked(4, new int[][]{{18,19},{3,12},{17,19},{2,13},{7,10}});
        Assert.assertEquals(0, i);


    }
}
