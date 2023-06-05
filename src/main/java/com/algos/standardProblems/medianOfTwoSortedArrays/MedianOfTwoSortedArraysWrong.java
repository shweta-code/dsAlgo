package com.algos.standardProblems.medianOfTwoSortedArrays;

// InspiredFrom
// Approach#2 -> https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
public class MedianOfTwoSortedArraysWrong implements IMedianOfTwoSortedArrays {

    public double calculateMedian(int[] arr1, int[] arr2) {


//        int k = (i + j) / 2;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int totalLength = len1 + len2;

        int i = 0;
        int j = 0;
        int median =  (len1 + len2) % 2 == 0 ? ((len1 + len2) / 2) - 1 : (len1 + len2) / 2;
        int step = 0;
        while (i < len1 && j < len2 && step < median) {
            if (arr1[i] < arr2[j]) {
                i++;
                step++;
            } else {
                j++;
                step++;
            }
        }

        if (i == len1) {
            // optimize to go to that index directly
            while (j < len2 && step < median) {
                j++;
                step++;
            }
            if (totalLength % 2 == 1) {
                return arr2[j];
            } else {
                return (arr2[j] + arr2[j+1])/2.0;
            }
        }

        if (j == len2) {
            while (i < len2 && step < median) {
                i++;
                step++;
            }
            if (totalLength % 2 == 1) {
                return arr1[i];
            } else {
                return (arr1[i] + arr1[i+1])/2.0;
            }
        }

        if (totalLength % 2 == 1) {
            return Math.min(arr1[i], arr2[j]);
        } else {
            int m1 = Math.min(arr1[i], arr2[j]);
            int m2 = arr1[i] < arr2[j] ? ++i == len1 ? arr2[j] : Math.min(arr1[++i], arr2[j]) : Math.min(arr1[i], arr2[++j]);
            return (m1 + m2)/2.0;
        }

    }

}
