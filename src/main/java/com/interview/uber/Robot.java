package com.interview.uber;

import java.util.Arrays;

// https://leetcode.com/discuss/interview-question/3326856/Valid-Robot-Position-Question
// https://leetcode.com/discuss/interview-question/4718477/Uber-or-Phone-Screen-or-Amsterdam
public class Robot {

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'o','e','e','e','x'},
                {'o','e','x','x','x'},
                {'e','e','e','e','e'},
                {'x','e','o','e','e'},
                {'x','e','o','e','x'}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[][][] dp = new int[n+1][m+1][4];


        int TOP = 0;
        int LEFT = 1;
        int BOTTOM = 2;
        int RIGHT = 3;

        for (int i = 0; i < n; i++) {
            if(matrix[i][0] == 'x'){
                dp[i][0][LEFT] = 2;
            }
            dp[i][0][LEFT] = 1;
        }

        for (int i = 0; i < m; i++) {
            if(matrix[0][i] == 'x'){
                dp[0][i][TOP] = 2;
            }
            dp[0][i][TOP] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( matrix[i][j] == 'o') {
                    if (i > 0){
                        dp[i][j][TOP] = dp[i-1][j][TOP];
                    } else {
                        dp[i][j][TOP] = 1;
                    }

                    if (j > 0){
                        dp[i][j][LEFT] = dp[i][j-1][LEFT];
                    } else {
                        dp[i][j][LEFT] = 1;
                    }
                }

                if( matrix[i][j] == 'x') {
                    dp[i][j][TOP] = 1;
                    dp[i][j][LEFT] = 1;
                }

                if(matrix[i][j] == 'e') {
                    if(i > 0){
                        dp[i][j][TOP] = matrix[i-1][j] == 'e' ? dp[i-1][j][TOP] + 1 : 2;
                    } else {
                        dp[i][j][TOP] = 2;
                    }

                    if(j > 0){
                        dp[i][j][LEFT] = matrix[i][j-1] == 'e' ? dp[i][j-1][LEFT] + 1 : 2;
                    } else {
                        dp[i][j][LEFT] = 2;
                    }
                }
            }
        }


        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if( matrix[i][j] == 'o') {
                    if (i+1 <= n -1){
                        dp[i][j][BOTTOM] = dp[i+1][j][BOTTOM];
                    } else {
                        dp[i][j][BOTTOM] = 1;
                    }

                    if (j+1 < n -1){
                        dp[i][j][RIGHT] = dp[i][j+1][RIGHT];
                    } else {
                        dp[i][j][RIGHT] = 1;
                    }
                }

                if( matrix[i][j] == 'x') {
                    dp[i][j][BOTTOM] = 1;
                    dp[i][j][RIGHT] = 1;
                }

                if(matrix[i][j] == 'e') {
                    if(i+1 <= n -1){
                        dp[i][j][BOTTOM] = matrix[i+1][j] == 'e' ? dp[i+1][j][BOTTOM] + 1 : 2;
                    } else {
                        dp[i][j][BOTTOM] = 2;
                    }

                    if(j+1 < n -1){
                        dp[i][j][RIGHT] = matrix[i][j+1] == 'e' ? dp[i][j+1][RIGHT] + 1 : 2;
                    } else {
                        dp[i][j][RIGHT] = 2;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
        }

    }
}
