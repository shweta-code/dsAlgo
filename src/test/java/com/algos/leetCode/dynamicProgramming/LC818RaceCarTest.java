package com.algos.leetCode.dynamicProgramming;

import com.algos.leetcode.dynamicProgramming.LC818RaceCarWrong;
import org.junit.Assert;
import org.junit.Test;

public class LC818RaceCarTest {

    private final LC818RaceCarWrong raceCar = new LC818RaceCarWrong();
    @Test
    public void test1() {
        int noOfInstructions = raceCar.racecar(1);
        Assert.assertEquals(1, noOfInstructions);
    }

    @Test
    public void test2() {
        int noOfInstructions = raceCar.racecar(3);
        Assert.assertEquals(2, noOfInstructions);
    }


    @Test
    public void test3() {
        int noOfInstructions = raceCar.racecar(7);
        Assert.assertEquals(3, noOfInstructions);
    }

    @Test
    public void test4() {
        int noOfInstructions = raceCar.racecar(15);
        Assert.assertEquals(4, noOfInstructions);
    }

    @Test
    public void test5() {
        int noOfInstructions = raceCar.racecar(31);
        Assert.assertEquals(5, noOfInstructions);
    }

    @Test
    public void test6() {
        int noOfInstructions = raceCar.racecar(63);
        Assert.assertEquals(6, noOfInstructions);
    }

    @Test
    public void test7() {
        int noOfInstructions = raceCar.racecar(2);
        Assert.assertEquals(4, noOfInstructions);
    }
}
