package com.algos.standardProblems.medianOfTwoSortedArrays;

import org.junit.Assert;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

    private final IMedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArraysUsingBS();

    @Test
    public void test1() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{12, 13, 14}, new int[]{1, 2, 3, 4});
        Assert.assertEquals(4.0, median, 0.0);
    }

    @Test
    public void test2() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{12, 13, 14}, new int[]{1, 2, 3});
        Assert.assertEquals(7.5, median, 0.0);
    }

    @Test
    public void test3() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{12, 13, 14}, new int[]{1, 2, 3});
        Assert.assertEquals(7.5, median, 0.0);
    }

    @Test
    public void test4() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{12, 13, 14, 15, 16}, new int[]{});
        Assert.assertEquals(14, median, 0.0);
    }

    @Test
    public void test5() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{}, new int[]{12, 13, 14, 15, 16});
        Assert.assertEquals(14, median, 0.0);
    }

    @Test
    public void test6() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{ 1, 2, 7, 12}, new int[]{3, 4, 5, 6});
        Assert.assertEquals(4.5, median, 0.0);
    }

    @Test
    public void test7() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{ 1, 2, 7, 12}, new int[]{3, 4, 5, 6});
        Assert.assertEquals(4.5, median, 0.0);
    }

    @Test
    public void test8() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{ 1, 2, 7, 12, 13}, new int[]{3, 4, 5, 6});
        Assert.assertEquals(5, median, 0.0);
    }

    @Test
    public void test9() {
        double median = medianOfTwoSortedArrays.calculateMedian(new int[]{ 12, 13, 14}, new int[]{1, 2, 3, 4, 5, 6, 7});
        Assert.assertEquals(5.5, median, 0.0);
    }
}
