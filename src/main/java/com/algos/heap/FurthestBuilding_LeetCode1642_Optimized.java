package com.algos.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FurthestBuilding_LeetCode1642_Optimized {

    public static void main(String[] args) {
        FurthestBuilding_LeetCode1642_Optimized obj = new FurthestBuilding_LeetCode1642_Optimized();
        System.out.println(obj.furthestBuilding_BruteForce(new int[]{4,12,2,7,3,18,20,3,19},
        10,
        2));
    }


    // Using Recursssion
    public int furthestBuilding_BruteForce(int[] heights, int bricks, int ladders) {

        //Ladders is the initial size
        PriorityQueue<Integer> bricksMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> laddersMinHeap = new PriorityQueue<>();
        int i = 0;

        while(i < heights.length-1 && (ladders != 0 ||  bricks >= heights[i+1] - heights[i]) ){
            int stepSize = heights[i+1] - heights[i];
            if(stepSize < 0){
                i++;
                continue;
            } else if(bricks >= stepSize){
                bricksMaxHeap.add(stepSize);
                bricks -= stepSize;
                System.out.println(
                            "bricksMaxHeap -- " +bricksMaxHeap.toString()
                );
            } else if(ladders > 0){
                System.out.println("Use Ladders");
                if( !bricksMaxHeap.isEmpty() && stepSize < bricksMaxHeap.peek()){
                    Integer biggerStep = bricksMaxHeap.poll();
                    bricks += biggerStep;
                    laddersMinHeap.add(biggerStep);

                    ladders -= 1;
//                    i++;
                    bricksMaxHeap.add(stepSize);
                    bricks -= stepSize;

                } else {
                    laddersMinHeap.add(stepSize);
                    ladders -= 1;
//                    i++;
                }
            }
            i++;

        }
        return i;
    }
}
