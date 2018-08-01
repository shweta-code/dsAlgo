package com.algos.BinarySearch;


public class FindLocalMinima {

    public static void main(String[] args) {

        //check first number
        //int[] arr={1,2,3,4};
        int[] arr = {2, 1, 3, 4, 10, 8, 11};
        firstMinima(arr);
    }

    public static void firstMinima(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int minima = Integer.MIN_VALUE;
        while (low < high) {
            mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                    (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                minima = arr[mid];
                high = mid - 1;
            } else if (mid - 1 >= 0 && arr[mid] > arr[mid - 1]) {
                high = mid - 1;
            } else if (mid + 1 <= high && arr[mid] > arr[mid + 1]) {
                low = mid + 1;
            }

        }
        System.out.println(minima);
    }
}
