package com.algos.sorting.quickSort;


public class LeftMostElementAsPivot {

    public static void main(String[] args) {
        int[] input = {75, 8, 3, 12, 99, 64, 48, 7};
        quickSort1(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + " ");
        }

    }

    protected static void quickSort1(int[] input, int low, int high) {

        if (low < high) {
            int pivot = partition(input, low, high);
            quickSort1(input, low, pivot - 1);
            quickSort1(input, pivot + 1, high);

        }

    }

    private static int partition(int[] input, int low, int high) {
        int pivot = low;
        int i = high;
        for (int j = high; j > low; j--) {
            if (input[j] > input[pivot]) {

                swap(input, i, j);
                i--;
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
