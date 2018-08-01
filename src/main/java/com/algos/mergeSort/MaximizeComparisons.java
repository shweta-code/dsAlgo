package com.algos.mergeSort;


public class MaximizeComparisons {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i : input) {
            System.out.print(i + " ");
        }
        maximizeComparisons(input, 0, input.length - 1);
        System.out.println();
        for (int i : input) {

            System.out.print(i + " ");

        }
    }

    private static void maximizeComparisons(int[] input, int low, int high) {

        int mid = (low + high) / 2;
        if (input[high] > input[mid]) {
            swap(input, mid, high);
        }
        System.out.println();
        for (int i : input) {
            System.out.print(i + " ");

        }
        if (low < high) {
            maximizeComparisons(input, low, mid);
            maximizeComparisons(input, mid + 1, high);
        }

    }

    private static void swap(int[] input, int i, int i1) {
        int temp = input[i];
        input[i] = input[i1];
        input[i1] = temp;

    }
}
