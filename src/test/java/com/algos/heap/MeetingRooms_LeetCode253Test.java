package com.algos.heap;

import org.junit.Assert;
import org.junit.Test;

public class MeetingRooms_LeetCode253Test {
    MeetingRooms_LeetCode253 meetingRooms_leetCode253 = new MeetingRooms_LeetCode253();

    @Test
    public void emptyInputTest_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{});
        Assert.assertEquals(0 , minMeetingRooms);
    }

    @Test
    public void nonEmptyInputTest_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{0,30},{5,10},{5,5},{5,10},{15,20}});
        Assert.assertEquals(3 , minMeetingRooms);
    }

    @Test
    public void nonOverlappingInputTest_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{0,30},{30,40},{40,50}});
        Assert.assertEquals(1 , minMeetingRooms);
    }

}
