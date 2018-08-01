package com.algos.sorting.quickSort;

public class MiddleElementAsPivot {

    public static void main(String[] args) {
        int[] input = {75, 8, 3, 12, 99, 64, 48, 7};
        int[] input2 = {5, 4, 3, 2, 1};
        quickSort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + " ");
        }

    }

    private static void quickSort(int[] input, int low, int high) {

        if (low < high) {
            int pivot = (high + low) / 2;
            int i = low;
            int j = high;
            while (i <= j) {
                while (input[i] < input[pivot]) {
                    i++;
                }
                while (input[j] > input[pivot]) {
                    j--;
                }

                if (i <= j) {//if u put i<j , the next sorts may coincide at partition //The whole funda of quick sort is it places the pivot at right place.
                    //Quick Sort will never consider pivot in next iteration.
                    swap(input, i, j);
                    i++;
                    j--;
                }
            }
            quickSort(input, low, j);
            quickSort(input, i, high);

        }

    }

    private static int partition(int[] input, int low, int high) {
        int pivot = (high + low) / 2;
        int i = low;
        int j = high;
        while (i < j) {
            while (input[i] < input[pivot]) {
                i++;
            }
            while (input[j] > input[pivot]) {
                j--;
            }

            if (i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }

        return pivot;
    }


    private static void swap(int[] input, int i, int i1) {
        int temp = input[i];
        input[i] = input[i1];
        input[i1] = temp;

    }
}
