package com.algos.dynamicProgramming;


public class MinCostPath {

    /*Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

    For example, in the following figure, what is the minimum cost path to (2, 2)?


    The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).
*/

    public static void main(String[] args) {

        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        int m = cost.length;
        int n = cost[0].length;

        System.out.println(findMinCostUsingIteration(cost, m, n));

    }

    private static int findMinCostUsingRecurssion(int[][] cost, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return cost[i][j];
        } else if (i > m - 1 || j > n - 1) {
            return Integer.MAX_VALUE;
        } else {
            return cost[i][j] + Math.min(Math.min(findMinCostUsingRecurssion(cost, m, n, i + 1, j + 1), findMinCostUsingRecurssion(cost, m, n, i + 1, j)), findMinCostUsingRecurssion(cost, m, n, i, j + 1));
        }
    }

    private static int findMinCostUsingIteration(int[][] cost, int m, int n) {
        int tc[][] = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};


        tc[0][0] = cost[0][0];
        for (int i = 1; i < m; i++) {
            tc[0][i] = tc[0][i - 1] + cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tc[i][j] = cost[i][j] + Math.min(Math.min(tc[i - 1][j - 1], tc[i - 1][j]), tc[j - 1][i]);
            }
        }

        return tc[2][2];
    }


}
