package com.algos.google;

import com.algos.heap.MeetingRooms_LeetCode253;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRooms_LeetCode253_Approach2Test {
    MeetingRooms_LeetCode253_Approach2 meetingRooms_leetCode253 = new MeetingRooms_LeetCode253_Approach2();

    @Test
    public void emptyInputTest_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{});
        Assert.assertEquals(0 , minMeetingRooms);
    }

    @Test
    public void overlappingMeetings_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{0,30},{5,10},{5,5},{5,10},{15,20}});
        Assert.assertEquals(3 , minMeetingRooms);
    }

    @Test
    public void nonOverlappingMeetings_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{0,30},{30,40},{40,50}});
        Assert.assertEquals(1 , minMeetingRooms);
    }

    @Test
    public void nonOverlappingNonSortedMeetings_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{13,15},{1,13}});
        Assert.assertEquals(1 , minMeetingRooms);
    }

    @Test
    public void nonOverlappingNonSortedMeetings2_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{2,11},{6,16},{11,16}});
        Assert.assertEquals(2 , minMeetingRooms);
    }

    @Test
    public void nonOverlappingNonSortedMeetings3_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{11,17},{2,11},{2,11},{2,11}});
        Assert.assertEquals(3, minMeetingRooms);
    }

    @Test
    public void nonOverlappingNonSortedMeetings4_success(){
        int minMeetingRooms = meetingRooms_leetCode253.minMeetingRooms(new int[][]{{17,18},{11,17},{2,11},{2,11},{2,11}});
        Assert.assertEquals(3, minMeetingRooms);
    }

}
