package com.algos.codeForces.math;

import java.util.Scanner;

class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i< n ; i++){
            int h = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();
            System.out.printf("%d",findMinNoOfCups(h,c,t));
        }

    }

    private static int findMinNoOfCups(int h,int c,int t){
        if(t == c){
            return 2;
        }else if(h == t){
            return 1;
        }  else if(2*t == (h+c)){
            return 2;
        } else {
            int diffBetweenHotAndDesired = t - h;
            double i = (h+c)-2*t;
            return (int) ((2*Math.ceil(diffBetweenHotAndDesired / i))+1);
        }

    }
}
