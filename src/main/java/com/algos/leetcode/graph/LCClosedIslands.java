package com.algos.leetcode.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LCClosedIslands {

        int rows =0;
        int cols = 0;
        public int closedIsland(int[][] grid) {

            rows = grid.length;
            cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];

            for(int i = 0 ; i < cols; i++){
                if(grid[0][i] == 0){
                    grid[0][i] = -1;
                }

                if(grid[rows-1][i] == 0){
                    grid[rows-1][i] = -1;
                }
            }

            for(int i = 0; i< rows; i++){
                if(grid[i][0] == 0){
                    grid[i][0] = -1;
                }

                if(grid[i][cols-1] == 0){
                    grid[i][cols -1] = -1;
                }
            }

            int closedIslands = 0;
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            for(int i = 0; i< rows; i++){
                for(int j = 0; j< cols; j++){


                    if(grid[i][j] == 1 || grid[i][j] == -1){
                        visited[i][j] = true;
                    } else if(!visited[i][j]) {

                        boolean found = true;
                        q.add(new Pair<>(i, j));
                        while(!q.isEmpty()){

                            Pair<Integer, Integer> coords = q.poll();
                            int row = coords.getKey();
                            int col = coords.getValue();

                            if(grid[row][col] == -1){
                                found = false;
                            } else if(!visited[row][col] &&  grid[row][col] == 0){

                                if(isValid(row -1 , col)){
                                    q.add(new Pair<>(row -1 , col));
                                }

                                if(isValid(row+1, col)){
                                    q.add(new Pair<>(row+1, col));
                                }

                                if(isValid(row, col -1)){
                                    q.add(new Pair<>(row, col -1));
                                }

                                if(isValid(row, col+1)){
                                    q.add(new Pair<>(row, col+1));
                                }
                            }
                            visited[row][col] = true;

                        }
                        if(found){
                            closedIslands++;
                        }

                    }




                }
            }

            return closedIslands;
        }


        private boolean isValid(int row, int col){
            return row < this.rows && row >= 0 && col < this.cols && col >= 0;
        }


}
