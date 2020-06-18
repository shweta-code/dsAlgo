package com.algos.codeForces;

import org.junit.Assert;
import org.junit.Test;

public class YetAnotherYetAnotherTaskTest {

    X findMaxPossibleScore1 = new X();
    @Test
    public void happy(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{1, 2, 3});
        Assert.assertEquals(3 , maxSumSubArray);

    }


    @Test
    public void negativeNumbers(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{-1, -2, -3});
        Assert.assertEquals(0 , maxSumSubArray);

    }

    @Test
    public void _1(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{5, 30 , -30, 2 , 1});
        Assert.assertEquals(5 , maxSumSubArray);

    }

    @Test
    public void _2(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{5, 30 , -30, 2 , 1 , 1000});
        Assert.assertEquals(1008 , maxSumSubArray);

    }

    @Test
    public void _3(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{-2, -3 , 4, -1, -2, 1, 5 , -3});
        Assert.assertEquals(2 , maxSumSubArray);

    }



    @Test
    public void _6(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{0,0 ,0});
        //Assert.assertTrue( maxSumSubArray == 3*Integer.MAX_VALUE);
        Assert.assertEquals(0, maxSumSubArray);

    }

    @Test
    public void _7(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{-1,-2 ,-3});
        //Assert.assertTrue( maxSumSubArray == 3*Integer.MAX_VALUE);
        Assert.assertEquals(0, maxSumSubArray);

    }
    @Test
    public void _8(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{-1,0,0});
        //Assert.assertTrue( maxSumSubArray == 3*Integer.MAX_VALUE);
        Assert.assertEquals(0, maxSumSubArray);

    }

    @Test
    public void _9(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{5 ,-2, 10, -1, 4});
        Assert.assertEquals(6, maxSumSubArray);

    }

    @Test
    public void _10(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{5, 2, 5, 3, -30, -30, 6, 9});
        Assert.assertEquals(10, maxSumSubArray);


    }
    @Test
    public void _11(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{-10, 6 ,-15});
        Assert.assertEquals(0, maxSumSubArray);

    }@Test
    public void _12(){
        long maxSumSubArray = findMaxPossibleScore1.findMaxPossibleScore(new int[]{3 ,0 ,1, -2, 5 ,-5, -1, 0 ,3 ,2 ,2});
        Assert.assertEquals(4, maxSumSubArray);

    }

}
