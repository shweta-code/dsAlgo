package com.algos.leetcode.greedy;

import java.util.Arrays;

// Try to replicate this solution -> https://leetcode.com/problems/the-latest-time-to-catch-a-bus/solutions/2259320/greedy-solution-java/
public class LatestTimeToCatchBusWrong {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);

        int totalBuses = buses.length;
        int totalPass = passengers.length;

//        int c = 0;
        int i = 0;
        int j = 0;
        int ans = 0;

        while (i< totalBuses && j < totalPass) {
            int busDepartTime = buses[i];
            int c = 0;
            System.out.println("Next bus");
            while (j < totalPass && c < capacity && passengers[j] <= busDepartTime) {
                System.out.println("capacity -> "+c);
                System.out.println("passenger index -> "+j);
                c++;
                j++;
            }
//            c = c-1;
            j = j-1;
            int k = j;

            System.out.println("capacity before finding out -> "+c);
            if ((c == capacity) || (c < capacity && busDepartTime == passengers[j])) {
                while (k > 0 && c > 1) {
                    if (k - 1 > 0 && passengers[k] - 1 != passengers[k-1]) {
                        break;
                    }
                    k--;
                    c--;
                    System.out.println(" capacity while finding out-> "+c);
                }
                ans = passengers[k] - 1;

            } else {
                ans = busDepartTime;
            }
            System.out.println("Potential ans -> "+ ans);
            i++;
            j++;

        }
        return ans;

    }
}
