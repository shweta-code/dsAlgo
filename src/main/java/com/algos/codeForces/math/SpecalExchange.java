package com.algos.codeForces.math;

import java.util.*;


//https://codeforces.com/contest/1372/problem/C
public class SpecalExchange {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
    }

        public static int solve(int[] arr){
            boolean inOrder = true;
            int len = arr.length;
            //int[] outOrderIndex = new int[len];
            List<Integer> outOrderIndex = new ArrayList<>();
            //int oo = 0;

            //int outOfOrderElemsNo = 0;
            //int outOfOrderLastIndex =  -1;
           // boolean isAdjOutOfOrder = true;

            for(int i = 1 ; i <= len ; i++){
                if(! (i == arr[i-1])){
                    inOrder = false;
                    //outOrderIndex[oo++] = i;
                    //outOfOrderElemsNo++;
                    /*isAdjOutOfOrder = isAdjOutOfOrder && (i != (outOfOrderLastIndex + 1));
                    outOfOrderLastIndex = i;*/

                    outOrderIndex.add(i);

                }
            }

            if(outOrderIndex.size() == 0){
                return 0;
            }

            if(outOrderIndex.size() == len){
                return 1;
            }

            //out of order are adjacent
            boolean isAdjOutOfOrder = false;
            int x = outOrderIndex.get(0);
            for (int i = 1; i < outOrderIndex.size() ; i++) {
                if(outOrderIndex.get(i) == outOrderIndex.get(i-1)+1){
                    isAdjOutOfOrder = true;
                } else {
                    isAdjOutOfOrder = false;
                    break;
                }
            }

            if(isAdjOutOfOrder){
                return 1;
            }

            return 2;


        }


}