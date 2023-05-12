package com.algos.leetcode.heap;

import java.util.Arrays;

public class LeetCode253MeetingRoomsUsingTwoPointers {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int meetingRooms = 0;
        int min = 0;
        while (i < n && j < n) {

            if (start[i] < end[j]) {
                meetingRooms++;
                i++;
            } else {
                j++;
                meetingRooms --;
            }

            min = Math.max(min, meetingRooms);
        }

        return min;
    }
}
