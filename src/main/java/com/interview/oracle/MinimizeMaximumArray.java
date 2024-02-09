package com.interview.oracle;

public class MinimizeMaximumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,6};
        minimzeMaximumOfArr(arr);
        minimzeMaximumOfArr(new int[]{10,2});
        minimzeMaximumOfArr(new int[]{2, 10});
    }

    private static void minimzeMaximumOfArr(int[] arr) {
        int maxIndex;
        do{
            maxIndex = MaxIndex(arr);
            if(maxIndex > 0) {
                int sumOfConsecutives = arr[maxIndex] + arr[maxIndex - 1];
                int half = sumOfConsecutives / 2;
                arr[maxIndex - 1] = sumOfConsecutives % 2 == 0 ? half : half + 1;
                arr[maxIndex] = half;
            }

        } while(maxIndex > 0);

        System.out.println(arr[maxIndex]);
    }

    private static int MaxIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            // Handle the case when the array is empty or null.
            return -1; // You can choose to return -1 or another appropriate value.
        }

        int maxIndex = 0; // Initialize the index of the maximum number to the first element.
        int maxValue = arr[0]; // Initialize the maximum value to the first element.

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

// Clarifications , Assumptions
// 1. type of input -> Are doubles there?
// 2. bounds of input -> min, max value

// Test Cases
// [2,2,2,2]; [10,4,5,6]; [-1,-8,-9,0]; [2,5,7,1]


// Time Complexity, Space Complexity






