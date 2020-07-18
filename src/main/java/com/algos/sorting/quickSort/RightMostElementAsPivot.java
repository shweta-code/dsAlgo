package com.algos.sorting.quickSort;

import java.util.Arrays;

public class RightMostElementAsPivot {

    public static void main(String[] args) {
        int[] input = {5, 4, 3, 2, 1};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] input, int low, int high) {

        if (low < high) {
            int pivot = partition(input, low, high);
            quickSort(input, low, pivot - 1);
            quickSort(input, pivot + 1, high);
        }
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = high;
        int i = low;
        for (int j = low; j < high; j++) {
            if (input[j] < input[pivot]) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, i, pivot);
        return i;
    }

    private static void swap(int[] input, int i, int i1) {
        int temp = input[i];
        input[i] = input[i1];
        input[i1] = temp;

    }

}
