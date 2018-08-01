package com.algos.recurssion;


public class PrintAllPossibleCombinationsOfRElementsInAGivenArrayOfSizeN {

    public static void main(String[] args) {
        final int[] arr = {1, 2, 3, 4};
        generator(arr, 2);
    }

    private static void generator(int[] arr, int r) {
        generate(arr, new int[r], 0, r, 0);
    }

    private static void generate(int[] arr, int[] result, int k, int r, int currentIndex) {

        if (result[r - 1] != 0) {
            System.out.println();
            for (int i : result) {
                System.out.print(" " + i);
            }
            return;
        }
        for (int i = k; i < arr.length; i++) {
            result[currentIndex] = arr[i];
            generate(arr, result, i + 1, r, currentIndex + 1);
        }
    }
}

