package com.algos.leetCode.binarySearch;

import com.algos.leetcode.binarySearch.ProblemNo34;
import org.junit.Assert;
import org.junit.Test;

public class Problem34Test {

    ProblemNo34 problemNo34 = new ProblemNo34();

    @Test
    public void test1(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{5,7,7,8,8,10}, 8),new int[]{3,4});
    }

    @Test
    public void test2(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{5,7,7,8,8,10}, 6),new int[]{-1,-1});
    }

    @Test
    public void test3(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{}, 8),new int[]{-1, -1});
    }

    @Test
    public void test4(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{1}, 1),new int[]{0, 0});
    }

    @Test
    public void test5(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{-1,1,1,1,2,3,4,5}, 1),new int[]{1, 3});
    }

    @Test
    public void test6(){
        Assert.assertArrayEquals(problemNo34.findTarget(new int[]{-105, 105}, 105),new int[]{1, 1});
    }
}
