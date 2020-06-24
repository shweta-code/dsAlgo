package com.algos.codeForces.bitOperators;

import java.util.Arrays;

//https://codeforces.com/contest/1368/problem/D
public class AndOrAndSquareSum {

    public static void main(String[] args) {
        D.solve(5, new int[]{1,2,3,4,5});
        //System.out.println(1|2);
        //System.out.println(Math.pow(2,20) > Integer.MAX_VALUE);
    }

    protected long findSum(int[] arr){

        int length = arr.length;
        if(length ==1){
            return (long) Math.pow(arr[0], 2);
        }
        Arrays.sort(arr);
        //for ()
        for (int i = length-1; i > 0 ; i--) {

        }
        return 0;
    }


}
//Taken from accepted Solution
class D {

    static void solve(int n, int[] arr) {
        int cnt[] = new int[20];
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            //System.out.println(a);
            for (int j = 0; j < 20; j++) {
                //System.out.println((a & (1 << j)));
                if ((a & (1 << j)) != 0) {
                    ++cnt[j];
                }
            }
        }
        for (int i : cnt) {
            System.out.printf("%d", i);
        };
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long cur = 0;
            for (int j = 0; j < 20; j++) {
                System.out.println("cnt[j] != 0 " + (cnt[j] != 0));
                if (cnt[j] != 0) {
                    System.out.println("1L << j "+ (1L << j));
                    cur |= 1L << j;
                    System.out.println("cur "+cur);
                    --cnt[j];
                }
            }
            for (int k : cnt) {
                System.out.printf("%d", k);
            };
            ans += cur * cur;
        }
        System.out.println(ans);
    }


}


