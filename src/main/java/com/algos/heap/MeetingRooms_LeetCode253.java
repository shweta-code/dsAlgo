package com.algos.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_LeetCode253 {

    public static void main(String[] args) {
        /*minMeetingRooms(new int[][]{{0,30},{5,10},{5,5},{5,10},{15,20}});
        minMeetingRooms(new int[][]{});*/
    }

    public  int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        //sort as per start Time
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            } else if (o1[0] > o2[0]){
                return 1;
            } else {
                if(o1[1] < o2[1]){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        PriorityQueue<Integer> minHeapFinishTime = new PriorityQueue<>(Comparator.naturalOrder());


        int meetingRooms = 1;
        minHeapFinishTime.add(finishTimeForMeeting(intervals, 0));

        for (int i = 1; i < intervals.length; i++) {
            Integer startTime = startTimeForMeeting(intervals, i);
            Integer minFinishTime = minHeapFinishTime.peek();
            if(minFinishTime <= startTime){
                minHeapFinishTime.poll();
            } else {
                meetingRooms++;
            }
            minHeapFinishTime.add(finishTimeForMeeting(intervals,i));
        }

        return meetingRooms;
    }

    private static Integer finishTimeForMeeting(int[][] intervals, int room) {
        return intervals[room][1];
    }

    private static Integer startTimeForMeeting(int[][] intervals, int room) {
        return intervals[room][0];
    }

    //Test Cases

}
