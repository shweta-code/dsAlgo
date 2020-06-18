package com.algos.codeForces.math;

import org.junit.Assert;
import org.junit.Test;

public class MixingWaterTest {

    MixingWater mixingWater = new MixingWater();


    @Test
    public void _1(){
        System.out.println(1e10);
        Assert.assertEquals(9,MixingWater.findMinNoOfCups(438837 ,375205 ,410506));

    }

    @Test
    public void _2(){
        Assert.assertEquals(7,MixingWater.findMinNoOfCups(41 ,15 ,30));

    }

    @Test
    public void _3(){
        Assert.assertEquals(2,MixingWater.findMinNoOfCups(666918 ,181133, 387229));

    }

    @Test
    public void _4(){
        Assert.assertEquals(1,MixingWater.findMinNoOfCups(7 ,1, 6));

    }

    @Test
    public void _5(){
        Assert.assertEquals(499981,MixingWater.findMinNoOfCups(999977 ,17, 499998));

    }
}
