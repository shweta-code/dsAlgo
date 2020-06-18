package com.algos.codeForces.math;


import java.util.Scanner;

//https://codeforces.com/contest/1366/problem/A
public class ShovelsAndSwords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int sticks = sc.nextInt();
            int diamonds = sc.nextInt();
            System.out.println(noOfEmerals(sticks , diamonds));
        }
    }

    private static int noOfEmerals(int sticks, int diamonds) {
        if( 0 == sticks || 0 == diamonds){
            return 0;
        } else if((2*sticks)< diamonds){
            return sticks;
        } else if((2*diamonds)< sticks){
            return diamonds;
        } else if((2*diamonds) == sticks){
            return diamonds;
        } else if((2*sticks)== diamonds){
            return sticks;
        } else {
            return (sticks + diamonds)/3;
        }
    }
}