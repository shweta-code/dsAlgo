package com.algos.leetcode.graph;

public class LeetCode200NoOfIslands {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (isLand(i, j, grid)) {

                        numOfIslands++;
                        markAndMove(i,j,grid,visited);
                    } else {
                        visited[i][j] = true;
                    }
                }
            }
        }
        return numOfIslands;
    }

    public boolean isLand(int i , int j, char[][] grid) {
        return grid[i][j] == '1';
    }


    public void markAndMove(int row, int col, char[][] grid, boolean[][] visited) {
        if (row >= grid.length || row<0 || col>= grid[0].length || col <0) {
            return;
        }

        if (!visited[row][col]) {

            visited[row][col] = true;
            if ( isLand(row, col, grid)) {
                // go right
                markAndMove(row, col+1, grid, visited);

                // go left
                // WHy we have to go left? - For use case like this
                // 1 1 1
                // 0 1 0
                // 1 1 1
                markAndMove(row, col -1, grid, visited);

                // go bottom
                markAndMove(row+1, col, grid, visited);

                // go up
                // Why we have to go up? - For a use case like this
                // 1 1 1
                // 0 1 1
                // 1 0 1
                // 1 1 1
                markAndMove(row-1, col, grid, visited);
            }
        }
    }
}
