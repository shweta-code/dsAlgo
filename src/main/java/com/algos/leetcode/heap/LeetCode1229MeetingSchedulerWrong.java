package com.algos.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode1229MeetingSchedulerWrong {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        int i = 0;
        int j = 0;
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        List<Integer> slot = new ArrayList<>();
        int timeSlot = 0;
        int startTime = 0;

        while(i < slots1.length && j < slots2.length){

            // for production readiness, we can encapsulate these conditions in methods with meaningful name
            if(slots1[i][0] >= slots2[j][0] && slots1[i][0] <= slots2[j][1]){
                timeSlot = Math.min(slots2[j][1], slots1[i][1]) - slots1[i][0];
                j++;
                startTime = slots1[i][0];
                // slot.add(slots1[i][0]);
                // slot.add(slots2[j][1]);

            } else if (slots2[j][0] >= slots1[i][0] && slots2[j][0] <= slots1[i][1]){
                timeSlot = Math.min(slots2[j][1], slots1[i][1]) - slots2[j][0];
                i++;
                startTime = slots2[j][0];
                // slot.add(slots2[j][0]);
                // slot.add(slots1[i][1]);
            } else if(slots1[i][0] > slots2[j][0] && slots1[i][0] >= slots2[j][1]){
                j++;

            } else {
                i++;
            }

            if(timeSlot >= duration ){
                slot.add(startTime);
                slot.add(startTime + duration);
                return slot;
            }



        }


        return slot;

    }
}
