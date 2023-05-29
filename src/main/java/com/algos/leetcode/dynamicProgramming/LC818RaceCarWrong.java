package com.algos.leetcode.dynamicProgramming;

import java.util.Arrays;

// Right Solution
// https://leetcode.com/problems/race-car/discuss/2075150/Java-BFS-approach-comments-written-for-understanding
// This is wrong
// because here we are always coming back from floor power of two back to each position  that is there after ceil power of 2
public class LC818RaceCarWrong {

    public int racecar(int target) {
        if (0 == target) {
            return 0;
        }


        int n = target;
        boolean isAbsPowOfTwo = isAbsPowOfTwo(n +1);
        int floorPowOfTwo = floorPowOfTwo(n+1);
        if (isAbsPowOfTwo) {
            return floorPowOfTwo;
        }

        System.out.println("floorPowOfTwo -> "+ floorPowOfTwo);
        int[] dp = new int[2*n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= floorPowOfTwo; i++) {
            int upperBoundPowOfTwo = (int) (Math.pow(2, i) - 1);
            dp[upperBoundPowOfTwo] = i;

            int lowerbound = (int)Math.pow(2, i - 1);

            for (int j = upperBoundPowOfTwo -1; j >= lowerbound; j--) {
                int diff = upperBoundPowOfTwo - j;
                dp[j] = dp[upperBoundPowOfTwo] + 1 /*for R reversal*/ + dp[diff];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    private int floorPowOfTwo(int n) {

        int i = 0;
        boolean powOfTwo = true;
        while (n > 1){
            if(powOfTwo && n % 2 != 0){
                powOfTwo = false;
            }
            n = n/2;
            ++i;
        }

        if(powOfTwo){
            return i;
        } else {
            return i+1;
        }


    }

    private boolean isAbsPowOfTwo(int n) {

        while (n > 1){
            if (n % 2 != 0) {
                return false;
            }
            n = n/2;
        }

        return true;

    }
}
