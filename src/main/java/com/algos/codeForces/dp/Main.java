package com.algos.codeForces.dp;

import java.util.Scanner;

//https://atcoder.jp/contests/dp/tasks/dp_c
//Could not be Accepted. Wrong.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        long[][] input = new long[rows][3];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                long happiness = sc.nextInt();
                input[i][j] = happiness;
            }
        }
        System.out.println(findMaxGain(input));

    }

    public static long findMaxGain(long[][] happinessArr){

        long[] dp = new long[3];

        for (int i = 0; i < 3; i++) {
            dp[i] = happinessArr[0][i];
        }

        long rows = happinessArr.length;
        for (int row = 1; row < rows; row++) {
            MaxAndSecondMax maxAndSecondMax = findMaxAndSecMax(dp);
            for (int col = 0; col < 3; col++) {
                dp[col] = happinessArr[row][col] + findMaxHappTillPrevDay(maxAndSecondMax, col);
            }
        }

        MaxAndSecondMax maxAndSecMax = findMaxAndSecMax(dp);
        return maxAndSecMax.getMax();
    }


    private static MaxAndSecondMax findMaxAndSecMax(long[] arr){
        MaxAndSecondMax obj = new MaxAndSecondMax();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(obj.getMax() < arr[i]){
                obj.setSecndMax(obj.getMax());
                obj.setSecndMaxIndex(obj.getMaxIndex());
                obj.setMax(arr[i]);
                obj.setMaxIndex(i);
            }

            if(arr[i] > obj.getSecndMax() && arr[i] < obj.getMax()){
                obj.setSecndMax(arr[i]);
                obj.setSecndMaxIndex(i);
            }
        }

        return obj;
    }

    private static long findMaxHappTillPrevDay(MaxAndSecondMax maxAndSecondMax, long col){
        if(col != maxAndSecondMax.getMaxIndex()){
            return maxAndSecondMax.getMax();
        } else {
            return maxAndSecondMax.getSecndMax();
        }
    }
}

class MaxAndSecondMax {
    long max = -1;
    long maxIndex = -1;
    long secndMax = -2;
    long secndMaxIndex = -1;

    public long getMax() {
        return max;
    }

    public long getMaxIndex() {
        return maxIndex;
    }

    public long getSecndMax() {
        return secndMax;
    }

    public long getSecndMaxIndex() {
        return secndMaxIndex;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setMaxIndex(long maxIndex) {
        this.maxIndex = maxIndex;
    }

    public void setSecndMax(long secndMax) {
        this.secndMax = secndMax;
    }

    public void setSecndMaxIndex(long secndMaxIndex) {
        this.secndMaxIndex = secndMaxIndex;
    }
}


