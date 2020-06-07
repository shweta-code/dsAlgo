package com.algos.standards;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxSumSubArray2Test {

    FindMaxSumSubArray2 findMaxSumSubArray2 = new FindMaxSumSubArray2();
    @Test
    public void happy(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{1, 2, 3});
        Assert.assertEquals(6 , maxSumSubArray);

    }


    @Test
    public void negativeNumbers(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{-1, -2, -3});
        Assert.assertEquals(-1 , maxSumSubArray);

    }

    @Test
    public void _1(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{5, 100 , -100, 2 , 1});
        Assert.assertEquals(105 , maxSumSubArray);

    }

    @Test
    public void _2(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{5, 100 , -100, 2 , 1 , 1000});
        Assert.assertEquals(1008 , maxSumSubArray);

    }

    @Test
    public void _3(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{-2, -3 , 4, -1, -2, 1, 5 , -3});
        Assert.assertEquals(7 , maxSumSubArray);

    }


    @Test
    public void _4(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{Integer.MAX_VALUE , Integer.MAX_VALUE, Integer.MAX_VALUE});
        //Assert.assertTrue( maxSumSubArray == 3*Integer.MAX_VALUE);
        long l = (long) Integer.MAX_VALUE * 3;
        Assert.assertEquals(l, maxSumSubArray);

    }


    @Test
    public void _5(){
        long maxSumSubArray = findMaxSumSubArray2.findMaxSumSubArray(new int[]{Integer.MIN_VALUE , Integer.MIN_VALUE, Integer.MIN_VALUE});
        //Assert.assertTrue( maxSumSubArray == 3*Integer.MAX_VALUE);
        long l = Integer.MIN_VALUE ;
        Assert.assertEquals(l, maxSumSubArray);

    }

}
