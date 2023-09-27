package com.algos.amazon;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// In Progress
// https://leetcode.com/problems/unique-paths-ii/
public class RobotJumping {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(0, 0));
        boolean[][] visited = new boolean[obstacleGrid.length][];
        visited[0][0] = true;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {


            }

        }

        int dir[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!q.isEmpty()) {
            Pair<Integer, Integer> poll = q.poll();



        }
        return 0;
    }
}
