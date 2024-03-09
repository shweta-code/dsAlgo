package com.algos.leetcode.graph;



import com.algos.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200NoOfIslandsBFS {

    public int numIslandsWrong(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (isLand(i, j, grid)) {

                        numOfIslands++;
                        bfs(i,j,grid,visited);
                    } else {
                        // This is a redundant condition
                        visited[i][j] = true;
                    }
                }
            }
        }
        return numOfIslands;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited) {
        // Check boundary condition


        // Mark it visited
        visited[row][col] = true;

        int[] drow = new int[]{-1, 0, +1, 0};
        int[] dcol = new int[]{0, -1, 0, +1};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(row, col));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            row = poll.getKey();
            col = poll.getValue();
            if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
                continue;
            }

            //mark it visited

            if (isLand(row, col, grid) && !visited[row][col]) {
                queue.add(new Pair<>(row + drow[0], col + dcol[0]));
                queue.add(new Pair<>(row + drow[1], col + dcol[1]));
                queue.add(new Pair<>(row + drow[2], col + dcol[2]));
                queue.add(new Pair<>(row + drow[3], col + dcol[3]));
            }
            visited[row][col] = true;

        }
    }

    public boolean isLand(int i , int j, char[][] grid) {
        return grid[i][j] == '1';
    }
}
