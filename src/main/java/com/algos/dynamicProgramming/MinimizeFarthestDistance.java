package com.algos.dynamicProgramming;

import java.util.Arrays;

// Mock Interview - https://www.youtube.com/watch?v=rw4s4M3hFfs
public class MinimizeFarthestDistance {

    // There can be no of things
    // validate the input
    // test cases
    // valid/invalid input
    // time / space complexity constraint

    public int minimumFarthestDistanceForAnyAmenity(int[][] blocks) {
        // For simplicity, blocks arr has information for req amenities only
        int totalBlocks = blocks.length;
        int amenities = blocks[0].length;
        int[][] dpLeft = new int[totalBlocks+2][blocks[0].length];
        int[][] dpRight = new int[totalBlocks+2][blocks[0].length];

        for (int i = 0; i < totalBlocks; i++) {
            for (int j = 0; j < amenities; j++) {
                if (blocks[i][j] == 0) {
                    blocks[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int j = 0; j < amenities; j++) {
            dpLeft[0][j] = Integer.MAX_VALUE;
            dpRight[totalBlocks + 1][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < totalBlocks + 1; i++) {
            for (int j = 0; j < amenities; j++) {
                if (dpLeft[i-1][j] != Integer.MAX_VALUE) {
                    dpLeft[i][j] = Math.min(blocks[i-1][j], dpLeft[i-1][j]+1);
                }
            }
        }

        /*Mapping Assumed*/
/*        0 1 2 3
left  0 1 2 3
right   1 2 3 4 5*/


        for (int i = totalBlocks; i > 0; i--) {
            for (int j = 0; j < amenities; j++) {
                if (dpRight[i+1][j] != Integer.MAX_VALUE) {
                    dpRight[i][j] = Math.min(blocks[i-1][j], dpLeft[i+1][j]+1);
                } else {
                    dpRight[i][j] = blocks[i-1][j];
                }
            }
        }

        System.out.println("dpLeft -> " +Arrays.toString(dpLeft));
        System.out.println("dpRight -> " + Arrays.toString(dpRight));

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < totalBlocks + 1; i++) {
            for (int j = 0; j < amenities; j++) {
                if (dpLeft[i][j] != dpRight[i][j]) {
                    ans = Math.max(dpLeft[i][j], dpRight[i][j]);
                }
            }
        }

        return ans;

        /* if any block does not have a given amenity, let me replace it with infinity
        * 2 imaginary blocks at beg and end
        * dpLeft - 2D arrays of size n+2, amenities.length
        * dpRight
        *
        * baseCase - dpLeft[0] = Integer.MAX
        *            dpRight[n] = Integer.MAX
        *
        *     for left 0-> n
        *     blocks[i][j] != Integer.MAX
        *                   dp[i][j] = Math.min(blocks[i-1][j-1], dp[i-1][j-1]+1)
        *
        *     for right n+1 -> 1
        *           blocks[i][j] != Integer.MAX
        *           dp[i][j] = Math.min(blocks[i+1][j+1], dp[i+1][j+1]+1)
        *
        *     int ans = Integer.MIN;
        *     find dpLeft != dpRight
        *       Math.max(ans, Math.min(dpLeft, dpRight))
        *
        * */


        /*
        * RequiredAmenities
        * size of these amenities
        * change the input to replace the index of amenities in the block
        * */
    }


}
