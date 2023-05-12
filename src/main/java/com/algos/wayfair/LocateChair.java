package com.algos.wayfair;

import java.util.Arrays;

public class LocateChair {

    public static void main(String[] args) {
        LocateChair locateChair = new LocateChair();
        int[] solution = locateChair.solution(new int[]{2, 7, 3, 4, 9}, new int[]{1, 25, 11});
        System.out.println(Arrays.toString(solution));

    }

    public int[] solution(int[] A, int[] B) {

        //edge case
        if (A.length == 0 || B.length == 0) {
            return new int[1];
        }

        // Implement your solution here
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i]+ A[i-1];
        }
        System.out.println(Arrays.toString(A));

        // Arrays.sort(B);

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (B[i] <= A[j]) {
                    ans[i] = j+1;
                    break;
                }
            }
        }

        return ans;
    }
}
