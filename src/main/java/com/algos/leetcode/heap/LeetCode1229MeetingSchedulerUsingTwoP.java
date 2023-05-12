package com.algos.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode1229MeetingSchedulerUsingTwoP {

    public List<Integer> minAvailableDuration(int[][] personOne, int[][] personTwo, int duration) {

        Arrays.sort(personOne, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(personTwo, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = 0;
        while (i < personOne.length && j < personTwo.length) {
            int intersectLeft = Math.max(personOne[i][0], personTwo[j][0]);
            int intersectRight = Math.max(personOne[i][1], personTwo[j][1]);

            if (intersectRight - intersectLeft >= duration) {
                return new ArrayList<Integer>(){{
                    add(intersectLeft);
                    add(intersectLeft+duration);
                }};
            }

            if (personOne[i][1] < personTwo[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();

    }
}
