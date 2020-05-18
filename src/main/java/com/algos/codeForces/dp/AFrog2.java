package com.algos.codeForces.dp;


import java.util.Scanner;

/*https://atcoder.jp/contests/dp/tasks/dp_a*/
public class AFrog2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        int k = sc.nextInt();
        for (int i = 0; i < length; i++) {
            int height = sc.nextInt();
            input[i] = height;

        }
        System.out.println(findMinCost(input, k));

        /*int[] input = {10,  20, 10};
        System.out.println(findMinCost(input, 1));*/
    }

    public static int findMinCost(int[] input , int step){
        int length = input.length;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = Math.abs(input[1]  - input[0]);


        for (int current = 2; current < dp.length; current++) {
            dp[current] = Integer.MAX_VALUE;
            for (int back = ((current-step)< 0) ? 0 : (current-step) ; back <= current-1 ; back++) {

                dp[current] = Math.min((dp[back] + Math.abs(input[current] - input[back])), dp[current]);
            }
        }

        return dp[length - 1];
    }

}
