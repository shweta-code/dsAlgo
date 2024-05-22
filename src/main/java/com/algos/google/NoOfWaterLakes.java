package com.algos.google;

// You are given a point to a land in a map from satellite
// You have to find out how many lakes are within the land bounded by the land that connects the point
// It is an infinite piece of information - an infinite ocean
// Please consider edge cases
// Adjacency - No diagonal, only left ,right , up , down

import java.util.LinkedList;
import java.util.Queue;


// TODO
// How best to consider this information
// I started with marking these as pixels
// Basically a matrix that has RGB co-ordinates to represent satellite photo
// The interviewer hinted if I should use 0 and 1, that should actually be the right representation
public class NoOfWaterLakes {
    public static void main(String[] args) {
        // test cases -
        // [0 1 1 1 0]
        // [0 1 0 1 0]
        // [0 1 1 1 0]
        // Given a co-ordinate (0,1) handle to a point in land, find lakes

        // BFS
        int[][] map = new int[3][5];
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[3][5]; //
        // The problem was a scaled problem, you can not use  here boolean of matrix, you will have to use the map of visited
        // co-ordinated

        // Create a bfs q
        Queue<Point> bfsQ = new LinkedList<>();

        // Add seed data - point to land
        // mark is visited
        while(!bfsQ.isEmpty()){
            Point point = bfsQ.poll();
            // visit all directions
            // if adjacent co-ordiantes are valid and not visited
                // if it is water
                    // create a map of water co-ordinated , map has mapping of point to boolean visited/not-visited
                //  if it is land
                    // push them to bfsQ
                    // mark them visited

        }

        // With all co-ordinates of water

        // iterate over map
            // take one point
            // noOfIslands++
            // if it is not visited
                // initialize a q , put it in q and mark it visited
                    while (!bfsQ.isEmpty()) {
                        // Poll the point
                        // Go to adjacent directions
                        // see if these point exist in map and not visited
                        // push them in q and mark them visited
                    }

        //return noOfIslands -1;
    }


}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
