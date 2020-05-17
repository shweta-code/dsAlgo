package com.algos.codeForces.dp;


import java.util.Scanner;

/*https://atcoder.jp/contests/dp/tasks/dp_a*/
public class AFrog1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            int height = sc.nextInt();
            input[i] = height;

        }
        System.out.println(findMinCost(input));

        /*int[] input = {30, 10, 60, 10, 60, 50};
        System.out.println(findMinCost(input));*/
    }

    public static int findMinCost(int[] input){
        int length = input.length;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = Math.abs(input[1]  - input[0]);


        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min((dp[i-2] + Math.abs(input[i] - input[i-2])), (dp[i-1] + Math.abs(input[i] - input[i-1])));
        }

        return dp[length - 1];
    }

}
