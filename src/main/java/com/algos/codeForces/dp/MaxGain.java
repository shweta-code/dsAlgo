package com.algos.codeForces.dp;

import java.io.*;
import java.util.*;
//https://atcoder.jp/contests/dp/tasks/dp_c
class Main1 {
    static int[][] a;
    static int[][] dp;
    static int n;
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a=new int[n][3];
        dp=new int[n][3];
        for(int[] i:dp)Arrays.fill(i,-1);
        for(int i=0;i<n;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            a[i][2]=sc.nextInt();
        }
        int ans=0;
        ans=a[0][0]+solve(1,0);
        ans=Math.max(ans,a[0][1]+solve(1,1));
        ans=Math.max(ans,a[0][2]+solve(1,2));
        System.out.println(ans);
    }
    static int solve(int nextDay,int chosenActivityInCurrentDay){
        if(nextDay==n)return 0;
        if(dp[nextDay][chosenActivityInCurrentDay]!=-1)return dp[nextDay][chosenActivityInCurrentDay];
        int ans=0;
        if(chosenActivityInCurrentDay==0){
            ans=Math.max(ans,a[nextDay][1]+solve(nextDay+1,1));
            ans=Math.max(ans,a[nextDay][2]+solve(nextDay+1,2));
        }
        else if(chosenActivityInCurrentDay==1){
            ans=Math.max(ans,a[nextDay][0]+solve(nextDay+1,0));
            ans=Math.max(ans,a[nextDay][2]+solve(nextDay+1,2));
        }
        else{
            ans=Math.max(ans,a[nextDay][0]+solve(nextDay+1,0));
            ans=Math.max(ans,a[nextDay][1]+solve(nextDay+1,1));
        }
        dp[nextDay][chosenActivityInCurrentDay]=ans;
        return dp[nextDay][chosenActivityInCurrentDay];
    }
}

public class MaxGain{

}
