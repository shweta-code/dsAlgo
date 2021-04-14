package com.algos.heap;

public class FurthestBuilding_LeetCode1642_BruteForce {

    public static void main(String[] args) {
        FurthestBuilding_LeetCode1642_BruteForce obj = new FurthestBuilding_LeetCode1642_BruteForce();
        System.out.println(obj.furthestBuilding_BruteForce(new int[]{4,2,7,6,9,14,12}, 5 , 1));
    }


    // Using Recursssion
    public int furthestBuilding_BruteForce(int[] heights, int bricks, int ladders) {

        return traverseBuilding(heights , 0 , bricks ,ladders);
//        return 0;
    }

    public int traverseBuilding(int[] heights , int currentBuilding , int bricks , int ladders){
        //Reached end
        if(reachedEndBuilding(currentBuilding, heights)){
            return currentBuilding;
        }

        int stepSize = heights[currentBuilding+1] - heights[currentBuilding];
        if(noFurtherMovePossible(ladders , bricks , stepSize)){
            return currentBuilding;
        }

        if(stepSize <= 0){
            return traverseBuilding(heights , currentBuilding+1 , bricks , ladders);
        } else {
            return Math.max(useLadder(heights, currentBuilding, bricks, ladders),
                    useBrick(heights, currentBuilding, bricks, ladders, stepSize));
//        return 0;
        }

    }

    private int useBrick(int[] heights, int currentBuilding, int bricks, int ladders, int stepSize) {
        if(stepSize < bricks)
            return traverseBuilding(heights , currentBuilding+1 , bricks - stepSize, ladders);
        else
            return currentBuilding;

    }

    private int useLadder(int[] heights, int currentBuilding, int bricks, int ladders) {
        if(ladders > 0)
            return traverseBuilding(heights , currentBuilding+1 , bricks, ladders - 1);
        else
            return currentBuilding;
    }

    private boolean noFurtherMovePossible(int ladders, int bricks, int stepSize) {
        return (ladders == 0 && bricks < stepSize);
    }

    private boolean reachedEndBuilding(int currentBuilding, int[] heights) {
        return currentBuilding == heights.length - 1;
    }
}
