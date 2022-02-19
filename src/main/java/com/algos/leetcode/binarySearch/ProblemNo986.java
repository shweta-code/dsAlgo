package com.algos.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class ProblemNo986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int firstListIndex = 0;
        int secondListIndex = 0;
        List<int[]> ans = new ArrayList<>();

        while ( firstListIndex < firstList.length && secondListIndex < secondList.length) {
            int startFirstList = firstList[firstListIndex][0];
            int startSecondList = secondList[secondListIndex][0];
            int endFirstList = firstList[firstListIndex][1];
            int endSecondList = secondList[secondListIndex][1];

            if(endSecondList < startFirstList) {
                secondListIndex++;
            } else if(endSecondList == startFirstList) {
                ans.add(new int[]{startFirstList, endSecondList});
                secondListIndex++;;
            } else if (endSecondList > startFirstList && endSecondList < endFirstList){
                ans.add(new int[]{Math.max(startFirstList, startSecondList), endSecondList});
                secondListIndex++;
            } else if (endSecondList == endFirstList){
                ans.add(new int[]{Math.max(startFirstList, startSecondList), endSecondList});
                secondListIndex++;
                firstListIndex++;
            } else if(startSecondList <= endFirstList && endSecondList > endFirstList){
                ans.add(new int[]{Math.max(startFirstList, startSecondList), endFirstList});
                firstListIndex++;
            } else {
                firstListIndex ++;
            }


        }

        return ans.toArray(new int[ans.size()][2]);


    }

    class OverLapArray {
        int[] overlapInterval = new int[2];

        public OverLapArray(int start , int end) {
            this.overlapInterval[0] = start;
            this.overlapInterval[1] = end;
        }
    }
}
