package com.algos.dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class SubsetSumTest {
    @Test
    public void _1(){
        Assert.assertTrue(SubsetSum.ifSumIsPossibleInSubset(9, new int[]{3, 34, 4, 12, 5, 2}));
    }
    @Test
    public void _2(){
        Assert.assertFalse(SubsetSum.ifSumIsPossibleInSubset(30, new int[]{3, 34, 4, 12, 5, 2}));
    }


}
