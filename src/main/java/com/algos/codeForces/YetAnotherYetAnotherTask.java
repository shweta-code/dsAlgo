package com.algos.codeForces;

import java.util.Scanner;

//https://codeforces.com/contest/1359/problem/D

/*
*
* This is a twisted version of FindMaxSumContigousSubArray - KADANE's Algorithm
* */
public class YetAnotherYetAnotherTask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        long maxPossibleScore = findMaxPossibleScore(input);
        System.out.println(maxPossibleScore);

    }


    public static long findMaxPossibleScore(int[] arr) {

        int len = arr.length;
        long maxSumSoFar  = arr[0];
        int maxElement = arr[0];
        long currenSum = arr[0];
        long prevSum = arr[0];
        int left = 0;
        int right = 0;

        long maxScore = 0; // Minimum possible score


        //TODO test case - one ore more elements are negative or zero
        //iterate if all elemnets are negative return 0;
        boolean allNegativeNos = Boolean.FALSE;
        for (int anArr : arr) {
            if(anArr > 0){
                allNegativeNos = Boolean.FALSE;
                break;
            }
        }
        if(allNegativeNos){
            System.out.println("All nos are negative");
            return 0;
        }


        for (int i = 1; i < len; i++) {
            currenSum =  currenSum+arr[i];
            if(currenSum > prevSum){
                right++;
                maxSumSoFar = Math.max(maxSumSoFar, currenSum);
                maxElement = Math.max(maxElement, arr[i]);
            } else {


            }

            if((currenSum - maxElement) <0) {

            } else if(currenSum == arr[i]){


            } else {

            }
            maxScore = Math.max(maxScore, (maxSumSoFar - maxElement));
            prevSum = currenSum;
            System.out.println(maxScore);

        }

        return maxScore;
    }
}

//Correct Solution
/*
include <bits/stdc++.h>
        using namespace std;
        typedef long long ll;
        const int INF = 1e9;
        const int maxn = 100105;
        int a[maxn];
        int main(){
        int n;scanf("%d",&n);
        for(int i=1;i<=n;i++) scanf("%d",&a[i]);
        int ans=0;
        for(int mx=30;mx>=-30;mx--) {
        int sum=0;
        for(int i=1;i<=n;i++) {
        int val=(a[i]>mx?-INF:a[i]);
        sum=max(sum,0)+val;
        ans=max(ans,sum-mx);
        //printf("ans=%d,sum=%d,a[%d]=%d,mx=%d\n",ans,sum,i,a[i],mx);
        }
        }
        printf("%d\n",ans);
        return 0;
        }*/
//Copied Accepted Solution
class X{

    double INF = -1e9;
    protected static int findMaxPossibleScore(int[] arr){
        int len = arr.length;
        int ans = 0;
        for (int mx = 30 ; mx >= -30 ; mx++) {
            int sum =0;
            for (int i  = 1; i < len ; i++) {
                int val = arr[i] > mx ? Integer.MIN_VALUE : arr[i];
                sum = Math.max(sum , 0) +val;
                ans = Math.max(ans, sum-mx);

            }
        }
        return ans;
    }
}