package com.algos.leetcode.dynamicProgramming;

public class LeetCode42TrappingRainWaterWrong {

    public int trap(int[] height) {

        int max = height[0];
        int possibleWaterStored = 0;
        int waterStored = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                waterStored += possibleWaterStored;
                possibleWaterStored = 0;
            } else {
                possibleWaterStored += (max - height[i]);
            }
        }

        return waterStored;
    }
}
