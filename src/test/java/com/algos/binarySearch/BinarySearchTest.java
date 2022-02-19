package com.algos.binarySearch;

import com.algos.leetcode.binarySearch.ProblemNo34;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    BinarySearch problemNo34 = new BinarySearch();

    @Test
    public void basicPositiveTest(){
        Assert.assertEquals(problemNo34.findTarget(new int[]{1,2, 3}, 2),1);
    }

    @Test
    public void emptyArr(){
        Assert.assertEquals(problemNo34.findTarget(new int[]{}, 2),-1);
    }

    @Test
    public void singleElementNonExistent(){
        Assert.assertEquals(problemNo34.findTarget(new int[]{1}, 2),-1);
    }

    @Test
    public void endElement(){
        Assert.assertEquals(problemNo34.findTarget(new int[]{1,2}, 2),1);
    }

    @Test
    public void singleElementExistent(){
        Assert.assertEquals(problemNo34.findTarget(new int[]{2}, 2),0);
    }
}
