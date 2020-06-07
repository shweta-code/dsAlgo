package com.algos.codeForces;


import java.util.Scanner;

//https://codeforces.com/contest/1347/problem/E
public class SpecialPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printWithDiffBWTwoAndFour(n);
    }

    public static int[] printWithDiffBWTwoAndFour(int n) {

        if(n == 2 || n == 3){
            return new int[]{-1};
        }

        int index = -1;
        int _4ThProd = n/4;
        int[] arr = new int[n];

        if(n%4 == 2 || n%4 == 3){
            _4ThProd = _4ThProd - 1;
        }

        for (int i = 0; i < _4ThProd; i++) {
            arr[++index] = (4*i) + 2;
            arr[++index] = (4*i) + 4;
            arr[++index] = (4*i) + 1;
            arr[++index] = (4*i) + 3;
        }

        if(n % 4 == 2 || n% 4 == 3){

            arr[++index] = (_4ThProd*4) + 2;
            arr[++index] = (_4ThProd*4) + 4;
            arr[++index] = (_4ThProd*4) + 6;
            arr[++index] = (_4ThProd*4) + 3;
            arr[++index] = (_4ThProd*4) + 1;
            arr[++index] = (_4ThProd*4) + 5;

        }

        if(n%4 == 1 || n%4 == 3){
            arr[++index] = n;
        }

        return arr;




    }
}
