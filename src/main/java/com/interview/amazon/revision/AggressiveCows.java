package com.interview.amazon.revision;

import java.util.Arrays;

// https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
// https://www.geeksforgeeks.org/problems/aggressive-cows/1
public class AggressiveCows {

    public static void main(String[] args) {
        // arr
        // sort the arr
        int[] stalls = new int[]{1, 2, 4, 8, 9};
        int k = 3;
        Arrays.sort(stalls);
        int size = stalls.length;
        int minDistance = 1;
        int maxDistance = stalls[size-1] - stalls[0];

        binarySearch(minDistance, maxDistance, k, stalls);
    }

    private static int binarySearch(int low , int high, int k, int[] arr) {
        while (low <= high) {
            int mid = (high + low) / 2;

            if (canWePlace(mid, k, arr)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return high;

    }

    private static boolean canWePlace(int atLeastDistance, int k, int[] arr) {

        // Let's place the first one at 0 index
        int cowsPlaced = 1;
        int lastPlaced = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlaced >= atLeastDistance) {
                cowsPlaced++;
                lastPlaced = arr[i];
            }

            if (cowsPlaced >= k) {
                return true;
            }
        }

        return false;
    }
}
