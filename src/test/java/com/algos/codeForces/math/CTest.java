package com.algos.codeForces.math;

import org.junit.Assert;
import org.junit.Test;

public class CTest {
    @Test
    public void allThreeAreSame(){
        Assert.assertEquals(1,C.minimumNoOfOperations(1,1,1));
    }
    @Test
    public void _2(){
        Assert.assertEquals(2,C.minimumNoOfOperations(1,2,3));
    }@Test
    public void _3(){
        Assert.assertEquals(7,C.minimumNoOfOperations(5,4,100));
    }
    @Test
    public void _4(){
        Assert.assertEquals(3,C.minimumNoOfOperations(10 ,20,79));
    }
}
