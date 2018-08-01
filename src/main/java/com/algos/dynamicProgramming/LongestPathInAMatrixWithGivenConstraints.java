package com.algos.dynamicProgramming;


public class LongestPathInAMatrixWithGivenConstraints {

    /*Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.

    We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.

    Example:

    Input:  mat[][] = {{1, 2, 9}
        {5, 3, 8}
        {4, 6, 7}}
    Output: 4
    The longest path is 6-7-8-9.*/

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        int dp[][] = {{-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};

        int m = mat.length; //row
        int n = mat[0].length; //column
        int result = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = findAns(mat, i, j, dp, m, n);
                    result = result > dp[i][j] ? result : dp[i][j];
                }
            }
        }
        System.out.println(result);


    }

    private static int findAns(int[][] mat, int i, int j, int[][] dp, int m, int n) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (j + 1 < n && (mat[i][j] + 1) == mat[i][j + 1]) {
            dp[i][j] = 1 + findAns(mat, i, j + 1, dp, m, n);
            return dp[i][j];
        }

        if (i + 1 < m && (mat[i][j] + 1) == mat[i + 1][j]) {
            dp[i][j] = 1 + findAns(mat, i + 1, j, dp, m, n);
            return dp[i][j];
        }

        if (i - 1 >= 0 && (mat[i][j] + 1) == mat[i - 1][j]) {
            dp[i][j] = 1 + findAns(mat, i - 1, j, dp, m, n);
            return dp[i][j];
        }

        if (j - 1 >= 0 && (mat[i][j] + 1) == mat[i][j - 1]) {
            dp[i][j] = 1 + findAns(mat, i, j - 1, dp, m, n);
            return dp[i][j];
        }

        return 1;

    }
}


