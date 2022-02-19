package com.algos.google;

import java.util.*;

public class MeetingRooms_LeetCode253_Approach2 {

    public static void main(String[] args) {
        /*minMeetingRooms(new int[][]{{0,30},{5,10},{5,5},{5,10},{15,20}});
        minMeetingRooms(new int[][]{});*/
    }

    public  int minMeetingRooms(int[][] intervals) {
        List<MeetingTime> meetingTimes = new ArrayList<>();
        for (int[] interval : intervals) {
            meetingTimes.add(new MeetingStart(interval[0]));
            meetingTimes.add(new MeetingFinish(interval[1]));
        }
        meetingTimes.sort((o1, o2) -> {
            if (o1.getTime() < o2.getTime()) {
                return -1;
            } else if (o1.getTime() > o2.getTime()) {
                return 1;
            } else {
                //case when o1 and o2 are equal
                if (o1 instanceof MeetingFinish) {
                    return meetingTimes.indexOf(o2) - meetingTimes.indexOf(o1);
                } else if (o2 instanceof MeetingFinish) {
                    return meetingTimes.indexOf(o1) - meetingTimes.indexOf(o2);
                } else {
                    return 0;
                }

            }
        });

        System.out.println(Arrays.toString(meetingTimes.toArray()));
        int maxMeetingRooms = 0;
        int currentMeetingRooms = 0;
        for (MeetingTime meetingTime : meetingTimes) {
            if(meetingTime instanceof MeetingStart){
                currentMeetingRooms++;
            } else {
                currentMeetingRooms--;
            }
            maxMeetingRooms = Math.max(currentMeetingRooms , maxMeetingRooms);
        }
        return maxMeetingRooms;
    }

    public class MeetingTime{
        protected int time;

        public MeetingTime(int time) {
            this.time = time;
        }

        protected int getTime() {
            return time;
        }
    }

    public class MeetingStart extends MeetingTime{
        public MeetingStart(int time) {
            super(time);
        }

        @Override
        public String toString() {
            return "MeetingStart{" +
                    "time=" + time +
                    '}';
        }
    }

    public class MeetingFinish extends MeetingTime{
        public MeetingFinish(int time) {
            super(time);
        }

        @Override
        public String toString() {
            return "MeetingFinish{" +
                    "time=" + time +
                    '}';
        }
    }

    private static Integer finishTimeForMeeting(int[][] intervals, int room) {
        return intervals[room][1];
    }

    private static Integer startTimeForMeeting(int[][] intervals, int room) {
        return intervals[room][0];
    }

    //Test Cases

}
