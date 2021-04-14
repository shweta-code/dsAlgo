package com.algos.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuperUglyNumber_LeetCode313 {

    public static void main(String[] args) {
        System.out.println(superUglyNumberBruteForce(4, new int[]{2,7,13,19}));
    }
    public  static double superUglyNumberBruteForce(int n , int[] primes){
        List<Double> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1.0);
        for (int i = 1; i <= n; i++) {
            for (int prime : primes) {
                double x =  Math.pow(prime, i);
                List<Double> newUglyNumbers = new ArrayList<>();
                for (Double uglyNumber : uglyNumbers) {
                    double newUglyNumber = uglyNumber * x;
                    System.out.println(newUglyNumber);
                    newUglyNumbers.add(newUglyNumber);
                }
                uglyNumbers.addAll(newUglyNumbers);
            }
        }
        uglyNumbers.sort(Comparator.naturalOrder());
        return uglyNumbers.get(n-1);
        
        /*return 0;*/
    }
}
