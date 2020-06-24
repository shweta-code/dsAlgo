package com.algos.codeForces.math;


import java.util.Scanner;

//https://codeforces.com/contest/1368/status
public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i = 0 ; i< testCases ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(minimumNoOfOperations(a,b,n));
        }

    }

    protected static int minimumNoOfOperations(int a , int b , int n){
        int great = 0;
        int small = 0;
        if( a==n || b ==n){
            return 1;
        } else if(a > b){
            great = a;
            small = b;
        } else if(b > a){
            great = b;
            small = a;
        } else {
            great = a;
            small = b;
        }

        int sum =0;
        int noOfOperatiosn = 0;
        while ( great <= n){
            small += great;
            noOfOperatiosn++;


            int temp = small;
            small = great;
            great = temp;
        }
        return noOfOperatiosn;
    }
}
