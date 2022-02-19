package com.algos.binarySearch;

public class BinarySearch {

    public int findTarget (int[] arr, int target) {
        int index = binarySearch(arr, 0 , arr.length-1, target);
        System.out.println(" Answer " + index);
        return index;
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {

        while( low <= high && low >=0 && high < arr.length) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                return mid;

            } else if (arr[mid]> target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

}
