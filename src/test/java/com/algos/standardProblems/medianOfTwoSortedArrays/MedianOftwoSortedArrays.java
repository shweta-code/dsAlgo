package com.algos.standardProblems.medianOfTwoSortedArrays;

// InspiredFrom
// Approach#2 -> https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
public class MedianOftwoSortedArrays implements IMedianOfTwoSortedArrays{


    @Override
    public double calculateMedian(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        int m1 = -1;
        int m2 = -1;
        int totLen = len1 + len2;
        int i = 0;
        int j = 0;
        if (totLen % 2 == 0) {
            for (int count = 0; count <= (len1+len2)/2; count++) {
                m2 = m1;
                if (i != len1 && j != len2) {
                    m1 = a[i] < b[j] ? a[i++] : b[j++];
                } else if (i < len1) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return (m1 + m2)/2.0;
        } else {
            for (int count = 0; count <= (len1+len2)/2; count++) {
                if (i != len1 && j != len2) {
                    m1 = a[i] < b[j] ? a[i++] : b[j++];
                } else if (i < len1) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return m1;
        }
//        return 0.0;
    }
}
