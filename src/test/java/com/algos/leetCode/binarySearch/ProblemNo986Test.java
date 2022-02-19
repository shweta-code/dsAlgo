package com.algos.leetCode.binarySearch;

import com.algos.leetcode.binarySearch.ProblemNo34;
import com.algos.leetcode.binarySearch.ProblemNo986;
import org.junit.Assert;
import org.junit.Test;

public class ProblemNo986Test {

    ProblemNo986 problemNo34 = new ProblemNo986();

    @Test
    public void test1(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,4}}, new int[][]{{0,2}}),new int[][]{});
    }

    @Test
    public void test2(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,4}}, new int[][]{{-2,-1},{0,2}}),new int[][]{});
    }

    @Test
    public void test3(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,4}}, new int[][]{{-2,-1},{0,2}, {3,4}}),new int[][]{{3,4}});
    }

    @Test
    public void test4(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,5}}, new int[][]{{-2,-1},{0,2}, {3,4}}),new int[][]{{3,4}});
    }

    @Test
    public void test5(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,5},{6,7}}, new int[][]{{-2,-1},{0,2}, {3,4}}),new int[][]{{3,4}});
    }

    @Test
    public void test6(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,4}}, new int[][]{{2,7}}),new int[][]{{3,4}});
    }

    @Test
    public void test7(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,6}}, new int[][]{{-2,-1},{4,7}}),new int[][]{{4,6}});
    }

    @Test
    public void test8(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{3,6},{7,10}}, new int[][]{{4,7},{8,10}}),new int[][]{{4,6}, {7,7}, {8,10}});
    }

    @Test
    public void test9(){

        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}}),new int[][]{{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}});
    }

    /*@Test
    public void test2(){
        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[]{5,7,7,8,8,10}, 6),new int[]{-1,-1});
    }

    @Test
    public void test3(){
        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[]{}, 8),new int[]{-1, -1});
    }

    @Test
    public void test4(){
        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[]{1}, 1),new int[]{0, 0});
    }

    @Test
    public void test5(){
        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[]{-1,1,1,1,2,3,4,5}, 1),new int[]{1, 3});
    }

    @Test
    public void test6(){
        Assert.assertArrayEquals(problemNo34.intervalIntersection(new int[]{-105, 105}, 105),new int[]{1, 1});
    }*/
}
