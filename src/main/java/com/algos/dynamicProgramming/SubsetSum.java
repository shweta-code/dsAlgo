package com.algos.dynamicProgramming;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSum {

    protected static boolean ifSumIsPossibleInSubset(int sum , int[] arr){

        int rows = arr.length+1;
        int cols = sum+1;
        boolean[][] dp = new boolean[rows][cols];


        for (int i = 0; i < rows; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < cols ; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols ; j++) {
                if(dp[i - 1][j]){
                    dp[i][j] = true;
                    continue;
                }

                if(j - arr[i-1] < 0){
                    dp[i][j] = false;
                    continue;
                }

                dp[i][j] = dp[i-1][j-arr[i-1]];
            }

        }


        return dp[rows-1][cols-1];
    }
}
