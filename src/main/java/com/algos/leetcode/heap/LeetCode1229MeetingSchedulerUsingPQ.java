package com.algos.leetcode.heap;

import java.util.*;

public class LeetCode1229MeetingSchedulerUsingPQ {

    public List<Integer> minAvailableDuration(int[][] personOne, int[][] personTwo, int duration) {


        PriorityQueue<int[]> timeSlots = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] slots :
                personOne) {
            if (slots[1] - slots[0] >= duration) {
                timeSlots.offer(slots);
            }
        }

        for (int[] slots :
                personTwo) {
            if (slots[1] - slots[0] >= duration) {
                timeSlots.offer(slots);
            }
        }

        while (timeSlots.size() > 1) {
            int[] slot1 = timeSlots.poll();
            int[] slot2 = timeSlots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<>();
    }

}
