package com.algos.codeForces.math;

import org.junit.Assert;
import org.junit.Test;

public class SpecalExchangeTest {
    @Test
    public void _1(){

        Assert.assertEquals(0, SpecalExchange.solve(new int[]{1,2,3}));
    }

    @Test
    public void _2(){

        Assert.assertEquals(1, SpecalExchange.solve(new int[]{1,3,2}));
    }@Test
    public void _3(){

        Assert.assertEquals(2, SpecalExchange.solve(new int[]{3,2,1}));
    }
    @Test
    public void _4(){

        Assert.assertEquals(1, SpecalExchange.solve(new int[]{3,1,2}));
    }
}
